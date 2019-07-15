package MobileTesting.com.AFAdvantage;

import java.io.File;
import java.io.IOException;
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
import MobileTesting.com.AFAdvantage.uiActions.Homepage;
import MobileTesting.com.AFAdvantage.uiActions.Websitepage;

public class TC007_Validate3CUWebsiteObjects extends TestBase {
	
	String url = "http://www.3cu.com";
	Homepage hm;
	Websitepage ws;
	
	@DataProvider(name = "userSignUpData")
	public String[][] getTestData() {
		String[][] testRecords = getData("AgentAdvantageTestData.xlsx", "SignUpData");
		return testRecords;
	}
	
	@BeforeSuite
	public void setUp() {
		extent = new ExtentReports(System.getProperty("user.dir")+"/src/main/java/MobileTesting/com/AFAdvantage/report/AgentAdvantageTestReport.html", false);
		extent.addSystemInfo("Application", "Agent Advantage");
		extent.loadConfig(new File(System.getProperty("user.dir")+"/extent-config.xml"));		
	}
	
	@BeforeTest
	public void phoneAppSetUp() throws MalformedURLException, InterruptedException {			
		settingUpPhoneAndLaunchApp(true,false);			
		}
	
	@Test(dataProvider = "userSignUpData")
	public void validate3CUMobileWebsite(String firstname, String lastname, String email, String testMode) throws InterruptedException, IOException {
		if(testMode.equalsIgnoreCase("n")) {
			throw new SkipException("User mark this record as no run.");
		}
		hm = new Homepage(driver);
		ws = new Websitepage(driver);
		
		//hm.userRegistration(firstname, lastname, email);
		hm.swapBetweenBrands("ThirdCoastUnderwriters");		
		hm.navigateToWebsiteMenu();
		driver.get(url);	
		Thread.sleep(2000);
		Assert.assertEquals(ws.tcuLogoDisplayed(), true);
		test.log(LogStatus.PASS, "ThirdCoast Underwriters logo is displayed");
		Assert.assertEquals(ws.reportWCClaimDisplayed(), true);
		test.log(LogStatus.PASS, "'Report a Workers' Compensation Claim' is displayed");
		Assert.assertEquals(ws.managingyourCompDisplayed(), true);
		test.log(LogStatus.PASS, "Managing Your Comp is displayed");
		Assert.assertEquals(ws.angleDisplayed(), true);
		test.log(LogStatus.PASS, "THE ANGLE is displayed");
		Assert.assertEquals(ws.customerToolBoxDisplayed(), true);
		test.log(LogStatus.PASS, "Customer Toolbox is displayed");
		Assert.assertEquals(ws.workSafetyDisplayed(), true);
		test.log(LogStatus.PASS, "'Do you know how to implement a successful work safetey program?' is displayed");
		Assert.assertEquals(ws.newsDisplayed(), true);
		test.log(LogStatus.PASS, "NEWS is displayed");
		Assert.assertEquals(ws.videoDisplayed(), true);
		test.log(LogStatus.PASS, "VIDEOS is displayed");
		Assert.assertEquals(ws.phoneNumberDisplayed(), true);
		test.log(LogStatus.PASS, "1-888-641-23CU is displayed");
		test.log(LogStatus.PASS, test.addScreenCapture(captureScreen("")));
	}
	
}
