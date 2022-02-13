package responseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;


import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicResponseValidation {

	@Test
	
	public void verify() {
		
		String expProjectName="Testyanta293";
		
		Response response = when()
				.get("https://localhost:8084/projects");
		List<String> proName= response.jsonPath().get("projectName");
		
		boolean flag=false;
		
		for(String pName : proName) {
			
			if(pName.equals(proName)) {
				flag=true;
			}
		}
		
		response.then()
					.assertThat()
					.contentType(ContentType.JSON).and().statusCode(200)
					.log().all();
		
		Assert.assertEquals(flag, true);
		
	}
}
