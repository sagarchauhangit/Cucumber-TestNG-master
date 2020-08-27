package MyRunner;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;


@CucumberOptions(
        features = "src/main/java/Features",
        glue = {"stepDefinitions"},
        monochrome = true,
        tags = {"@DemoHomePage"},
       plugin = {"pretty",
                "html:target/html/",
                "json:target/json/file.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class TestRunner extends AbstractTestNGCucumberTests{
/*     private TestNGCucumberRunner testNGCucumberRunner;
 
    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }*/
 
 
/*    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }*/
 
/*    @Test(groups = "cucumber scenarios", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void scenario(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cucumberFeature) throws Throwable {
        testNGCucumberRunner.runScenario(pickleEvent.getPickleEvent());
    }*/
    
/*    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }
    */
	
    @DataProvider(parallel=true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
    
   /* @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
		Reporter.loadXMLConfig(new File("src/main/resources/extent-config.xml"));
		Reporter.setSystemInfo("User Name", "Admin");  
		//Reporter.assignAuthor("Demo QA Member");
		Reporter.setSystemInfo("Application Name", "Test App ");
		Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
		Reporter.setSystemInfo("Environment", "Production");
		Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
       testNGCucumberRunner.finish();

    }*/
}