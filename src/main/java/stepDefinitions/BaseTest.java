package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
	
	public static WebDriver driver;
	static ChromeOptions options = new ChromeOptions();
	
	public static WebDriver initializeDriver(){
		
		/*System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") +"\\src\\main\\java\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();*/
		if(driver == null){
			options.addArguments("--incognito");
			options.addArguments("--start-maximized");
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") +"\\src\\main\\java\\drivers\\chromedriver.exe");
			driver = new ChromeDriver(options);
		}
		return driver;
	}

}
