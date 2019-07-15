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
import MobileTesting.com.AFAdvantage.uiActions.Homepage;
import MobileTesting.com.AFAdvantage.uiActions.Resourcespage;

public class TC010_Validate3CUMarketingMaterialScreenAndEmailDocuments extends TestBase{	
	
	Homepage hm;
	Resourcespage res;
	
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
	public void validate3CUMarketingMeterialAndEmailAFSpecificInfo(String firstname, String lastname, String email, String testMode) throws InterruptedException {
		if(testMode.equalsIgnoreCase("n")) {
			throw new SkipException("User mark this record as no run.");
		}
		
		hm = new Homepage(driver);
		res = new Resourcespage(driver);		
		//hm.userRegistration(firstname, lastname, email);
		hm.swapBetweenBrands("ThirdCoastUnderwriters");		
		res.open3CUMarketingMaterialScreen();		
		Assert.assertEquals(res.homeButtonDisplayed(), true);
		test.log(LogStatus.PASS, "Home button is displayed");
		Assert.assertEquals(res.marketingMaterialsBannerDisplayed(), true);
		test.log(LogStatus.PASS, "Marketing Material is displayed");
		Assert.assertEquals(res.filterButtonDisplayed(), true);			
		// Open the Filter screen.
		res.navigateToFiltersScreen();
		Assert.assertEquals(res.filtersBannerDisplayed(), true);		
		res.closeFilterScreen();		
		//Open Agribusiness segment guide with class codes pdf document.		
		res.openAgribusinessSegmentGuideWithClassCodes();			
		// Select all materials documents and email them.
		res.selectAllMaterialsDocAndEmail();
		test.log(LogStatus.PASS, "Material documents are emailed successfully.");		
	}
	
	@Test(dependsOnMethods = {"validate3CUMarketingMeterialAndEmailAFSpecificInfo"})
	public void validateUHMarketingMeterialAndEmailAFSpecificInfo() throws InterruptedException {
		
		hm.swapBetweenBrands("United Heartland");		
		hm.navigateToMarketingMaterialsScreen();		
		Assert.assertEquals(res.homeButtonDisplayed(), true);
		test.log(LogStatus.PASS, "Home button is displayed");
		Assert.assertEquals(res.marketingMaterialsBannerDisplayed(), true);
		test.log(LogStatus.PASS, "Marketing Material is displayed");
		Assert.assertEquals(res.filterButtonDisplayed(), true);	
		test.log(LogStatus.PASS, "Filter is displayed");
		// Open the Filter screen.
		res.navigateToFiltersScreen();
		Assert.assertEquals(res.filtersBannerDisplayed(), true);		
		res.closeFilterScreen();		
		//Open UH Average cost per claim filter pdf document.
		//res.openUHAverageCostPerClaimFilterDoc();		
		// Select all materials documents and email them.
		res.selectAllMaterialsDocAndEmail();
		test.log(LogStatus.PASS, "Material documents are emailed successfully.");
	}
}
