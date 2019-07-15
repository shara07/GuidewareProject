package MobileTesting.com.AFAdvantage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;





public class AndroidDriverTest {
	
	private AppiumDriver<WebElement> driver;
	String firstname = "Thushar";
	String lastname = "Ameen";
	String email = "thushara@accidentfund.com";
	
	@BeforeTest
	public void SetUp() throws MalformedURLException {
		
	
	File appDir = new File(System.getProperty("user.dir")+"/app/");
	File app = new File(appDir, "AgentAdvantage-Release (32).apk");	
	//Declaring Android platform properties.
	DesiredCapabilities cap =  new DesiredCapabilities();
	cap.setCapability("device", "Android");
	
	cap.setCapability("deviceName", "Galaxy S7 edge");
	cap.setCapability("platformName", "Android");	
	cap.setCapability("platformVersion","7.0");
	cap.setCapability("phoneOnly", true);
	
	cap.setCapability("appPackage","com.afhi.agentadvantage");
	cap.setCapability("appActivity", "md50da5b987ed389e30f52660a117b247b4.SplashActivity");	
	cap.setCapability("app", app.getAbsolutePath());
	cap.setCapability("newCommandTimeout", 1000);
	//cap.setCapability("noReset", noReset);
	//cap.setCapability("fullReset", fullReset);
	
	// Launch app.
	driver = new AndroidDriver<WebElement> (new URL("http://127.0.0.1:4723/wd/hub"), cap); 
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	
	@Test
	public void openAFAdvantageApp() throws InterruptedException {
		
	    driver.findElement(By.xpath("//android.widget.Button[@text='Agree']")).click();
	    driver.findElement(By.xpath("//android.widget.Button[@text='I agree']")).click();
	    driver.findElement(By.xpath("//android.widget.EditText[@bounds='[345,165][1050,278]']")).sendKeys(firstname);
	    driver.findElement(By.xpath("//android.widget.EditText[@bounds='[345,347][1050,460]']")).sendKeys(lastname);
	    driver.findElement(By.xpath("//android.widget.EditText[@bounds='[345,529][1050,635]']")).sendKeys(email);
	    driver.findElement(By.xpath("//android.widget.Button[@bounds='[780,719][1050,839]']")).click();
	    driver.findElement(By.xpath("//android.widget.Button[@bounds='[530,1174][1005,1318]']")).click();
	    driver.findElement(By.xpath("//android.widget.Button[@bounds='[0,179][1080,462]']")).click();
	    driver.findElement(By.xpath("//android.widget.Switch[@bounds='[250,1595][556,1679]']")).click();
	    driver.findElement(By.xpath("//android.widget.Button[@bounds='[420,1739][690,1859]']")).click();
	    Assert.assertEquals(true, driver.findElement(By.xpath("//android.widget.TextView[@text='AF Advantage']")).isDisplayed());
	    Assert.assertEquals(true, driver.findElement(By.xpath("//android.widget.Button[@text='Swap']")).isDisplayed());
	    driver.findElement(By.xpath("//android.widget.TextView[@text='Website']")).click();
	    Thread.sleep(3000);
	    Set<String> contexts = driver.getContextHandles();
	    System.out.println("Context name: "+contexts);
	    for (String s: contexts) {
	    	if (s.contains("WEBVIEW_chrome")) {
	    		System.out.println("What is s : " + s);
	    		driver.context(s);	
	    		Assert.assertEquals(true, driver.findElement(By.xpath("//android.view.View[@bounds='[84,240][570,504]']")).isDisplayed());
	    	}  else {
	    		Reporter.log("Unable to open Webview, App was crashed.");
	    	}
	    		
	    }
	    
	        
    		
	   
   }
	
	@AfterTest
	public void closeApplication() {
		driver.quit();
	}

}
