package practiceCRUDWithBDD;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class UpdateResource {

	@Test
	
	public void update() {
		Random ran=new Random();
		int randomNum=ran.nextInt(500);
		JSONObject jObj= new JSONObject();
		
		
		jObj.put("createdBy","AdarshSir");
		jObj.put("projectName","APTIss"+randomNum);
		jObj.put("status","completed");
		jObj.put("teamSize",4920);
		
		given()
				.body(jObj)
				.contentType(ContentType.JSON)
		.when()
				.put("http://localhost:8084/projects/TY_PROJ_1603")
		.then()
				.assertThat().contentType(ContentType.JSON)
				.statusCode(200)
				.log().all();
				
}

	
}
