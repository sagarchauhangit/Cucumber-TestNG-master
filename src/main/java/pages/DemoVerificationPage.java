package pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import utilities.DriverFactory;
import utilities.WrapperFunctions;

public class DemoVerificationPage{
	
	//private WebDriver driver;
	public WrapperFunctions wrapper;
	private  Map<String, Object> variablesCollection;
	
	public DemoVerificationPage(){
		wrapper = new WrapperFunctions(DriverFactory.getDriver());
		variablesCollection = new HashMap<>();
	}
	
	By lblMessage = By.xpath("//div[@id='user-message']/span");
	By lblSum = By.id("displayvalue");
	By txtSuccess = By.id("txtAge");
	
	public void setVariableValue(String key,String value){
		variablesCollection.put(key, value); 
	}
	
	public String getVariableValue(String key){
		return (String) variablesCollection.get(key); 
	}

	public String getDisplayedMessage() throws InterruptedException{
		//Thread.sleep(3000);
		return wrapper.getRequiredText(lblMessage);
	}
	
	public String getDisplayedSum() throws InterruptedException{
		//Thread.sleep(3000);
		return wrapper.getRequiredText(lblSum);
	}
	
	public String getCheckBoxSuccessMessage() throws InterruptedException{
		//Thread.sleep(2000);
		return wrapper.getRequiredText(txtSuccess);
	}
	
}
