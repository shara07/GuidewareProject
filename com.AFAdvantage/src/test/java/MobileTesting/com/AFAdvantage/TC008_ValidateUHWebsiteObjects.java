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

public class TC008_ValidateUHWebsiteObjects extends TestBase{	
	
	String url = "http://www.unitedheartland.biz";
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
		settingUpPhoneAndLaunchApp(true, false);			
		}
	
	@Test(dataProvider = "userSignUpData")
	public void validateUHMobileWebsite(String firstname, String lastname, String email, String testMode) throws InterruptedException, IOException {
		
		if(testMode.equalsIgnoreCase("n")) {
			throw new SkipException("User mark this record as no run.");
		}
		hm = new Homepage(driver);
		ws = new Websitepage(driver);		
		//hm.userRegistration(firstname, lastname, email);		
		hm.swapBetweenBrands("United Heartland");	
		hm.navigateToWebsiteMenu();
		driver.get(url);	
		Thread.sleep(2000);
		Assert.assertEquals(ws.uhLogoDisplayed(), true);
		test.log(LogStatus.PASS, "UnitedHeartland is displayed");
		Assert.assertEquals(ws.reportAClaimLinkDisplayed(), true);
		test.log(LogStatus.PASS, "Report a Claim is displayed");
		Assert.assertEquals(ws.eNewsLetterDisplayed(), true);
		test.log(LogStatus.PASS, "Subscribe to our e-newsletter is displayed");
		Assert.assertEquals(ws.whatIsWorkCompDisplayed(), true);
		test.log(LogStatus.PASS, "'What is Workers Compensation?' is displayed");
		Assert.assertEquals(ws.customerToolBoxDisplayed(), true);
		test.log(LogStatus.PASS, "Customer Toolbox is displayed");
		Assert.assertEquals(ws.whitePaperDisplayed(), true);
		test.log(LogStatus.PASS, "White Paper is displayed");
		Assert.assertEquals(ws.newsDisplayed(), true);
		test.log(LogStatus.PASS, "NEWS is displayed");
		Assert.assertEquals(ws.videoDisplayed(), true);
		test.log(LogStatus.PASS, "VIDEOS is displayed");
		Assert.assertEquals(ws.riskConnectionDisplayed(), true);
		test.log(LogStatus.PASS, "RISK CONNECTION is displayed");
		Assert.assertEquals(ws.caseStudyDisplayed(), true);
		test.log(LogStatus.PASS, "CASE STUDY");
		Assert.assertEquals(ws.uhContactNumberDisplayed(), true);
		test.log(LogStatus.PASS, "1-800-258-2667");
		test.log(LogStatus.PASS, test.addScreenCapture(captureScreen("")));
		
	}
}
