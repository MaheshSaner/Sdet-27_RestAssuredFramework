package practice.restassured;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import pojoLibrary.PojoClass;

public class AddProjectWithCompletedStats {

	@Test
	
	public void addProjectWithCompletedStats() {
		
		PojoClass po = new PojoClass("PradeepNayak", "TYSS_1234", "Completed", 340);
		
		given()
				.body(po)
				.contentType(ContentType.JSON)
		.when()
				.post("http://localhost:8084/addProjects")
		.then()
 		.assertThat()
 		.statusCode(200)
 		.contentType(ContentType.JSON)
 		.log().all();		
}
			
		
		
	}


