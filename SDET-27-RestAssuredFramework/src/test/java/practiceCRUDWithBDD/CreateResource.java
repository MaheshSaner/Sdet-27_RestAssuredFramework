package practiceCRUDWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateResource {

	@Test
		
	public void create() {
		
		//creation of random number
		Random ran=new Random();
		int randomNum=ran.nextInt(500);
		JSONObject jObj= new JSONObject();
		
		jObj.put("createdBy","MaheshSir");
		jObj.put("projectName","APTIss"+randomNum);
		jObj.put("status","created");
		jObj.put("teamSize",420);
		
		given()
		     .body(jObj)
		     .contentType(ContentType.JSON)
		   .when()
		       	.post("http://localhost:8084/addProject")
		   .then()
		   		.assertThat().statusCode(201)
		   		.contentType(ContentType.JSON)
		   		.log().all();
		
		       
		
	}
}
