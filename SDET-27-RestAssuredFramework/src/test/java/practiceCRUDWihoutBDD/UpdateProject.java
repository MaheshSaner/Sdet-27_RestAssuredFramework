package practiceCRUDWihoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {

	@Test
	
	public void updateProject() {
		
		//create test data
		JSONObject jObj= new JSONObject();
		jObj.put("createdBy","Mahesh");
		jObj.put("projectName","APTY");
		jObj.put("teamSize",20);
		jObj.put("status","completed");
		
		//step 2 
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jObj);
		
		//step 3 
		
		Response resp = req.put("http://localhost:8084/projects/TY_PROJ_1402");
		
		//step 4 verify
		
		ValidatableResponse validate = resp.then();
		validate.assertThat().statusCode(200);
		validate.log().all();
		
		
	}
	
}
