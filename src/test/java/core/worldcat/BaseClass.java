package core.worldcat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {

	protected static RequestSpecification _REQUEST_SPEC;
	protected static Response _RESP;
	protected static Scenario scn;
	public Properties prop;
	
	
	public BaseClass(){
		try {
		prop = new Properties();
		FileInputStream ip;
		
			ip = new FileInputStream (System.getProperty("user.dir")+
					"/src/test/resources/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	
}
