package worldcatapi.stepdefs;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
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


public class RequestPostMARC21XML extends BaseClass {
	
	String reqMarc21XML = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?><marc:collection xmlns:marc=\"http://www.loc.gov/MARC21/slim\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.loc.gov/MARC21/slim http://www.loc.gov/standards/marcxml/schema/MARC21slim.xsd\">\n"
			+ "<marc:record><marc:leader>01900cam a22003971  4500</marc:leader>\n"
			+ "<marc:controlfield tag=\"001\">990002405130204804</marc:controlfield>\n"
			+ "<marc:controlfield tag=\"005\">20210419030823.7</marc:controlfield><marc:controlfield tag=\"007\">ta</marc:controlfield><marc:controlfield tag=\"008\">700914s1968    nyua     b    000 0 eng  </marc:controlfield><marc:datafield tag=\"010\" ind1=\" \" ind2=\" \"><marc:subfield code=\"a\">   68017287 </marc:subfield></marc:datafield><marc:datafield tag=\"019\" ind1=\" \" ind2=\" \"><marc:subfield code=\"a\">330347</marc:subfield><marc:subfield code=\"a\">1233091</marc:subfield><marc:subfield code=\"a\">18029532</marc:subfield><marc:subfield code=\"a\">1086719587</marc:subfield></marc:datafield><marc:datafield tag=\"035\" ind1=\" \" ind2=\" \"><marc:subfield code=\"a\">(OCoLC)00439887</marc:subfield><marc:subfield code=\"z\">(OCoLC)330347</marc:subfield><marc:subfield code=\"z\">(OCoLC)1233091</marc:subfield><marc:subfield code=\"z\">(OCoLC)18029532</marc:subfield><marc:subfield code=\"z\">(OCoLC)1086719587</marc:subfield></marc:datafield><marc:datafield tag=\"035\" ind1=\" \" ind2=\" \"><marc:subfield code=\"a\">(OCoLC)ocm00439887 </marc:subfield></marc:datafield><marc:datafield tag=\"040\" ind1=\" \" ind2=\" \"><marc:subfield code=\"a\">DLC</marc:subfield><marc:subfield code=\"b\">eng</marc:subfield><marc:subfield code=\"c\">DLC</marc:subfield><marc:subfield code=\"d\">BTCTA</marc:subfield><marc:subfield code=\"d\">LVB</marc:subfield><marc:subfield code=\"d\">CCV</marc:subfield><marc:subfield code=\"d\">DEBBG</marc:subfield><marc:subfield code=\"d\">OCLCO</marc:subfield><marc:subfield code=\"d\">OCLCF</marc:subfield><marc:subfield code=\"d\">OCLCQ</marc:subfield><marc:subfield code=\"d\">JYJ</marc:subfield><marc:subfield code=\"d\">JVF</marc:subfield><marc:subfield code=\"d\">WVF</marc:subfield><marc:subfield code=\"d\">NLC</marc:subfield><marc:subfield code=\"d\">OCLCQ</marc:subfield><marc:subfield code=\"d\">CPO</marc:subfield><marc:subfield code=\"d\">PAU</marc:subfield><marc:subfield code=\"d\">OCLCQ</marc:subfield><marc:subfield code=\"d\">U3G</marc:subfield><marc:subfield code=\"d\">IL4J6</marc:subfield><marc:subfield code=\"d\">OCLCO</marc:subfield><marc:subfield code=\"d\">NIY</marc:subfield><marc:subfield code=\"d\">OCLCO</marc:subfield></marc:datafield><marc:datafield tag=\"049\" ind1=\" \" ind2=\" \"><marc:subfield code=\"a\">OLIS</marc:subfield></marc:datafield><marc:datafield tag=\"050\" ind1=\"0\" ind2=\"0\"><marc:subfield code=\"a\">PN1994</marc:subfield><marc:subfield code=\"b\">.G43 1968</marc:subfield></marc:datafield><marc:datafield tag=\"055\" ind1=\" \" ind2=\"1\"><marc:subfield code=\"a\">PN1994.G43 1968</marc:subfield></marc:datafield><marc:datafield tag=\"082\" ind1=\"0\" ind2=\"0\"><marc:subfield code=\"a\">791.43/09/04</marc:subfield></marc:datafield><marc:datafield tag=\"100\" ind1=\"1\" ind2=\" \"><marc:subfield code=\"a\">Gessner, Robert,</marc:subfield><marc:subfield code=\"d\">1907-1968.</marc:subfield></marc:datafield><marc:datafield tag=\"245\" ind1=\"1\" ind2=\"4\"><marc:subfield code=\"a\">The moving image;</marc:subfield><marc:subfield code=\"b\">a guide to cinematic literacy.</marc:subfield></marc:datafield><marc:datafield tag=\"250\" ind1=\" \" ind2=\" \"><marc:subfield code=\"a\">[1st ed.].</marc:subfield></marc:datafield><marc:datafield tag=\"260\" ind1=\" \" ind2=\" \"><marc:subfield code=\"a\">New York,</marc:subfield><marc:subfield code=\"b\">Dutton,</marc:subfield><marc:subfield code=\"c\">1968.</marc:subfield></marc:datafield><marc:datafield tag=\"300\" ind1=\" \" ind2=\" \"><marc:subfield code=\"a\">444 pages</marc:subfield><marc:subfield code=\"b\">illustrations</marc:subfield><marc:subfield code=\"c\">24 cm</marc:subfield></marc:datafield><marc:datafield tag=\"336\" ind1=\" \" ind2=\" \"><marc:subfield code=\"a\">text</marc:subfield><marc:subfield code=\"b\">txt</marc:subfield><marc:subfield code=\"2\">rdacontent</marc:subfield></marc:datafield><marc:datafield tag=\"337\" ind1=\" \" ind2=\" \"><marc:subfield code=\"a\">unmediated</marc:subfield><marc:subfield code=\"b\">n</marc:subfield><marc:subfield code=\"2\">rdamedia</marc:subfield></marc:datafield><marc:datafield tag=\"338\" ind1=\" \" ind2=\" \"><marc:subfield code=\"a\">volume</marc:subfield><marc:subfield code=\"b\">nc</marc:subfield><marc:subfield code=\"2\">rdacarrier</marc:subfield></marc:datafield><marc:datafield tag=\"365\" ind1=\" \" ind2=\" \"><marc:subfield code=\"a\">01</marc:subfield><marc:subfield code=\"b\">4.40</marc:subfield><marc:subfield code=\"c\">USD</marc:subfield></marc:datafield><marc:datafield tag=\"530\" ind1=\" \" ind2=\" \"><marc:subfield code=\"a\">Also issued online.</marc:subfield></marc:datafield><marc:datafield tag=\"520\" ind1=\" \" ind2=\" \"><marc:subfield code=\"a\">Explores what is fundamental in cinema as a story-tellling art form.</marc:subfield></marc:datafield><marc:datafield tag=\"504\" ind1=\" \" ind2=\" \"><marc:subfield code=\"a\">Includes bibliographical references (pages 409-420).</marc:subfield></marc:datafield><marc:datafield tag=\"505\" ind1=\"0\" ind2=\" \"><marc:subfield code=\"a\">Conflict in cinema -- Focusing conflict -- Conflict and character -- Idea into action through character -- Intercharacter relations -- Structuring conflict -- The obligatory scene -- Scene climax -- Orchestration of shots -- The faces of time -- The faces of time edited -- The auditory image -- Refinements.</marc:subfield></marc:datafield><marc:datafield tag=\"650\" ind1=\" \" ind2=\"0\"><marc:subfield code=\"a\">Motion picture plays</marc:subfield><marc:subfield code=\"x\">History and criticism.</marc:subfield></marc:datafield><marc:datafield tag=\"650\" ind1=\" \" ind2=\"7\"><marc:subfield code=\"a\">Motion pictures</marc:subfield><marc:subfield code=\"x\">History.</marc:subfield><marc:subfield code=\"2\">nli</marc:subfield></marc:datafield><marc:datafield tag=\"655\" ind1=\" \" ind2=\"7\"><marc:subfield code=\"a\">Motion picture plays</marc:subfield><marc:subfield code=\"x\">History and criticism.</marc:subfield><marc:subfield code=\"2\">gsafd</marc:subfield></marc:datafield><marc:datafield tag=\"710\" ind1=\"2\" ind2=\" \"><marc:subfield code=\"a\">Rouben Mamoulian Collection (Library of Congress)</marc:subfield><marc:subfield code=\"5\">DLC</marc:subfield></marc:datafield><marc:datafield tag=\"776\" ind1=\"0\" ind2=\"8\"><marc:subfield code=\"i\">Online version:</marc:subfield><marc:subfield code=\"a\">Gessner, Robert, 1907-</marc:subfield><marc:subfield code=\"t\">Moving image.</marc:subfield><marc:subfield code=\"b\">[1st ed.].</marc:subfield><marc:subfield code=\"d\">New York, Dutton, 1968</marc:subfield><marc:subfield code=\"w\">(OCoLC)574143008</marc:subfield></marc:datafield></marc:record>\n"
			+ "</marc:collection>\n";
	
	@Given("The post XML API is up and running")
	public void The_post_XML_API_is_up_and_running() {
		_REQUEST_SPEC = given().baseUri
				("http://nlb-wcmetadataholdingsapi-647bb4b4e8115f8d.elb.us-east-2.amazonaws.com");
		scn.write
		("Base URL: http://nlb-wcmetadataholdingsapi-0d08e9faf2f1c76f.elb.us-east-2.amazonaws.com");
	}
	
	@When("I hit post XML end point url")
	public void I_hit_post_XML_end_point_url() {

		//Headers
		Map<String,String> headers = new HashMap<String,String>();
		headers.put("Institution-Code", "78715");
		headers.put("Institution-Symbol", "WMAPI");
		headers.put("Content-Type", "application/xml");
		scn.write("Header as " + headers.toString());

		EncoderConfig encoderconfig = new EncoderConfig();
		_RESP = _REQUEST_SPEC.headers(headers) 
				.config(RestAssured.config()
				.encoderConfig(encoderconfig.appendDefaultContentCharsetToContentTypeIfUndefined(false)))
				.log().all().body(reqMarc21XML).when().post("/worldcat/manage/holdings-set");
		scn.write("Response:"+_RESP.asString());
		scn.write("ResponseCode:"+_RESP.statusCode());
		
		_RESP.then().assertThat().body("institutionCode", equalTo("78715"));
		_RESP.then().assertThat().body("institutionSymbol", equalTo("WMAPI"));
		_RESP.then().assertThat().body("success", equalTo(true));
		
	}

}
