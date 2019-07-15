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
import MobileTesting.com.AFAdvantage.uiActions.Userpage;

public class TC004_ValidateUserMenu extends TestBase{
	
	Homepage homepage;
	Userpage user;
	
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
	public void ValidateAFUserMenu(String firstname, String lastname, String email, String testMode) {
	
	if(testMode.equalsIgnoreCase("n")) {
		throw new SkipException("User mark this record as no run.");
	}	
	homepage = new Homepage(driver);
	user = new Userpage(driver);
	//homepage.userRegistration(firstname, lastname, email);	
	//AF
	homepage.navigateToUserMenu();
	Assert.assertEquals(user.userMenuCaptionDisplayed(), true);
	test.log(LogStatus.PASS, "'Your Information' is displayed");
	homepage.validateUserInformation(firstname, lastname, email);
	user.navigateBackToHomeScreen();
	}
	
	@Test(dataProvider = "userSignUpData" ,dependsOnMethods = {"ValidateAFUserMenu"})
	public void ValidateCWUserMenu(String firstname, String lastname, String email, String testMode) throws InterruptedException {
		
	if(testMode.equalsIgnoreCase("n")) {
		throw new SkipException("User mark this record as no run.");
	}
	//CW
	homepage.swapBetweenBrands("CompWest");
	homepage.navigateToUserMenu();
	Assert.assertEquals(user.userMenuCaptionDisplayed(), true);
	test.log(LogStatus.PASS, "'Your Information' is displayed");
	homepage.validateUserInformation(firstname, lastname, email);
	user.navigateBackToHomeScreen();
	}
	
	@Test(dataProvider = "userSignUpData", dependsOnMethods = {"ValidateCWUserMenu"})
	public void Validate3CUUserMenu(String firstname, String lastname, String email, String testMode) throws InterruptedException {
	// 3CU
	homepage.swapBetweenBrands("ThirdCoastUnderwriters");
	homepage.navigateToUserMenu();
	Assert.assertEquals(user.userMenuCaptionDisplayed(), true);
	test.log(LogStatus.PASS, "'Your Information' is displayed");
	homepage.validateUserInformation(firstname, lastname, email);
	user.navigateBackToHomeScreen();
	}
	
	@Test(dataProvider = "userSignUpData", dependsOnMethods = {"Validate3CUUserMenu"})
	public void ValidateUHUserMenu(String firstname, String lastname, String email, String testMode) throws InterruptedException {		
	// UH
	homepage.swapBetweenBrands("United Heartland");
	homepage.navigateToUserMenu();
	Assert.assertEquals(user.userMenuCaptionDisplayed(), true);
	test.log(LogStatus.PASS, "'Your Information' is displayed");
	homepage.validateUserInformation(firstname, lastname, email);
	user.navigateBackToHomeScreen();
	
	// Navigate back to Accident Fund.
	homepage.swapBetweenBrands("AccidentFund");
	}
	
	

}
