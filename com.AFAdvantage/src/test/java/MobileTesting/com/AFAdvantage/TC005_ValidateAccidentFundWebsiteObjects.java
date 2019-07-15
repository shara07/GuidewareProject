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

public class TC005_ValidateAccidentFundWebsiteObjects extends TestBase {
	
	String url = "http://www.accidentfund.com";
	Homepage home;
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
	public void validateAFMobileWebsiteObjects(String firstname, String lastname, String email, String testMode) throws IOException, InterruptedException {
		
		if(testMode.equalsIgnoreCase("n")) {
			throw new SkipException("User mark this record as no run.");
		}		
		home = new Homepage(driver);
		ws = new Websitepage(driver);
		//home.userRegistration(firstname, lastname, email);
		//home.swapBetweenBrands("AccidentFund");		
		home.navigateToWebsiteMenu();		
		driver.get(url);	
		Thread.sleep(2000);
		Assert.assertEquals(ws.afLogoDisplayed(), true);
		test.log(LogStatus.PASS, "Accident Fund Logo is displayed");
		Assert.assertEquals(ws.reportAClaimLinkDisplayed(), true);
		test.log(LogStatus.PASS, "Report a Claim is displayed" );
		Assert.assertEquals(ws.eNewsLetterDisplayed(), true);
		test.log(LogStatus.PASS, "Subscribe to our e-newsletter is displayed");
		Assert.assertEquals(ws.whatIsWorkCompDisplayed(), true);
		test.log(LogStatus.PASS, "'What is Workers Compensation?' is displayed");
		Assert.assertEquals(ws.customerToolBoxDisplayed(), true);
		test.log(LogStatus.PASS, "Customer Toolbox is displayed");
		Assert.assertEquals(ws.workersCompSafetyCampaignDisplayed(), true);
		test.log(LogStatus.PASS, "Workers Compensation Safety Campaigns is displayed");
		Assert.assertEquals(ws.newsDisplayed(), true);
		test.log(LogStatus.PASS, "News is displayed");
		Assert.assertEquals(ws.videoDisplayed(), true);
		test.log(LogStatus.PASS, "Videos is displayed");
		Assert.assertEquals(ws.workSafeSolutionsDisplayed(), true);
		test.log(LogStatus.PASS, "Worksafe Solutions is displayed");
		Assert.assertEquals(ws.caseStudyDisplayed(), true);
		test.log(LogStatus.PASS, "CASE STUDY is displayed");
		Assert.assertEquals(ws.afContactDisplayed(), true);
		test.log(LogStatus.PASS, "'1-866-206-5851' is displayed");
		test.log(LogStatus.PASS, test.addScreenCapture(captureScreen("")));
	}

}
