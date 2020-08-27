package stepDefinitions;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.DemoHomePage;
import utilities.SharedDriver;

public class StepDemoForm{
	
	//public WebDriver driver;
	static String inputText;
	static int sum1,sum2;
	DemoHomePage objDemoPage;
	
	public StepDemoForm(SharedDriver driver,DemoHomePage objDemoPage){
		this.objDemoPage = objDemoPage;
	}

	@Given("^User is on Demo Home Page$")
	public void user_is_on_Demo_Home_Page() throws Exception{
		objDemoPage.goToDemoHomePage("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
	}

	@Then("^user enters Input \"([^\"]*)\"$")
	public void user_enters_Input(String arg1){
		inputText = arg1;
		objDemoPage.setInputMessage(inputText);
	}

	@Then("^user clicks on Show Message button$")
	public void user_clicks_on_Show_Message_button() throws Exception{
		objDemoPage.clickShowMessageButton();
	}
	
	@Then("^user enters numeric value in text boxes (\\d+) and (\\d+)$")
	public void user_enters_numeric_value_in_text_boxes_and(int arg1, int arg2) throws Throwable {
		sum1 = arg1;sum2 = arg2;
		objDemoPage.setInputNumbersForSum(arg1, arg2);
	}

	@Then("^user clicks on Get Total button$")
	public void user_clicks_on_Get_Total_button() throws Exception{
		objDemoPage.clickGetTotalButton();
	}

	@When("^User clicks on Input Forms Text$")
	public void user_clicks_on_Input_Forms_Text() throws Throwable {
		objDemoPage.clickInputTextOption();
	}

	@When("^user clicks on Checkbox Demo$")
	public void user_clicks_on_Checkbox_Demo() throws Throwable {
		objDemoPage.clickCheckBoxDemoOption();
	}

	@When("^User checks the checkbox$")
	public void user_checks_the_checkbox() throws Throwable {
		objDemoPage.checkFirstCheckBox();
	}

}
