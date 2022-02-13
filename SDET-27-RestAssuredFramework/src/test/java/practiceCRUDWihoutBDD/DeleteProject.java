package practiceCRUDWihoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProject {

	@Test
	
	public void deleteProject() {
		
		Response resp = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_1402");
		
		
		//step 2
		int expStatus =204;
		
		int actStatus = resp.getStatusCode();
		
		Assert.assertEquals(actStatus, expStatus);
		
		System.out.println(resp.prettyPrint());
		
	}
}
