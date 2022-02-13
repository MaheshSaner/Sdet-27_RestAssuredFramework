package responseValidation;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoLibrary.PojoClass;

public class SameRequestMultipleTimes {

	@Test(dataProvider ="getData")
	
	public void create(String createdBy, String projectName, String status, int teamSize) {
		PojoClass pojo = new PojoClass(createdBy, projectName, status, teamSize);
	
		given()
	     .body(pojo)
	     .contentType(ContentType.JSON)
	   .when()
	       	.post("http://localhost:8084/addProject")
	   .then()
	   		.assertThat().statusCode(201)
	   		.contentType(ContentType.JSON)
	   		.log().all();
	
	}
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] objArr = new Object[2][4];
		
		objArr[0][0]="vickey";
		objArr[0][1]="vickey_api_project";
		objArr[0][2]="created";
		objArr[0][3]=3774;
		
		objArr[1][0]="maheshSaner";
		objArr[1][1]="myproject-api";
		objArr[1][2]="completed";
		objArr[1][3]=3464;
		
		return objArr;
	}
}
