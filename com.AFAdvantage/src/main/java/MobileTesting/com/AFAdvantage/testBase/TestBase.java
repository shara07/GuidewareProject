package MobileTesting.com.AFAdvantage.testBase;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import org.aspectj.util.FileUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import MobileTesting.com.AFAdvantage.excelReader.Excel_Reader;

public class TestBase {

public RemoteWebDriver driver;
Excel_Reader excel;
public static ExtentReports extent;
public static ExtentTest test;



public void settingUpPhoneAndLaunchApp(boolean noReset, boolean fullReset) throws MalformedURLException {
	
	File appDir = new File(System.getProperty("user.dir")+"/app/");
	File app = new File(appDir, "AgentAdvantage-Release (32).apk");
	
	//Declaring Android platform properties.
	DesiredCapabilities cap =  new DesiredCapabilities();
	cap.setCapability("device", "Android");
	cap.setCapability("deviceName", "Android");
	cap.setCapability("platformName", "Android");
	cap.setCapability("platformVersion","7.0");
	cap.setCapability("appPackage","com.afhi.agentadvantage");
	cap.setCapability("appActivity", "md50da5b987ed389e30f52660a117b247b4.SplashActivity");	
	cap.setCapability("app", app.getAbsolutePath());
	cap.setCapability("newCommandTimeout", 1000);
	cap.setCapability("noReset", noReset);
	cap.setCapability("fullReset", fullReset);
	
	// Launch app.
	driver =  new RemoteWebDriver( new URL("http://localhost:4723/wd/hub"), cap);
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	
}

public String[][] getData(String excelName, String sheetName) {
	
	String path = System.getProperty("user.dir")+ "/src/main/java/MobileTesting/com/AFAdvantage/data/"+ excelName;			
	excel = new Excel_Reader(path);
	String [][] data = excel.getDataFromSheet(sheetName, excelName);
	return data;
}

public void waitForElement(int timeOutInSeconds, WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver,timeOutInSeconds);
	wait.until(ExpectedConditions.visibilityOf(element));
}

public void getScreenShot(String name) throws IOException {
	Calendar calendar = Calendar.getInstance();
	SimpleDateFormat formater = new SimpleDateFormat("MM_dd_yyyy_hh_mm_ss");
	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	
	try {
		String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()+"/src/main/java/MobileTesting/com/AFAdvantage/screenshot/";
		File destFile = new File((String) reportDirectory+name+"_"+formater.format(calendar.getTime())+".png");
		FileUtil.copyFile(scrFile, destFile);
		// This will help us to link the screen shot in testNG report.
		Reporter.log("<a href = '"+destFile.getAbsolutePath()+"'> <img src = '"+ destFile.getAbsolutePath()+"'height = '100' width = '100'/> </a>");
	} catch (Exception e) {		
		e.printStackTrace();
	}
}


public String captureScreen(String fileName) {
	if(fileName=="") {
		fileName = "blank";
	}
	
	File destFile2 = null;
	Calendar calendar = Calendar.getInstance();
	SimpleDateFormat formater = new SimpleDateFormat("MM_dd_yyyy_hh_mm_ss");
	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	
	try {
		String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()+"/src/main/java/MobileTesting/com/AFAdvantage/screenshot/";
		destFile2 = new File((String) reportDirectory+fileName+"_"+formater.format(calendar.getTime())+".png");
		FileUtil.copyFile(scrFile, destFile2);
		// This will help us to link the screen shot in testNG report.
		Reporter.log("<a href = '"+destFile2.getAbsolutePath()+"'> <img src = '"+ destFile2.getAbsolutePath()+"'height = '100' width = '100'/> </a>");
	} catch (Exception e) {		
		e.printStackTrace();
	}
	return destFile2.toString();
}


@BeforeMethod
public void beforeMethod(Method result) {
	test = extent.startTest(result.getName());
	test.log(LogStatus.INFO, result.getName()+ " test Started");
}

@AfterMethod
public void afterTestMethod(ITestResult result) {
	try {
		if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(LogStatus.PASS, result.getName()+ "test is pass");
			
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			test.log(LogStatus.SKIP, result.getName()+ " Test is skipped and skip reason is :- "+result.getThrowable());
		}
		else if(result.getStatus()==ITestResult.FAILURE) {
			test.log(LogStatus.ERROR, result.getName()+ " test is failed." + result.getThrowable());
			test.log(LogStatus.FAIL, test.addScreenCapture(captureScreen("")));
		}
		else if(result.getStatus()==ITestResult.STARTED) {
			test.log(LogStatus.INFO, result.getName() + " test is started.");
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	extent.endTest(test);
}


@AfterTest(alwaysRun = true)
public void closeApp() {
	
	test.log(LogStatus.PASS, "Application closed successfully");	
	extent.flush();
	
	
	
	driver.quit();
}

@AfterSuite
public void closeReporting() {
	extent.close();
}

}
