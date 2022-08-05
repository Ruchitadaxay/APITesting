package apicalls;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class HTTP_Post {
	
	// Step 1 define end point url
	
		//RestAssured is predefined library and also static so no need to create obj
		
		@Test
		public void Addemployee() {
			
			RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";//endpoint url
			
			//Step 2 request object
			RequestSpecification httprequest =RestAssured.given(); //will remember as it ts
			
			//Request payload sending along with post request 
			JSONObject requestpara=new JSONObject();
			requestpara.put("name","test");
			requestpara.put("salary", "12345");
			requestpara.put("age","25");
			httprequest.header("Content-Type","application/json");
			httprequest.body(requestpara.toJSONString());
			
			// Step 3 create response object
			Response httpresponse=httprequest.request(Method.POST, "/create");
			
			// Print response in console window to convert json format to String format
			String response=httpresponse.getBody().asString();
		System.out.println(response);
		int code= httpresponse.getStatusCode();
		System.out.println(code);
		Assert.assertEquals(code, 200);
		
	
		}

}
