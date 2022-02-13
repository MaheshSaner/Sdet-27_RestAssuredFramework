package practice.restassured;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoLibrary.PojoClass;

import static io.restassured.RestAssured.*;

public class AddSingleProjectWithCreatedStatus {

	@Test
	public void addSingleProjectWithCreatedStatus() {
	
	   		PojoClass po = new PojoClass("maheshSS", "TYSS_0102", "completed", 234) ;
	   		
	   		 given()
	   		 		.body(po)
	   		 		.contentType(ContentType.JSON)
	   		 .when()
	   		 		.post("http://localhost:8084/addProjects")
	   		 .then()
	   		 		.assertThat()
	   		 		.contentType(ContentType.JSON)
	   		 		.log().all();		
	}

}
