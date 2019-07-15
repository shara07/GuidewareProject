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
import MobileTesting.com.AFAdvantage.uiActions.CompWestPage;
import MobileTesting.com.AFAdvantage.uiActions.Homepage;
import MobileTesting.com.AFAdvantage.uiActions.ThirdCoastUnderwritersPage;
import MobileTesting.com.AFAdvantage.uiActions.UnitedHeartlandPage;

public class TC011_ExtentReport_TC002 extends TestBase {
	
	Homepage homepage;
	ThirdCoastUnderwritersPage tcu;
	CompWestPage cw;
	UnitedHeartlandPage uh;
	AccidentFundPage af;
	
	@BeforeSuite
	public void setUp() {
		extent = new ExtentReports(System.getProperty("user.dir")+"/src/main/java/MobileTesting/com/AFAdvantage/report/AgentAdvantageTestReport.html", false);
		extent.addSystemInfo("Application", "Agent Advantage");
		extent.loadConfig(new File(System.getProperty("user.dir")+"/extent-config.xml"));		
	}	
	@DataProvider(name = "signUpData")
	public String[][] getTestData() {
		String[][] testRecords = getData("AgentAdvantageTestData.xlsx", "SignUpData");
		return testRecords;
		}
	
	@BeforeTest
	public void phoneAppSetUp() throws MalformedURLException, InterruptedException {			
		settingUpPhoneAndLaunchApp(false, false);				
		}
	
	@Test(dataProvider= "signUpData")
	public void ValidateAFHomepage(String firstname, String lastname, String email, String testMode) throws InterruptedException {
		
		if (testMode.equalsIgnoreCase("n")) {
			throw new SkipException("User marked this record as no run.");
		}				
		cw = new CompWestPage(driver);
		homepage = new Homepage(driver);
		tcu = new ThirdCoastUnderwritersPage(driver);
		uh = new UnitedHeartlandPage(driver);
		af = new AccidentFundPage(driver);	
		
		homepage.userRegistration(firstname, lastname, email);
		// Accident Fund
		Assert.assertEquals(af.getAFBrandBannerText(), "AF Advantage");
		test.log(LogStatus.PASS, "AF- AF Advantage banner is displayed");
		Assert.assertEquals(af.getAFResourcesText(), "Resources");
		test.log(LogStatus.PASS, "Resources is displayed");
		Assert.assertEquals(af.getAFWebSiteText(), "Website");
		test.log(LogStatus.PASS, "Website is displayed");
		Assert.assertEquals(af.getAFUserText(), "User");
		test.log(LogStatus.PASS, "User is displayed");
		Assert.assertEquals(af.getAFLatestNewsText(), "Latest News");
		test.log(LogStatus.PASS, "Latest News is displayed.");
		Assert.assertEquals(af.getAFHelpDeskText(), "Help Desk"); 
		test.log(LogStatus.PASS, "Help Desk is displayed.");
		Assert.assertEquals(af.getAFBillingText(), "Billing");
		test.log(LogStatus.PASS, "Billing is displayed.");
		Assert.assertEquals(af.getCustom1Text(), "Custom 1");
		test.log(LogStatus.PASS, "Custom 1 is displayed.");
		Assert.assertEquals(af.getCustom2Text(), "Custom 2");
		test.log(LogStatus.PASS, "Custom 2 is displayed.");
	}
	
	@Test(dependsOnMethods = {"ValidateAFHomepage"} )
	public void ValidateCWHomepage() throws InterruptedException {
		// CompWest		
		homepage.swapBetweenBrands("CompWest");
		Assert.assertEquals(cw.cwBrandDisplayed(), true);
		test.log(LogStatus.PASS, "CW - AF Advantage banner is displayed");
		Assert.assertEquals(cw.cwResourcesDisplayed(), true);
		test.log(LogStatus.PASS, "CW Resources is displayed");
		Assert.assertEquals(cw.cwWebsiteDisplayed(), true);
		test.log(LogStatus.PASS, "CW Website is displayed");
		Assert.assertEquals(cw.cwUserDisplayed(), true);
		test.log(LogStatus.PASS, "CW User is displayed");
		Assert.assertEquals(cw.cwLatestNewsDisplayed(), true);
		test.log(LogStatus.PASS, "CW Latest News is displayed");
		Assert.assertEquals(cw.cwCompWestDisplayed(), true);
		test.log(LogStatus.PASS, "CompWest button is displayed");
		Assert.assertEquals(cw.cwBillingDisplayed(), true);
		test.log(LogStatus.PASS, "CW Billing button is displayed");
		Assert.assertEquals(cw.cwCustom1Displayed(), true);
		test.log(LogStatus.PASS, "CW Custom 1 is displayed");
		Assert.assertEquals(cw.cwCustom2Displayed(), true);
		test.log(LogStatus.PASS, "CW Custom 2 is displayed");
	}	
	
	@Test(dependsOnMethods = {"ValidateCWHomepage"})
	public void ValidateThreeCUHomepage() throws InterruptedException {
	//3CU		
		homepage.swapBetweenBrands("ThirdCoastUnderwriters");
		Assert.assertEquals(tcu.tcuBannerDisplayed(), true);
		test.log(LogStatus.PASS, "3CU - AF Advantage banner is displayed");
		Assert.assertEquals(tcu.tcuResourcesDisplayed(), true);
		test.log(LogStatus.PASS, "3CU - Resources is displayed");
		Assert.assertEquals(tcu.tcuWebsiteDisplayed(), true);
		test.log(LogStatus.PASS, "3CU - Website is displayed");
		Assert.assertEquals(tcu.tcuUserDisplayed(), true);
		test.log(LogStatus.PASS, "3CU - User is displayed");
		Assert.assertEquals(tcu.tcuLatestNewsDisplayed(), true);
		test.log(LogStatus.PASS, "3CU - Letest News is displayed");
		Assert.assertEquals(tcu.tcu3CUReceptionDisplayed(), true);
		test.log(LogStatus.PASS, "3CU - Reception is displayed");
		Assert.assertEquals(tcu.tcuBillingDisplayed(), true);
		test.log(LogStatus.PASS, "3CU - Billing is displayed");
		Assert.assertEquals(tcu.tcuCustom1Displayed(), true);
		test.log(LogStatus.PASS, "3CU - Custom 1 is displayed");
		Assert.assertEquals(tcu.tcuCustom2Displayed(), true);
		test.log(LogStatus.PASS, "3CU - Custom 2 is displayed.");
	}
	
	@Test(dependsOnMethods = {"ValidateThreeCUHomepage"})
	public void ValidateUHHomepage() throws InterruptedException {
		//UH		
		homepage.swapBetweenBrands("United Heartland");
		Assert.assertEquals(uh.uhBannerDisplayed(), true);
		test.log(LogStatus.PASS, "UH - AF Advantage banner is displayed");
		Assert.assertEquals(uh.uhResourcesDisplayed(), true);
		test.log(LogStatus.PASS, "UH - Resources is displayed");
		Assert.assertEquals(uh.uhWebsiteDisplayed(), true);
		test.log(LogStatus.PASS, "UH - Website is displayed");
		Assert.assertEquals(uh.uhUserDisplayed(), true);
		test.log(LogStatus.PASS, "UH - User is displayed");
		Assert.assertEquals(uh.uhLatestNewsDisplayed(), true);
		test.log(LogStatus.PASS, "UH - Latest News is displayed");
		Assert.assertEquals(uh.uhHelpDeskDisplayed(), true);
		test.log(LogStatus.PASS, "UH - Help Desk is displayed");
		Assert.assertEquals(uh.uhBillingDisplayed(), true);
		test.log(LogStatus.PASS, "UH - Billing is displayed");
		Assert.assertEquals(uh.uhCustom1Displayed(), true);
		test.log(LogStatus.PASS, "UH - Custom 1 is displayed");
		Assert.assertEquals(uh.uhCustom2Displayed(), true);
		test.log(LogStatus.PASS, "UH - Custom 2 is displayed");		
		// Navigate back to Accident Fund.
		homepage.swapBetweenBrands("AccidentFund");		
	}
}
