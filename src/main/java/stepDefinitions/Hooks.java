package stepDefinitions;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

//import com.cucumber.listener.Reporter;
import com.google.common.io.Files;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import stepDefinitions.BaseTest;
import utilities.DriverFactory;

public class Hooks extends BaseTest {

	//public WebDriver driver;
	
	
	@Before
	public void beforeScenario(Scenario scenario) {
		System.out.println("BEFORE SCENARIO:  "+ scenario.getName());
		//driver = BaseTest.initializeDriver();
		//driver.manage().window().maximize();
		//Reporter.assignAuthor("Demo QA Member");
	}

	@After(order = 1)
	public void afterScenario(Scenario scenario) {
		System.out.println("AFTER SCENARIO: "+ scenario.getName());
	/*	if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			try {
				File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

				File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/" + screenshotName + ".png");

				Files.copy(sourcePath, destinationPath);   

				Reporter.addScreenCaptureFromPath(destinationPath.toString());
			} catch (IOException e) {
			} 
		}*/
		//driver.quit();
	}


	@After(order = 0)
	public void AfterSteps() {
		//BaseTest.driver = null;
		//driver.quit();
		DriverFactory.removeDriver();
	}

}
