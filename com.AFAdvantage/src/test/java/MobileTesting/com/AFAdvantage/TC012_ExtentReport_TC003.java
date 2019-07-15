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
import MobileTesting.com.AFAdvantage.uiActions.Resourcespage;

public class TC012_ExtentReport_TC003 extends TestBase{
	
	Homepage hm;
	Resourcespage reso;
	
	@BeforeSuite
	public void setUp() {
		extent = new ExtentReports(System.getProperty("user.dir")+"/src/main/java/MobileTesting/com/AFAdvantage/report/AgentAdvantageTestReport.html", false);
		extent.addSystemInfo("Application", "Agent Advantage");
		extent.loadConfig(new File(System.getProperty("user.dir")+"/extent-config.xml"));		
	}
			
	@DataProvider(name="signUpData")
	public String[][] getTestData() {
		String[][] testRecords = getData("AgentAdvantageTestData.xlsx", "SignUpData");
		return testRecords;
	}
	
	@BeforeTest
	public void phoneAppSetUp() throws MalformedURLException, InterruptedException {			
		settingUpPhoneAndLaunchApp(true, false);				
		}
	
	@Test(dataProvider = "signUpData")
	public void ValidateAFResourcesPage(String firstname, String lastname, String email, String testMode) throws IOException, InterruptedException {
		if(testMode.equalsIgnoreCase("n")) {
			throw new SkipException("User mark this record as no run.");
		}		
		hm = new Homepage(driver);
		reso = new Resourcespage(driver);		
		
		//hm.userRegistration(firstname, lastname, email);
		//AF
		reso.navigateToResources();
		//getScreenShot("AFResources");
		test.log(LogStatus.PASS, test.addScreenCapture(captureScreen("")));
		Assert.assertEquals(reso.marketingMeterialsDisplayed(), true);
		test.log(LogStatus.PASS, "AF - 'Marketing Material' is displayed");
		Assert.assertEquals(reso.whatWeInsureDisplayed(), true);
		test.log(LogStatus.PASS, "AF - 'What We Insure' is displayed");
		Assert.assertEquals(reso.contactUs(), true);
		test.log(LogStatus.PASS, "AF - Contact Us is displayed");
		Assert.assertEquals(reso.accidentFundsEventsDisplayed(), true);
		test.log(LogStatus.PASS, "AF - Accident Funds Events is displayed");
		Assert.assertEquals(reso.agencyTrainingDisplayed(), true);
		test.log(LogStatus.PASS, "AF - Agency Training is displayed");
		reso.navigateBackToMain();		
	}
	
	@Test(dependsOnMethods = {"ValidateAFResourcesPage"})
	public void ValidateCWResourcesPage() throws InterruptedException, IOException {
		//CW
		hm.swapBetweenBrands("CompWest");
		reso.navigateToResources();
		//getScreenShot("CWResources");
		test.log(LogStatus.PASS, test.addScreenCapture(captureScreen("")));
		Assert.assertEquals(reso.marketingMeterialsDisplayed(), true);
		test.log(LogStatus.PASS, "CW - 'Marketing Material' is displayed");
		Assert.assertEquals(reso.classCodeSetUpDisplayed(), true);
		test.log(LogStatus.PASS, "CW - Class Code Setup is displayed");
		Assert.assertEquals(reso.contactUs(), true);
		test.log(LogStatus.PASS, "CW - Contact Us is displayed");
		Assert.assertEquals(reso.compwestInTheNewsDisplayed(), true);
		test.log(LogStatus.PASS, "CW - 'Comp West In The News' is displayed");
		Assert.assertEquals(reso.agencyTrainingDisplayed(), true);
		test.log(LogStatus.PASS, "CW - Agency Training is displayed");
		reso.navigateBackToMain();
	}
	
	@Test(dependsOnMethods = {"ValidateCWResourcesPage"})
	public void Validate3CUResourcesPage() throws InterruptedException, IOException {
		//3CU
		hm.swapBetweenBrands("ThirdCoastUnderwriters");
		reso.navigateToResources();
		//getScreenShot("3CUResources");
		test.log(LogStatus.PASS, test.addScreenCapture(captureScreen("")));
		Assert.assertEquals(reso.marketingMeterialsDisplayed(), true);
		test.log(LogStatus.PASS, "3CU - 'Marketing Material' is displayed");
		Assert.assertEquals(reso.whatWeInsureDisplayed(), true);
		test.log(LogStatus.PASS, "3CU - 'What We Insure' is displayed");
		Assert.assertEquals(reso.contactUs(), true);
		test.log(LogStatus.PASS, "3CU - Contact Us is displayed");
		Assert.assertEquals(reso.segmentKnowledgeCenterDisplayed(), true);
		test.log(LogStatus.PASS, "3CU - Segment Knowledge Center is displayed");
		Assert.assertEquals(reso.agencyTrainingDisplayed(), true);
		test.log(LogStatus.PASS, "3CU - Agency Training is displayed");
		reso.navigateBackToMain();
	}
	
	@Test(dependsOnMethods = {"Validate3CUResourcesPage"})
	public void ValidateUHResourcesPage() throws InterruptedException, IOException {
		//UH
		hm.swapBetweenBrands("United Heartland");
		reso.navigateToResources();
		//getScreenShot("UHResources");
		test.log(LogStatus.PASS, test.addScreenCapture(captureScreen("")));
		Assert.assertEquals(reso.marketingMeterialsDisplayed(), true);
		test.log(LogStatus.PASS, "UH - 'Marketing Material' is displayed");
		Assert.assertEquals(reso.whatWeInsureDisplayed(), true);
		test.log(LogStatus.PASS, "UH - 'What We Insure' is displayed");
		Assert.assertEquals(reso.contactUs(), true);
		test.log(LogStatus.PASS, "UH - Contact Us is displayed");
		Assert.assertEquals(reso.whoWeServeAppetiteDisplayed(), true);
		test.log(LogStatus.PASS, "UH - 'Who We Serve Appetite' is displayed");
		Assert.assertEquals(reso.agencyTrainingDisplayed(), true);
		test.log(LogStatus.PASS, "UH - Agency Training is displayed");
		reso.navigateBackToMain();		
		//Navigate back to Accident Fund.
		hm.swapBetweenBrands("AccidentFund");		
	}

}
