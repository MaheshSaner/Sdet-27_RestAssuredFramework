package com.authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oauth2 {

	@Test
	
	public void oauth() {
		
		 Response response= given()
		  		.formParam("client_id", "sdet-27-API")
		  		.formParam("client_secret", "8d8af7dad66dc1c946b6c4b745638a65")
		  		.formParam("grant_type", "client_credentials")
		  		.formParam("redirect_uri", "http://example.com")
		  .when()
		  		.post("http://coop.apps.symfonycasts.com/token");
		  
		    String token=response.jsonPath().get("access_token");
		 
		    
		    given()
		    		.auth().oauth2(token)
		    		.pathParam("USER_ID", "2800")
		    .when()
		      //  .get("http://coop.apps.symfonycasts.com/api/me")
		    	//.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/barn-unlock")
		    	.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/toiletseat-down")
		    	//.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")
		      //   .post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-count")
		    
		    
		    .then()
		  			.log().all();
		  
		  
	}
}
