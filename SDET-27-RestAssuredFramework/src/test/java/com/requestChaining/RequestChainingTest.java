package com.requestChaining;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class RequestChainingTest {

	@Test
	
	public void chaining() {
		
		Response response=when()
				.get("http:localhost:8084/projects");
		
		String proID=response.jsonPath().get("[0].projectId");
		System.out.println(proID);
		
		given()
				.pathParam("projectID", proID)
		.when()
				.delete("http://localhost:8084/projects/{projectID}")
		.then()
				.assertThat().statusCode(204)
				.log().all();
	}
	       
	
	
}
