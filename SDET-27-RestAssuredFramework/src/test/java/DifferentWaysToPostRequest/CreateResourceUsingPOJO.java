package DifferentWaysToPostRequest;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoLibrary.PojoClass;


public class CreateResourceUsingPOJO {
    @Test
    
    public void create() {
    	
    	
	PojoClass pObj=new PojoClass("maheshBabu","TYSS_sdet_apiWorks", "completed", 456);
	
	given()
			.body(pObj)
			.contentType(ContentType.JSON)
			
	 .when()
			.post("http://localhost:8084/addProjects")
     .then()
     		.assertThat().statusCode(201)
     		.contentType(ContentType.JSON)
     		.log().all();
	    }
}


