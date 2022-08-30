package testRunner;



import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions

	(
			features="src/test/resources/features/LoginPage.feature",
			glue={"stepDefination","AppHooks" },
			dryRun= false,
			monochrome=true,
			//tags= " @Examples ",
			plugin= {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
				
			
			)




public class MyTestRunner {
	
	

}