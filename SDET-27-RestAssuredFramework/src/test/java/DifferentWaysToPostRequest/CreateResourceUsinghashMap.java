package DifferentWaysToPostRequest;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateResourceUsinghashMap {

	@Test
	
	public void createUsingHashMap() {
	
		HashMap map=new HashMap();
		
		map.put("createdBy", "shaileshV");
		map.put("projectName", "TYSS_API_005");
		map.put("status", "completed");
		map.put("teamSize", 5620);
		
		given()
	     .body(map)
	     .contentType(ContentType.JSON)
	   .when()
	       	.post("http://localhost:8084/addProject")
	   .then()
	   		.assertThat().statusCode(201)
	   		.contentType(ContentType.JSON)
	   		.log().all();
	
		
	}
}
