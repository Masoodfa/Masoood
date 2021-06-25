package product.worldcatapi.stepdefs;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import product.worldcatapi.utils.BaseClass;

import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.simple.JSONObject;
import static io.restassured.RestAssured.*;


public class StepDefs_PostRequests extends BaseClass {
	
	
	@Given("The post API is up and running")
	public void The_post_API_is_up_and_running() {
		
	
		_REQUEST_SPEC = given().baseUri
				("http://nlb-wcmetadataholdingsapi-0d08e9faf2f1c76f.elb.us-east-2.amazonaws.com");
		scn.write
		("Base URL: http://nlb-wcmetadataholdingsapi-0d08e9faf2f1c76f.elb.us-east-2.amazonaws.com");
	}

	//*******************WHEN**********************************
	@When("I hit post end point url")
	public void I_hit_post_end_point_url() {
		
		//Body
				JSONObject body_json = new JSONObject();
				controlNum = GetRandomString(5); 
				institutionCode = GetRandomString(4); 
				body_json.put("cNum", controlNum);
				body_json.put("InsCode", institutionCode);

				scn.write("body as " + body_json.toJSONString());

				//Headers
				Map<String,String> headers = new HashMap<String,String>();
				headers.put("Content-Type", "application/marc");
				scn.write("Header as " + headers.toString());

				_RESP = _REQUEST_SPEC.headers(headers).when().
						post("/worldcat/manage/holdings-set");
	
	}


	//*************************UTILS**************************
	//To get random Key
	public String GetRandomString(int n) {
		// lower limit for LowerCase Letters 
		int lowerLimit = 97; 

		// lower limit for LowerCase Letters 
		int upperLimit = 122; 

		Random random = new Random(); 

		// Create a StringBuffer to store the result 
		StringBuffer r = new StringBuffer(n); 

		for (int i = 0; i < n; i++) { 

			// take a random value between 97 and 122 
			int nextRandomChar = lowerLimit 
					+ (int)(random.nextFloat() 
							* (upperLimit - lowerLimit + 1)); 

			// append a character at the end of bs 
			r.append((char)nextRandomChar); 
		} 

		// return the resultant string 
		return r.toString(); 
	} 


}
