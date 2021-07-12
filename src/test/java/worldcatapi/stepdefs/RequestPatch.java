package worldcatapi.stepdefs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import core.worldcat.BaseClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;

public class RequestPatch extends BaseClass{
	
	String json = "[\r\n"
			+ "  {\r\n"
			+ "    \"op\": \"add\",\r\n"
			+ "    \"path\": \"/held\",\r\n"
			+ "    \"value\": true\r\n"
			+ "  }\r\n"
			+ "]";
	
	@Given("The patch request API is up and running")
	public void The_patch_request_API_is_up_and_running() {
		_REQUEST_SPEC = given().baseUri
				("http://nlb-wcmetadataholdingsapi-647bb4b4e8115f8d.elb.us-east-2.amazonaws.com/worldcat/manage/holdings");
		scn.write
		("Base http://nlb-wcmetadataholdingsapi-647bb4b4e8115f8d.elb.us-east-2.amazonaws.com/worldcat/manage/holdings");
	}

	@When("I hit patch request end point url")
	public void I_hit_patch_request_end_point_url() {
		scn.write("body as " + json);

		//Headers
		Map<String,String> headers = new HashMap<String,String>();
		headers.put("Institution-Code", "78715");
		headers.put("Institution-Symbol", "WMAPI");
		headers.put("Content-Type", "application/json");
		scn.write("Header as " + headers.toString());
		_RESP = _REQUEST_SPEC.headers(headers).body(json).when().patch("/34234");
		scn.write("Response:"+_RESP.asString());
		scn.write("ResponseCode:"+_RESP.statusCode());
		
		_RESP.then().assertThat().body("institutionCode", equalTo("78715"));
		_RESP.then().assertThat().body("institutionSymbol", equalTo("WMAPI"));
		_RESP.then().assertThat().body("success", equalTo(true));

	}
	

}
