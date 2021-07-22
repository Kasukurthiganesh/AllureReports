package AllureReport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners({AllureListener.class})
public class alluretestCases extends BaseClass{
	
	public WebDriver driver;
	
   @BeforeClass
    public void setup()
    {
    	BaseClass bs =new BaseClass();
    	driver=bs.initialization_driver();
    	driver.get("https://www.facebook.com/");
    	
    }
   @Epic("E001")
   @Feature("Feature1 : LOGO")
   @Story("Story:Logo presence")
   @Severity(SeverityLevel.BLOCKER)
   @Description("logo verification test is done")
   @Test(priority=1 , description="Logo verification is done on homepage")
   public void logoVerification()
   {
	  boolean logoimg = driver.findElement(By.xpath("//img[@class='fb_logo _8ilh img']")).isDisplayed();
	  Assert.assertEquals(logoimg, true);
   }
   @Epic("E001")
   @Feature("Feature2 : Login")
   @Story("Story:Login presence")
   @Severity(SeverityLevel.BLOCKER)
   @Description("Login authetication verification")
   @Test(priority=2, description="Login verification is done on loginpage")
   public void Logindetails() throws InterruptedException
   {
	   driver.findElement(By.xpath("//input[@id='email']")).sendKeys("lovesganesh@yahoo.com");
	   driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("umailoveu");
	   driver.findElement(By.name("login")).click();
	   Thread.sleep(3000);
	  String title= driver.getTitle();
	  System.out.println(title);
	  Assert.assertEquals(title, "Facebook");
   }
   @Epic("E001")
   @Feature("Feature2 :Logout")
   @Story("Story:LogOut presence")
   @Severity(SeverityLevel.MINOR)
   @Description("logOut verification test is Skipped")
   @Test(priority=3,description="logOut verification test is Skipped in main page")
   public void logout()
   {
	   throw new SkipException("Skipping this test");
   }
   @AfterClass
   public void teardown()
   {
	  driver.close();
   }
  
   }
	

