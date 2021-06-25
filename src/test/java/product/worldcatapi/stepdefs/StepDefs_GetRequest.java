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

public class StepDefs_GetRequest extends BaseClass {

	
	//*********************GIVEN*******************************
	@Given("The get API is up and running")
	public void The_get_API_is_up_and_running() {
		_REQUEST_SPEC = given().baseUri("http://nlb-wcmetadataholdingsapi-0d08e9faf2f1c76f.elb.us-east-2.amazonaws.com/worldcat/manage/holdings");
		scn.write("Base URL: http://nlb-wcmetadataholdingsapi-0d08e9faf2f1c76f.elb.us-east-2.amazonaws.com/worldcat/manage/holdings");
		
	}

	//*******************WHEN**********************************
	@When("I hit get end point url")
	public void I_hit_get_end_point_url() {
		_RESP = _REQUEST_SPEC.when().get("/12334556");
	
	}


	@When("I hit url with query parameters as {string}")
	public void i_hit_url_with_query_parameters_as(String arg) {
		
		if(arg.contains("page")) {
			_RESP = _REQUEST_SPEC.get(arg);
			scn.write("End Point is: /users?page=1");
		}else {
			_RESP = _REQUEST_SPEC.get("/api/users"+arg);
			scn.write("End Point: /users" + arg);
		}
	}

	//*********************THEN*************************************
	@Then("API returns the response with status code as {int}")
	public void api_returns_the_response_with_status_code_as(Integer int1) {
		_RESP.then().assertThat().statusCode(int1);
		scn.write("Status code appearing as: " + int1);

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
