package stepDefinitions;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.DemoHomePage;
import pages.DemoVerificationPage;
import utilities.SharedDriver;

public class StepDemoVerification{
	
	DemoHomePage objDemoPage;
	DemoVerificationPage objVerifyPage;
	
	public StepDemoVerification(SharedDriver driver, DemoHomePage objDemoPage, DemoVerificationPage objVerifyPage){
		this.objDemoPage = objDemoPage;
		this.objVerifyPage = objVerifyPage;
	}
	
	@When("^title of Home Page is Valid$")
	public void title_of_Home_Page_is_Valid(){
		String actualTitle = objDemoPage.getPageTitle();
		objVerifyPage.setVariableValue("PageTitle", actualTitle);
		Assert.assertTrue(actualTitle.contains("Selenium Easy Demo"));
	}
	
	@Then("^user verifies input text below$")
	public void user_verifies_input_text_below() throws InterruptedException{
		String actualDisplayedText = objVerifyPage.getDisplayedMessage();
		Assert.assertEquals(actualDisplayedText,StepDemoForm.inputText);
	}

	@Then("^user verifies Sum below$")
	public void user_verifies_Sum_below() throws InterruptedException {
		int actualDisplayedSum = Integer.parseInt(objVerifyPage.getDisplayedSum());
		Assert.assertEquals(actualDisplayedSum,(StepDemoForm.sum1+StepDemoForm.sum2));
	}
	

	@Then("^user verifies success message below$")
	public void user_verifies_success_message_below() throws Throwable {
		String actualMessage = objVerifyPage.getCheckBoxSuccessMessage();
		Assert.assertTrue(actualMessage.equals("Success - Check box is checked"));
	}

}
