package MobileTesting.com.AFAdvantage.uiActions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThirdCoastUnderwritersPage {
	
	RemoteWebDriver driver;
	
	public ThirdCoastUnderwritersPage(RemoteWebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//android.widget.TextView[@instance='0']")
	WebElement TCUBanner;
	
	@FindBy(xpath="//android.widget.TextView[@instance='1']")
	WebElement TCUResources;
	
	@FindBy(xpath="//android.widget.TextView[@instance='2']")
	WebElement TCUWebsite;
	
	@FindBy(xpath="//android.widget.TextView[@instance='3']")
	WebElement TCUUser;
	
	@FindBy(xpath="//android.widget.TextView[@instance='4']")
	WebElement TCULatestNews;
	
	@FindBy(xpath="//android.widget.Button[@instance='1']")
	WebElement TCU3CUReception;
	
	@FindBy(xpath="//android.widget.Button[@instance='2']")
	WebElement TCUBilling;
	
	@FindBy(xpath="//android.widget.Button[@instance='3']")
	WebElement Custom1;
	
	@FindBy(xpath ="//android.widget.Button[@instance='4']")
	WebElement Custom2;
	
	public boolean tcuBannerDisplayed() {
		return TCUBanner.isDisplayed();
	}
	
	public boolean tcuResourcesDisplayed() {
		return TCUResources.isDisplayed();
	}
	
	public boolean tcuWebsiteDisplayed() {
		return TCUWebsite.isDisplayed();
	}
	
	public boolean tcuUserDisplayed() {
		return TCUUser.isDisplayed();
	}
	
	public boolean tcuLatestNewsDisplayed() {
		return TCULatestNews.isDisplayed();
	}
	
	public boolean tcu3CUReceptionDisplayed() {
		return TCU3CUReception.isDisplayed();
	}
	
	public boolean tcuBillingDisplayed() {
		return TCUBilling.isDisplayed();
	}
	
	public boolean tcuCustom1Displayed() {
		return Custom1.isDisplayed();
	}
	
	public boolean tcuCustom2Displayed() {
		return Custom2.isDisplayed();
	}

}
