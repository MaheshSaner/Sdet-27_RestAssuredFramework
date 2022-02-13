package practice.restassured;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoLibrary.PojoClass;

public class AddProjectWithInValidStatus {

	@Test
	
	public void  addProjectWithInValidStatus() {
	
	PojoClass po = new PojoClass("anil", "TYSS_0101", "completed",1234) ;
		
		 given()
		 		.body(po)
		 		.contentType(ContentType.JSON)
		 .when()
		 		.post("http://localhost:8084/addProjects")
		 .then()
		 		.assertThat()
		 		.statusCode(203)
		 		.contentType(ContentType.JSON)
		 		.log().all();		
}
}