package MobileTesting.com.AFAdvantage.uiActions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MobileTesting.com.AFAdvantage.testBase.TestBase;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Resourcespage extends TestBase{
	
	RemoteWebDriver driver;
	
	public Resourcespage(RemoteWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	

	@FindBy(xpath="//android.widget.TextView[@text='Resources']")
	WebElement ResourcesTab;
	
	@FindBy(xpath="//android.widget.TextView[@bounds='[165,158][1035,219]']")
	WebElement MarketingMeterials;
	
	@FindBy(xpath="//android.widget.ImageView[@bounds='[60,149][120,227]']")
	WebElement MarketingMaterialsImage;
	
	@FindBy(xpath="//android.widget.TextView[@text='What We Insure']")
	WebElement WhatWeInsure;
	
	@FindBy(xpath="//android.widget.TextView[@text='Contact Us']")
	WebElement ContactUs;
	
	@FindBy(xpath="//android.widget.TextView[@text='Accident Fund Events']")
	WebElement AccidentFundsEvents;
	
	@FindBy(xpath="//android.widget.TextView[@text='Agency Training']")
	WebElement AgencyTraining;
	
	@FindBy(xpath="//android.widget.Button[@instance='0']")
	WebElement NavigateBack;
	
	@FindBy(xpath="//android.widget.TextView[@text='Class Code Lookup']")
	WebElement ClassCodeSetUp;
	
	@FindBy(xpath="//android.widget.TextView[@text='CompWest in the News']")
	WebElement CompwestInTheNews;
	
	@FindBy(xpath="//android.widget.TextView[@text='Segment Knowledge Center']")
	WebElement SegmentKnowledgeCenter;
	
	@FindBy(xpath="//android.widget.TextView[@text='Who We Serve/Appetite']")
	WebElement WhoWeServeAppetite;
	
	@FindBy(xpath="//android.widget.Button[@bounds='[81,33][147,99]']")
	WebElement Home;
	
	@FindBy(xpath="//android.widget.TextView[@bounds='[295,30][749,98]']")
	WebElement MarketingMaterialsBanner;
	
	@FindBy(xpath = "//android.widget.Button[@text='Filter']")
	WebElement Filter;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Filters']")
	WebElement FiltersBanner;
	
	@FindBy(xpath = "//android.widget.Button[@text='Done']")
	WebElement Done;
	
	@FindBy(xpath = "//android.widget.CheckBox[@instance='0']")
	WebElement FirstDocument;
	
	@FindBy(xpath = "//android.widget.TextView[@bounds='[165,264][942,360]']")
	WebElement FirstDocumentName;
	
	@FindBy(xpath = "//android.widget.ImageButton[@bounds='[0,72][168,240]']")
	WebElement CloseDocument;
	
	@FindBy(xpath = "//android.widget.CheckBox[@instance='1']")
	WebElement SecondDocument;
	
	@FindBy(xpath = "//android.widget.CheckBox[@instance='2']")
	WebElement ThirdDocument;
	
	@FindBy(xpath = "//android.widget.CheckBox[@instance='3']")
	WebElement ForthDocument;
	
	@FindBy(xpath = "//android.widget.CheckBox[@instance='4']")
	WebElement FifthDocument;
	
	@FindBy(xpath = "//android.widget.CheckBox[@instance='5']")
	WebElement SixthDocument;
	
	@FindBy(xpath = "//android.widget.CheckBox[@instance='6']")
	WebElement SeventhDocument;
	
	@FindBy(xpath = "//android.widget.CheckBox[@instance='7']")
	WebElement EightDocument;
	
	@FindBy(xpath = "//android.widget.CheckBox[@instance='8']")
	WebElement NinethDocument;
	
	@FindBy(xpath = "//android.widget.CheckBox[@instance='9']")
	WebElement TenthDocument;
	
	@FindBy(xpath = "//android.widget.Button[@instance='3']")
	WebElement SendEmail;
	
	@FindBy(xpath = "//android.widget.Button[@bounds='[543,1179][948,1323]']")
	WebElement Submit;
	
	@FindBy(xpath = "//android.widget.Button[@text='OK']")
	WebElement ConfirmSubmission;
	
	@FindBy(xpath = "//android.widget.TextView[@bounds='[165,418][942,532]']")
	WebElement OpenSecondPDFDocument;
	
	
	
	
	
	
	public void navigateToResources() throws InterruptedException {
		ResourcesTab.click();
		Thread.sleep(1000);
	}
	
	public void navigateBackToMain() {
		NavigateBack.click();
	}
	
	public boolean marketingMeterialsDisplayed() {
		try {
			return MarketingMeterials.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean whatWeInsureDisplayed() {
		try {
			return WhatWeInsure.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean contactUs() {
		try {
			ContactUs.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean accidentFundsEventsDisplayed() {
		try {
			AccidentFundsEvents.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean agencyTrainingDisplayed() {
		try {
			AgencyTraining.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean classCodeSetUpDisplayed() {
		try {
			ClassCodeSetUp.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean compwestInTheNewsDisplayed() {
		try {
			CompwestInTheNews.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean segmentKnowledgeCenterDisplayed() {
		return SegmentKnowledgeCenter.isDisplayed();
	}
	
	public boolean whoWeServeAppetiteDisplayed() {
		return WhoWeServeAppetite.isDisplayed();
	}
	
	public boolean homeButtonDisplayed() {
		return Home.isDisplayed();
	}
	
	public void navigateToHomeScreen() {
		Home.click();
	}
	
	public boolean marketingMaterialsBannerDisplayed() {
		
		try {
			MarketingMaterialsBanner.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean filterButtonDisplayed() {
		try {
			Filter.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public void navigateToFiltersScreen() {
		Filter.click();
	}
	
	public boolean filtersBannerDisplayed() {
		try {
			FiltersBanner.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public void closeFilterScreen() {
		Done.click();
	}
	
	
	public void selectAllMaterialsDocAndEmail() {
		
		SecondDocument.click();
		ThirdDocument.click();
		ForthDocument.click();
		FifthDocument.click();
		SixthDocument.click();
		SeventhDocument.click();
		EightDocument.click();
		NinethDocument.click();
		TenthDocument.click();
		SendEmail.click();
		Submit.click();
		ConfirmSubmission.click();
		Home.click();
	}
	
	public void openAgribusinessSegmentGuideWithClassCodes() throws InterruptedException{
		
		SecondDocument.click();
		OpenSecondPDFDocument.click();
		Thread.sleep(4000);
		CloseDocument.click();
		FirstDocument.click();
		SecondDocument.click();
	}
	
	public void openUHAverageCostPerClaimFilterDoc() throws InterruptedException{
		
		FirstDocument.click();
		FirstDocumentName.click();;
		Thread.sleep(4000);
		CloseDocument.click();
	}
	
	public void openAFAtAGlanceDoc() throws InterruptedException{
		
		FirstDocument.click();
		FirstDocumentName.click();
		Thread.sleep(4000);
		CloseDocument.click();
	}
	
	public void openDiscoverTheDifferenceDoc() throws InterruptedException{
		FirstDocument.click();
		FirstDocumentName.click();
		Thread.sleep(4000);
		CloseDocument.click();
	}
	
	public void open3CUMarketingMaterialScreen() throws InterruptedException {
		ResourcesTab.click();
		MarketingMaterialsImage.click();
		Thread.sleep(4000);	
	}
}
