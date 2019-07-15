package MobileTesting.com.AFAdvantage;

import java.io.IOException;
import java.net.MalformedURLException;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import MobileTesting.com.AFAdvantage.testBase.TestBase;
import MobileTesting.com.AFAdvantage.uiActions.Homepage;
import MobileTesting.com.AFAdvantage.uiActions.Resourcespage;


public class TC003_ValidateResourcesMenu extends TestBase {
	
	
	Homepage hp;
	Resourcespage reso;
	
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
		
		hp = new Homepage(driver);
		reso = new Resourcespage(driver);		
		
		//hp.userRegistration(firstname, lastname, email);
		//AF
		reso.navigateToResources();
		getScreenShot("AFResources");
		Assert.assertEquals(reso.marketingMeterialsDisplayed(), true);
		Assert.assertEquals(reso.whatWeInsureDisplayed(), true);
		Assert.assertEquals(reso.contactUs(), true);
		Assert.assertEquals(reso.accidentFundsEventsDisplayed(), true);
		Assert.assertEquals(reso.agencyTrainingDisplayed(), true);
		reso.navigateBackToMain();
		
	}
	
	@Test(dependsOnMethods = {"ValidateAFResourcesPage"})
	public void ValidateCWResourcesPage() throws InterruptedException, IOException {
		//CW
		hp.swapBetweenBrands("CompWest");
		reso.navigateToResources();
		getScreenShot("CWResources");
		Assert.assertEquals(reso.marketingMeterialsDisplayed(), true);
		Assert.assertEquals(reso.classCodeSetUpDisplayed(), true);
		Assert.assertEquals(reso.contactUs(), true);
		Assert.assertEquals(reso.compwestInTheNewsDisplayed(), true);
		Assert.assertEquals(reso.agencyTrainingDisplayed(), true);
		reso.navigateBackToMain();
	}
	
	@Test(dependsOnMethods = {"ValidateCWResourcesPage"})
	public void Validate3CUResourcesPage() throws InterruptedException, IOException {
		//3CU
		hp.swapBetweenBrands("ThirdCoastUnderwriters");
		reso.navigateToResources();
		getScreenShot("3CUResources");
		Assert.assertEquals(reso.marketingMeterialsDisplayed(), true);
		Assert.assertEquals(reso.whatWeInsureDisplayed(), true);
		Assert.assertEquals(reso.contactUs(), true);
		Assert.assertEquals(reso.segmentKnowledgeCenterDisplayed(), true);
		Assert.assertEquals(reso.agencyTrainingDisplayed(), true);
		reso.navigateBackToMain();
	}
	
	@Test(dependsOnMethods = {"Validate3CUResourcesPage"})
	public void ValidateUHResourcesPage() throws InterruptedException, IOException {
		//UH
		hp.swapBetweenBrands("United Heartland");
		reso.navigateToResources();
		getScreenShot("UHResources");
		Assert.assertEquals(reso.marketingMeterialsDisplayed(), true);
		Assert.assertEquals(reso.whatWeInsureDisplayed(), true);
		Assert.assertEquals(reso.contactUs(), true);
		Assert.assertEquals(reso.whoWeServeAppetiteDisplayed(), true);
		Assert.assertEquals(reso.agencyTrainingDisplayed(), true);
		reso.navigateBackToMain();
		
		//Navigate back to Accident Fund.
		hp.swapBetweenBrands("AccidentFund");
		
	}
	
	//@AfterTest
	//public void closeApp() throws InterruptedException {
		//driver.quit();	       
	//}	
	
	
	
	

}
