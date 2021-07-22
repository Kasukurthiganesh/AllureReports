package AllureReport;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver;
	public static ThreadLocal<WebDriver> tdriver =new ThreadLocal<WebDriver>();
	public WebDriver initialization_driver() {
		WebDriverManager.chromedriver().setup();
    	driver=new ChromeDriver();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.manage().window().maximize();
    	tdriver.set(driver);
    	return getDriver();
	}
	public static synchronized WebDriver getDriver() {
		return tdriver.get();
	}
}
