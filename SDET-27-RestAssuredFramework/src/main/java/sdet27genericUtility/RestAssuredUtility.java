package sdet27genericUtility;

import io.restassured.response.Response;

/**
 * 
 * This class contains generic methods specific to rest assured
 * @author anils
 *
 */
public class RestAssuredUtility {

	/**
	 * this method will return jsonData for jsonPath specified
	 * @param resp
	 * @param jsonPath
	 * @return
	 */
	
	   public String getJSONData(Response resp, String jsonPath) {
		   
		   String jsonData= resp.jsonPath().get(jsonPath);
		   return jsonData;
		   
	   }
}
