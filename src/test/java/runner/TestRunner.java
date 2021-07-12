package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	
		features = {"classpath:features/worldcatapi"},
		glue = "worldcatapi.stepdefs", 
		tags = "@deleteMARC21XML",
		plugin =
			{
					"pretty" , 
					"json:target/cucumber.json",
					"html:target/cucumber",
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
			},
		dryRun=false
		
		)
public class TestRunner {

}
