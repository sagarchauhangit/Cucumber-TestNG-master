package pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import utilities.DriverFactory;
import utilities.WrapperFunctions;

public class DemoHomePage{
	
	//private WebDriver driver;
	public WrapperFunctions wrapper;
	private  Map<String, Object> variablesCollection;
	
	public DemoHomePage(){
		wrapper = new WrapperFunctions(DriverFactory.getDriver());
		variablesCollection = new HashMap<>();
	}
	
	By inputMessage = By.id("user-message");
	By btnShowMsg = By.xpath("//button[@onclick='showInput();']");
	By lblMessage = By.xpath("//div[@id='user-message']/span");
	By inputSum1 = By.id("sum1");
	By inputSum2 = By.id("sum2");
	By btnGetTotal = By.xpath("//button[@onclick='return total()']");
	By lblSum = By.id("displayvalue");
	By lblPopUp = By.xpath("//div[@id='at-cv-lightbox']");
	By btnClose = By.xpath("//div[@id='at-cv-lightbox']");
	By txtInputForm = By.xpath("//a[text()='Input Forms']");
	By txtCheckForm = By.xpath("//li[@class='tree-branch']//a[text()='Checkbox Demo']");
	By chkFirst = By.id("isAgeSelected");
	By txtSuccess = By.id("txtAge");
	
	public void setVariableValue(String key,String value){
		variablesCollection.put(key, value); 
	}
	
	public String getVariableValue(String key){
		return (String) variablesCollection.get(key); 
	}
	
	public void goToDemoHomePage(String url) throws Exception {

		wrapper.goToURL(url);
		//Thread.sleep(2000);
		if(wrapper.checkElementIsDisplayed(lblPopUp) || wrapper.checkElementIsDisplayed(btnClose)){
			wrapper.click(btnClose);
		}
	}
	
	public String getPageTitle() {
		
		return wrapper.getPageTitle();
	}
	
	public void setInputMessage(String text){
		wrapper.setStringText(inputMessage,text);
	}
	
	public void clickShowMessageButton() throws Exception {
		 wrapper.click(btnShowMsg);
	}
	
	public void setInputNumbersForSum(int a,int b){
		wrapper.setStringText(inputSum1, String.valueOf(a));
		wrapper.setStringText(inputSum2, String.valueOf(b));
	}
	
	public void clickGetTotalButton() throws Exception {
		wrapper.click(btnGetTotal);
	}
	
	public void clickInputTextOption() throws Exception {
		wrapper.click(txtInputForm);
	}
	
	public void clickCheckBoxDemoOption() throws Exception {
		wrapper.click(txtCheckForm);
	}
	
	public void checkFirstCheckBox() throws Exception {
		//Thread.sleep(3000);
		wrapper.checkWebElement(chkFirst);
	}
	
	
}
