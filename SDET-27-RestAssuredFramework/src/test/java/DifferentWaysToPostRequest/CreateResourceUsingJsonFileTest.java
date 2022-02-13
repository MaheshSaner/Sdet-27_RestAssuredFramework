package DifferentWaysToPostRequest;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateResourceUsingJsonFileTest {

	@Test
	
	public void createUsingJsonFile() {
		
		File file = new File("./filedata.json");
		
		given()
				.body(file)
				.contentType(ContentType.JSON)
	    .when()
	    		.post("http://localhost:8084/addProjects")
	    .then()
	    		.assertThat().statusCode(201)
	    		.contentType(ContentType.JSON)
	    		.log().all();
		
				
		
		
	}
}
