package practiceCRUDWihoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSingleProject {

	
	@Test
	
	public void getSingleProject() {
		Response resp = RestAssured.get("http://localhost:8084/projects/TY_PROJ_1402");
	
		System.out.println(resp.prettyPeek());
		System.out.println(resp.getStatusCode());
	
	}
}
