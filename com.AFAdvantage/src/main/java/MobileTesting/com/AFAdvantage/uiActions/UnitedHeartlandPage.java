package MobileTesting.com.AFAdvantage.uiActions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UnitedHeartlandPage {
	
	RemoteWebDriver driver;
	
	public UnitedHeartlandPage(RemoteWebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//android.widget.TextView[@text='AF Advantage']")
	WebElement UHBanner;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Resources']")
	WebElement UHResources;
	
	@FindBy(xpath="//android.widget.TextView[@text='Website']")
	WebElement UHWebsite;
	
	@FindBy(xpath="//android.widget.TextView[@text='User']")
	WebElement UHUser;
	
	@FindBy(xpath="//android.widget.TextView[@text='Latest News']")
	WebElement UHLatestNews;
	
	@FindBy(xpath="//android.widget.Button[@text='Help Desk']")
	WebElement UHHelpDesk;
	
	@FindBy(xpath = "//android.widget.Button[@text='Billing']" )
	WebElement UHBilling;
	
	@FindBy(xpath = "//android.widget.Button[@text='Custom 1']")
	WebElement UHCustom1;
	
	@FindBy(xpath = "//android.widget.Button[@text='Custom 2']")
    WebElement UHCustom2;
	
	public boolean uhBannerDisplayed() {
		return UHBanner.isDisplayed();
	}
	
	public boolean uhResourcesDisplayed() {
		return UHResources.isDisplayed();
	}
	
	public boolean uhWebsiteDisplayed() {
		return UHWebsite.isDisplayed();
	}
	
	public boolean uhUserDisplayed() {
		return UHUser.isDisplayed();
	}
	
	public boolean uhLatestNewsDisplayed() {
		return UHLatestNews.isDisplayed();
	}
	
	public boolean uhHelpDeskDisplayed() {
		return UHHelpDesk.isDisplayed();
	}
	
	public boolean uhBillingDisplayed() {
		return UHBilling.isDisplayed();
	}
	
	public boolean uhCustom1Displayed() {
		return UHCustom1.isDisplayed();
	}
	
	public boolean uhCustom2Displayed() {
		return UHCustom2.isDisplayed();
	}
}
