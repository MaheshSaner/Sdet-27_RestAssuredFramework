package practiceCRUDWihoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject {

	@Test
	
	public void createProject() {
		// step 1: create test data
		
		JSONObject jObj= new JSONObject();
		
		jObj.put("createdBy", "Mahesh");
		jObj.put("projectName", "APTY");
		jObj.put("status", "Created");
		jObj.put("teamSize", 20);
		
		
		//step2 provide request specification
		
		    RequestSpecification req = RestAssured.given();
		    req.contentType(ContentType.JSON);
		    req.body(jObj);
		    
		// step 3 perform the action
		    
		    Response resp=req.post("http://localhost:8084/addProject");
		    
		//step 4 print in the console and verify
		    
		    System.out.println(resp.asString());
		    System.out.println(resp.prettyPrint());
		    System.out.println(resp.prettyPeek());
		    System.out.println(resp.getContentType());
		    
		
		
		
	}
}
