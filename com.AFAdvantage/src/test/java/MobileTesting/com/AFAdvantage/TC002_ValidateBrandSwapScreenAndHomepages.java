package MobileTesting.com.AFAdvantage;



import java.net.MalformedURLException;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import MobileTesting.com.AFAdvantage.testBase.TestBase;
import MobileTesting.com.AFAdvantage.uiActions.AccidentFundPage;
import MobileTesting.com.AFAdvantage.uiActions.CompWestPage;
import MobileTesting.com.AFAdvantage.uiActions.Homepage;
import MobileTesting.com.AFAdvantage.uiActions.ThirdCoastUnderwritersPage;
import MobileTesting.com.AFAdvantage.uiActions.UnitedHeartlandPage;

public class TC002_ValidateBrandSwapScreenAndHomepages extends TestBase{

	Homepage homepage;
	ThirdCoastUnderwritersPage tcu;
	CompWestPage cw;
	UnitedHeartlandPage uh;
	AccidentFundPage af;		
	
	@DataProvider(name = "signUpData")
	public String[][] getTestData() {
		String[][] testRecords = getData("AgentAdvantageTestData.xlsx", "SignUpData");
		return testRecords;
	}
	
	@BeforeTest
	public void phoneAppSetUp() throws MalformedURLException, InterruptedException {				
		settingUpPhoneAndLaunchApp(true, false);				
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
		
		//homepage.userRegistration(firstname, lastname, email);			
		// Accident Fund
		Assert.assertEquals(af.getAFBrandBannerText(), "AF Advantage");
		Assert.assertEquals(af.getAFResourcesText(), "Resources");
		Assert.assertEquals(af.getAFWebSiteText(), "Website");
		Assert.assertEquals(af.getAFUserText(), "User");
		Assert.assertEquals(af.getAFLatestNewsText(), "Latest News");
		Assert.assertEquals(af.getAFHelpDeskText(), "Help Desk"); 
		Assert.assertEquals(af.getAFBillingText(), "Billing");
		Assert.assertEquals(af.getCustom1Text(), "Custom 1");
		Assert.assertEquals(af.getCustom2Text(), "Custom 2");
	}
	
	@Test(dependsOnMethods = {"ValidateAFHomepage"} )
	public void ValidateCWHomepage() throws InterruptedException {
		// CompWest
		homepage.swapBetweenBrands("CompWest");
		Assert.assertEquals(cw.cwBrandDisplayed(), true);
		Assert.assertEquals(cw.cwResourcesDisplayed(), true);
		Assert.assertEquals(cw.cwWebsiteDisplayed(), true);
		Assert.assertEquals(cw.cwUserDisplayed(), true);
		Assert.assertEquals(cw.cwLatestNewsDisplayed(), true);
		Assert.assertEquals(cw.cwCompWestDisplayed(), true);
		Assert.assertEquals(cw.cwBillingDisplayed(), true);
		Assert.assertEquals(cw.cwCustom1Displayed(), true);
		Assert.assertEquals(cw.cwCustom2Displayed(), true);
	}	
	
	@Test(dependsOnMethods = {"ValidateCWHomepage"})
	public void ValidateThreeCUHomepage() throws InterruptedException {
	//3CU
		homepage.swapBetweenBrands("ThirdCoastUnderwriters");
		Assert.assertEquals(tcu.tcuBannerDisplayed(), true);
		Assert.assertEquals(tcu.tcuResourcesDisplayed(), true);
		Assert.assertEquals(tcu.tcuWebsiteDisplayed(), true);
		Assert.assertEquals(tcu.tcuUserDisplayed(), true);
		Assert.assertEquals(tcu.tcuLatestNewsDisplayed(), true);
		Assert.assertEquals(tcu.tcu3CUReceptionDisplayed(), true);
		Assert.assertEquals(tcu.tcuBillingDisplayed(), true);
		Assert.assertEquals(tcu.tcuCustom1Displayed(), true);
		Assert.assertEquals(tcu.tcuCustom2Displayed(), true);
	}
	
	@Test(dependsOnMethods = {"ValidateThreeCUHomepage"})
	public void ValidateUHHomepage() throws InterruptedException {
		//UH
		homepage.swapBetweenBrands("United Heartland");
		Assert.assertEquals(uh.uhBannerDisplayed(), true);
		Assert.assertEquals(uh.uhResourcesDisplayed(), true);
		Assert.assertEquals(uh.uhWebsiteDisplayed(), true);
		Assert.assertEquals(uh.uhUserDisplayed(), true);
		Assert.assertEquals(uh.uhLatestNewsDisplayed(), true);
		Assert.assertEquals(uh.uhHelpDeskDisplayed(), true);
		Assert.assertEquals(uh.uhBillingDisplayed(), true);
		Assert.assertEquals(uh.uhCustom1Displayed(), true);
		Assert.assertEquals(uh.uhCustom2Displayed(), true);		
		// Navigate back to Accident Fund.
		homepage.swapBetweenBrands("AccidentFund");		
	}
	
	//@AfterTest
		//public void closeApp() throws InterruptedException {
			//driver.quit();	       
		//}	
	
	
	}

