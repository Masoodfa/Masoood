package worldcatapi.stepdefs;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.simple.JSONObject;

import core.worldcat.BaseClass;

import static io.restassured.RestAssured.*;

public class GetRequest extends BaseClass {


	@Given("The get API is up and running")
	public void The_get_API_is_up_and_running() {
		_REQUEST_SPEC = given().baseUri("http://nlb-wcmetadataholdingsapi-0d08e9faf2f1c76f.elb.us-east-2.amazonaws.com/worldcat/manage/holdings");
		scn.write("Base URL: http://nlb-wcmetadataholdingsapi-0d08e9faf2f1c76f.elb.us-east-2.amazonaws.com/worldcat/manage/holdings");
		
	}

	@When("I hit get end point url")
	public void I_hit_get_end_point_url() {
		_RESP = _REQUEST_SPEC.when().get("/9987457");
	
	}

}
