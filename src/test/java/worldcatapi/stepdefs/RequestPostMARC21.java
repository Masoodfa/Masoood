package worldcatapi.stepdefs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.junit.Assert;

import core.worldcat.BaseClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class RequestPostMARC21 extends BaseClass{
	
	String reqMarc21 = "01900cam a22003971  450000100190000000500170001900700030003600800410003901000170008001900420009703500870013903500240022604001380025004900090038805000220039705500200041908200170043910000330045624500540048925000150054326000300055830000360058833600260062433700280065033800270067836500180070553000240072352000730074750400570082050503130087765000490119065000350123965500560127471000590133077601130138999000240513020480420210419030823.7ta700914s1968    nyua     b    000 0 eng    a   68017287   a330347a1233091a18029532a1086719587  a(OCoLC)00439887z(OCoLC)330347z(OCoLC)1233091z(OCoLC)18029532z(OCoLC)1086719587  a(OCoLC)ocm00439887   aDLCbengcDLCdBTCTAdLVBdCCVdDEBBGdOCLCOdOCLCFdOCLCQdJYJdJVFdWVFdNLCdOCLCQdCPOdPAUdOCLCQdU3GdIL4J6dOCLCOdNIYdOCLCO  aOLIS00aPN1994b.G43 1968 1aPN1994.G43 196800a791.43/09/041 aGessner, Robert,d1907-1968.14aThe moving image;ba guide to cinematic literacy.  a[1st ed.].  aNew York,bDutton,c1968.  a444 pagesbillustrationsc24 cm  atextbtxt2rdacontent  aunmediatedbn2rdamedia  avolumebnc2rdacarrier  a01b4.40cUSD  aAlso issued online.  aExplores what is fundamental in cinema as a story-tellling art form.  aIncludes bibliographical references (pages 409-420).0 aConflict in cinema -- Focusing conflict -- Conflict and character -- Idea into action through character -- Intercharacter relations -- Structuring conflict -- The obligatory scene -- Scene climax -- Orchestration of shots -- The faces of time -- The faces of time edited -- The auditory image -- Refinements. 0aMotion picture playsxHistory and criticism. 7aMotion picturesxHistory.2nli 7aMotion picture playsxHistory and criticism.2gsafd2 aRouben Mamoulian Collection (Library of Congress)5DLC08iOnline version:aGessner, Robert, 1907-tMoving image.b[1st ed.].dNew York, Dutton, 1968w(OCoLC)574143008";
			
	
	@Given("The post API is up and running")
	public void The_post_API_is_up_and_running() {
		_REQUEST_SPEC = given().baseUri
				("http://nlb-wcmetadataholdingsapi-647bb4b4e8115f8d.elb.us-east-2.amazonaws.com");
		scn.write
		("Base URL: http://nlb-wcmetadataholdingsapi-647bb4b4e8115f8d.elb.us-east-2.amazonaws.com");
	}

	@When("I hit post end point url")
	public void I_hit_post_end_point_url() {

		//Headers
		Map<String,String> headers = new HashMap<String,String>();
		headers.put("Institution-Code", "78715");
		headers.put("Institution-Symbol", "WMAPI");
		headers.put("Content-Type", "application/marc");
		scn.write("Header as " + headers.toString());

		EncoderConfig encoderconfig = new EncoderConfig();
		_RESP = _REQUEST_SPEC.headers(headers) 
				.config(RestAssured.config()
				.encoderConfig(encoderconfig.appendDefaultContentCharsetToContentTypeIfUndefined(false)
				.encodeContentTypeAs("application/marc", ContentType.TEXT)))
				.log().all().body(reqMarc21).when().post("worldcat/manage/holdings-set");
		scn.write("Response:"+_RESP.asString());
		scn.write("ResponseCode:"+_RESP.statusCode());
		
		
		_RESP.then().assertThat().body("institutionCode", equalTo("78715"));
		_RESP.then().assertThat().body("institutionSymbol", equalTo("WMAPI"));
		_RESP.then().assertThat().body("success", equalTo(true));
	
	
	}
	
}
