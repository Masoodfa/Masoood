package product.worldcatapi.stepdefs;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import product.worldcatapi.utils.BaseClass;

public class StepDefs_Befor_And_After_Hooks extends BaseClass {

	
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

}
