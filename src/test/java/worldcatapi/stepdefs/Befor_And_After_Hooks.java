package worldcatapi.stepdefs;

import core.worldcat.BaseClass;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;

public class Befor_And_After_Hooks extends BaseClass {

	
	//Hooks
		@Before
		public void beforeHook(Scenario s) {
			this.scn = s;
		}

		@After
		public void afterHook(Scenario s){
			this.scn = s;
			if (_RESP==null) {
				scn.write("Response: No response received.");
			}else {
				scn.write("Response: " + _RESP.asString());
			}
		}
		
		@Then("API returns the response with status code as {int}")
		public void api_returns_the_response_with_status_code_as(Integer int1) {
			_RESP.then().assertThat().statusCode(int1);
			scn.write("Status code appearing as: " + int1);

		}

}
