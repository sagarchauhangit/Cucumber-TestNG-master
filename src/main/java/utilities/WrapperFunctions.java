package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WrapperFunctions {
	
	private WebDriver driver;

	public WrapperFunctions(WebDriver driver) {
		this.driver = driver;
	}
	
	public void goToURL(String url){
		driver.get(url);
	}
	
	public String getPageTitle(){
		try {
			return driver.getTitle();
		} catch (Exception e) {
			this.commonExceptions(e);
			return null;
		}
	}
	
	public void setStringText(By locator, String text){

		this.highlightElement(locator);
		driver.findElement(locator).sendKeys(text);

	}

	public void click(By locator) throws Exception{

		this.waitForElementVisibilityLocated(locator);
		this.waitForElementToBeClickable(locator);
		this.highlightElement(locator);
		WebElement we = driver.findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", we);

	}
	
	public String getRequiredText(By locator){

		this.highlightElement(locator);
		return driver.findElement(locator).getText();
	}
	
	public boolean checkElementIsDisplayed(By locator) throws Exception{

		//this.waitForElementVisibilityLocated(locator);
		this.waitForElementPresence(locator);
		boolean flag = driver.findElement(locator).isDisplayed();
		System.out.println("Displayed "+ flag);
		if(flag){
			this.highlightElement(locator);}
		return flag;
	}

	public void checkWebElement(By locator) throws Exception{

		this.waitForElementToBeClickable(locator);
		this.highlightElement(locator);
		if(!driver.findElement(locator).isSelected()){
			WebElement we = driver.findElement(locator);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", we);
		}
	}
	
	public void unCheckWebElement(By locator) throws Exception{

		this.waitForElementToBeClickable(locator);
		this.highlightElement(locator);
		if(driver.findElement(locator).isSelected()){
			WebElement we = driver.findElement(locator);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", we);
		}

	}
	
	public void highlightElement(By locator) {

		try {
			WebElement we = driver.findElement(locator);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].setAttribute('style', 'background: rgb(248, 252, 3); border: 2px solid red;');",
					we);
			driver.wait(500);
			js.executeScript("arguments[0].setAttribute('style','border: solid 2px rgb(64, 168, 50)');", we);
			
		} catch (Exception e) {
		}

	}
	
	public void highlightElementForFailedTests(By locator) {
		try {
			WebElement we = driver.findElement(locator);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].setAttribute('style','border : rgb(252, 3, 15);');", we);
		} catch (Exception e) {
		}
	}
	
	public void waitForElementVisibilityLocated(By locator) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void waitForElementToBeClickable(By locator) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void waitForElementPresence(By locator) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	
	public void commonExceptions(Exception e) {
		try {
			throw e;
		} catch (InvalidSelectorException exception) {
			exception.printStackTrace();
			return;
		} catch (NoSuchElementException exception) {
			exception.printStackTrace();
			return;
		} catch (ElementNotVisibleException exception) {
			exception.printStackTrace();
			return;
		} catch (ElementNotSelectableException exception) {
			exception.printStackTrace();
			return;
		} catch (TimeoutException exception) {
			exception.printStackTrace();
			return;
		} catch (NoSuchSessionException exception) {
			exception.printStackTrace();
			return;
		} catch (StaleElementReferenceException exception) {
			exception.printStackTrace();
			return;
		} catch (NoAlertPresentException exception) {
			exception.printStackTrace();
			return;
		} catch (NoSuchFrameException exception) {
			exception.printStackTrace();
			return;
		} catch (NoSuchWindowException exception) {
			exception.printStackTrace();
			return;
		} catch (UnhandledAlertException exception) {
			exception.printStackTrace();
			return;
		} catch (WebDriverException exception) {
			exception.printStackTrace();
			return;
		} catch (Exception exception) {
			exception.printStackTrace();
			return;
		}
	}

}
