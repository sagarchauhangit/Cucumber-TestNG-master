package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SharedDriver {

	public SharedDriver() {
		if (DriverFactory.getDriver() == null) {
			//WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") +"\\src\\main\\java\\drivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			options.addArguments("--start-maximized");
			WebDriver driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			DriverFactory.addDriver(driver);
		} 
	}
}
