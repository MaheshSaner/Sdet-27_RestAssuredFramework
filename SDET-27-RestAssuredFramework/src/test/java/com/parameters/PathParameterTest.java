package com.parameters;

import org.testng.annotations.Test;

import static  io.restassured.RestAssured.*;

public class PathParameterTest {

	@Test
	
	public void param() {
		
		String proID= "TY_PROJ_1208";
		
		

		given()
				.pathParam("projectID", proID)
		.when()
				.delete("http://localhost:8084/projects/{projectID}")
		.then()
				.log().all();
		

	}
}
