package AllureReport;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;

public class AllureListener implements ITestListener {
	
	public static String getTestMethodName(ITestResult iTestResult) {
		
		System.out.println("*** Test execution " + iTestResult.getMethod().getMethodName() + " failed...");
		System.out.println(iTestResult.getMethod().getMethodName() + " failed!");
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}
	
	@Attachment
	public byte[] saveFailureScreenShot(WebDriver driver) {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}
	
	@Attachment(value ="{0}",type ="text/plain")
	public static String saveTextLog(String message)
	{
		return message;
	}
	
	 @Override		
	    public void onStart(ITestContext iTestContext) {					
	        // TODO Auto-generated method stub	
		 System.out.println("I am onStart method "+ iTestContext.getName());
		 iTestContext.setAttribute("WebDriver", BaseClass.getDriver());
	    }
	   @Override		
	    public void onFinish(ITestContext iTestContext) {					
	        // TODO Auto-generated method stub
		   System.out.println("I am onFinish method "+ iTestContext.getName());
	    }		  	
    // When Test case get Skipped, this method is called.		
    @Override		
    public void onTestSkipped(ITestResult iTestResult)					
    {		
    System.out.println("The name of the testcase Skipped is :"+iTestResult.getName());					
    }		

    // When Test case get Started, this method is called.		
    @Override		
    public void onTestStart(ITestResult iTestResult)					
    {		
    System.out.println(" test case started"+ getTestMethodName(iTestResult)+ " Started");					
    }		

     // When Test case get passed, this method is called.		
    @Override		
    public void onTestSuccess(ITestResult iTestResult)					
    {		
    System.out.println("The name of the testcase passed is :"+ getTestMethodName(iTestResult)+"Success");					
    }
    
    // When Test case get failed, this method is called.
    @Override		
    public void onTestFailure(ITestResult iTestResult) 					
    {		
    System.out.println("The name of the testcase failed is :"+getTestMethodName(iTestResult)+"Failed");	
    
    Object testclass =iTestResult.getInstance();
    WebDriver driver =BaseClass.getDriver();
    //Allure Screenshot and SaveTestLog
    if(driver instanceof WebDriver)
    {
    	System.out.println("Screenshot captured for test cases :" + getTestMethodName(iTestResult));
    	saveFailureScreenShot(driver);
    }
    saveTextLog(getTestMethodName(iTestResult) + "  failed and screenshot taken!");
    }	
	
	
	

}
