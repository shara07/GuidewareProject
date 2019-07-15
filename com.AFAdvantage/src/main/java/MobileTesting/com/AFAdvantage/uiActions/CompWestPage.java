package MobileTesting.com.AFAdvantage.uiActions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompWestPage {
	
	RemoteWebDriver driver;
	
	public CompWestPage(RemoteWebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//android.widget.TextView[@instance='0']")
	WebElement CWBrand;
	
	@FindBy(xpath="//android.widget.TextView[@instance='1']")
	WebElement CWResources;
	
	@FindBy(xpath="//android.widget.TextView[@instance='2']")
	WebElement CWWebSite;
	
	@FindBy(xpath="//android.widget.TextView[@instance='3']")
	WebElement CWUser;
	
	@FindBy(xpath="//android.widget.TextView[@instance='3']")
	WebElement CWLLatestNews;
	
	@FindBy(xpath="//android.widget.Button[@instance='1']")
	WebElement CWCompWest;
	
	@FindBy(xpath="//android.widget.Button[@instance='2']")
	WebElement CWBilling;
	
	@FindBy(xpath="//android.widget.Button[@instance='3']")
	WebElement CWCustom1;
	
	@FindBy(xpath="//android.widget.Button[@instance='4']")
	WebElement CWCustom2;
	
	public boolean cwBrandDisplayed() {
		return CWBrand.isDisplayed();
	}
	
	public boolean cwResourcesDisplayed() {
		return CWResources.isDisplayed();
	}
	
	public boolean cwWebsiteDisplayed() {
		return CWWebSite.isDisplayed();
	}
	
	public boolean cwUserDisplayed() {
		return CWUser.isDisplayed();
	}
	
	public boolean cwLatestNewsDisplayed() {
		return CWLLatestNews.isDisplayed();
	}
	
	public boolean cwCompWestDisplayed() {
		return CWWebSite.isDisplayed();
	}
	
	public boolean cwBillingDisplayed() {
		return CWBilling.isDisplayed();
	}
	
	public boolean cwCustom1Displayed() {
		return CWCustom1.isDisplayed();
	}
	
	public boolean cwCustom2Displayed() {
		return CWCustom2.isDisplayed();
	}

}
