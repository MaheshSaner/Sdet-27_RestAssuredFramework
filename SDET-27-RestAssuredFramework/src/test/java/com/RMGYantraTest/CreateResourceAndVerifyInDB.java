package com.RMGYantraTest;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoLibrary.PojoClass;
import sdet27genericUtility.BaseAPIClass;
import sdet27genericUtility.EndPoints;

public class CreateResourceAndVerifyInDB extends BaseAPIClass{
	@Test
		public void createResourceAndVerifyInDB() throws Throwable {
		//step-1 :- create test data
	    PojoClass po = new PojoClass("MaheshSir", "MHtyssAPI"+jLib.getRandomNumber(), "Created", 2535);
	
	    //step-2  :-execute the post request
         Response resp=given()
	    		         .body(po)
	    		         
	    		         .contentType(ContentType.JSON)
	                  .when()
	    		         .post(EndPoints.createProject);
         // step-3 capture the project id from response
                  String expData = rLib.getJSONData(resp, "projectId");
                  System.out.println(expData);
                  
          //step-4 verify in db
                  String query= "select * from project";
                 String actData = dLib.executeQueryAndGetData(query, 1, expData);
                 Reporter.log(actData,true);
         //step-5 validate
                 Assert.assertEquals(expData, actData);
                 
                 Reporter.log("data verification successful", true);
}
}