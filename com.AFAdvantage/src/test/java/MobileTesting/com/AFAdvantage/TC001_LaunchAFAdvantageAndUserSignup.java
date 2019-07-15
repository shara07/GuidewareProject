package MobileTesting.com.AFAdvantage;
import java.io.File;
import java.net.MalformedURLException;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import MobileTesting.com.AFAdvantage.testBase.TestBase;
import MobileTesting.com.AFAdvantage.uiActions.AccidentFundPage;
import MobileTesting.com.AFAdvantage.uiActions.Homepage;

public class TC001_LaunchAFAdvantageAndUserSignup extends TestBase {	
		
	Homepage homepage;
	AccidentFundPage af;
	
	@BeforeSuite
	public void setUp() {
		extent = new ExtentReports(System.getProperty("user.dir")+"/src/main/java/MobileTesting/com/AFAdvantage/report/AgentAdvantageTestReport.html", false);
		extent.addSystemInfo("Application", "Agent Advantage");
		extent.loadConfig(new File(System.getProperty("user.dir")+"/extent-config.xml"));		
	}
	
	@DataProvider(name="userSignupData")
	public String[][] getTestData() {
		String[][] testRecords = getData("AgentAdvantageTestData.xlsx", "SignUpData");
		return testRecords;
	}
	
	@BeforeTest
	public void phoneAppSetUp() throws MalformedURLException, InterruptedException {				
		settingUpPhoneAndLaunchApp(false, false);			
		}	
	
	@Test(dataProvider = "userSignupData")
	public void openAFAdvantageApp (String firstname, String lastname, String email, String runMode) throws InterruptedException {		
		    if (runMode.equalsIgnoreCase("n")) {
		    	throw new SkipException("User marked this record as no run.");
		    }		    
			homepage = new Homepage(driver);	
			af = new AccidentFundPage(driver);			
			homepage.userRegistration(firstname, lastname, email);				
			// Validate Accident Fund page objects.
			Assert.assertEquals(af.getAFBrandBannerText(), "AF Advantage");
			test.log(LogStatus.PASS, "Accident Funds - 'AF Advantage' is displayed");
			Assert.assertEquals(af.getAFResourcesText(), "Resources");
			test.log(LogStatus.PASS, "Accident Funds - Resources is displayed");
			Assert.assertEquals(af.getAFWebSiteText(), "Website");
			test.log(LogStatus.PASS, "Accident Funds - Website is displayed");
			Assert.assertEquals(af.getAFUserText(), "User");
			test.log(LogStatus.PASS, "Accident Funds - User is displayed");
			Assert.assertEquals(af.getAFLatestNewsText(), "Latest News");
			test.log(LogStatus.PASS, "Accident Funds - Latest News is displayed");
			Assert.assertEquals(af.getAFHelpDeskText(), "Help Desk"); 
			test.log(LogStatus.PASS, "Accident Funds - Help Desk is displayed");
			Assert.assertEquals(af.getAFBillingText(), "Billing");
			test.log(LogStatus.PASS, "Accident Funds - Billing is displayed");
			Assert.assertEquals(af.getCustom1Text(), "Custom 1");
			test.log(LogStatus.PASS, "Accident Funds - Custom 1 is displayed");
			Assert.assertEquals(af.getCustom2Text(), "Custom 2");
			test.log(LogStatus.PASS, "Accident Funds - Custom 2 is displayed");			
	}		
	
}
