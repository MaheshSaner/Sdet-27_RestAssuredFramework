package responseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponseValidation {

	@Test
	
	public void verify() {
		
		String expProjectname="TYSS_733";
		Response response = when()
		.get("https://localhost:8084/projects");
		
		String actProjectName=response.jsonPath().get("[0].projectName");
		
		response.then()
				.assertThat()
				.contentType(ContentType.JSON).and().statusCode(200)
				.log().all();
		
		Assert.assertEquals(actProjectName, expProjectname);
	}
}
