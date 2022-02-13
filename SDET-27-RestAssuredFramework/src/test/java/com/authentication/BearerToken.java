package com.authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BearerToken {

		@Test
		
		public void bearerToken() {
			
			given()
					.auth().oauth2("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")
			.when()
					.get("https://api.github.com/users/repos")
			.then()
					.assertThat().statusCode(200)
					.log().all();
			
			
		}

	}


