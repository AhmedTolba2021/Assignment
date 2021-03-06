package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import java.io.File;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.cucumber.listener.Reporter;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "..\\AutomationPartUsingCucumber\\src\\main\\java\\Features"
				,glue={"StepDefinition"},
						plugin={"com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html"},
                dryRun=false,
                monochrome = true
                )

public class TestRunner {

	
	@AfterClass
	public static void setup()
	{
	Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
	Reporter.setSystemInfo("User Name", "Ahmed Tolba");
	Reporter.setSystemInfo("Application Name", "Test Assignment App ");
	Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
	Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
	}
	
	
	
	
}
