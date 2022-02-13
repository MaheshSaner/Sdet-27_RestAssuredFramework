package practice.restassured;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;

import io.restassured.http.ContentType;
import pojoLibrary.PojoClass;

public class AddProjectWitONGoingStatus {

	public void addSingleProjectWithONGoingStatus() {
		
   		PojoClass po = new PojoClass("maheshSSs", "TYSS_01023", "ONGoing", 234) ;
   		
   		 given()
   		 		.body(po)
   		 		.contentType(ContentType.JSON)
   		 .when()
   		 		.post("http://localhost:8084/addProjects")
   		 .then()
   		 		.assertThat().assertThat().time(Matchers.lessThan(300l), TimeUnit.MILLISECONDS)
   		 		.contentType(ContentType.JSON)
   		 		.log().all();		
}
}
