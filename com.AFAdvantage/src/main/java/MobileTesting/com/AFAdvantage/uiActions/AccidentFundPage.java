package MobileTesting.com.AFAdvantage.uiActions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class AccidentFundPage {
	
	RemoteWebDriver driver;

	
	@FindBy(xpath="//android.widget.TextView[@text='AF Advantage']")
	WebElement AccidentFundBanner;
	
	@FindBy(xpath="//android.widget.TextView[@text='Resources']")
	WebElement AFResources;
	
	@FindBy(xpath="//android.widget.TextView[@text='Website']")
	WebElement AFWebsite;
	
	@FindBy(xpath="//android.widget.TextView[@text='User']")
	WebElement AFUser;
	
	@FindBy(xpath="//android.widget.TextView[@text='Latest News']")
	WebElement AFLatestNews;
	
	@FindBy(xpath = "//android.widget.Button[@text='Help Desk']")
	WebElement AFHelpDesk;
	
	@FindBy(xpath = "//android.widget.Button[@text='Billing']")
	WebElement AFBilling;
	
	@FindBy(xpath = "//android.widget.Button[@text='Custom 1']")
	WebElement AFCustom1;
	
	@FindBy(xpath = "//android.widget.Button[@text='Custom 2']")
	WebElement AFCustom2;
	
	
	
	
	public AccidentFundPage(RemoteWebDriver driver)
	{
		PageFactory.initElements(driver, this);
    }
	
	
	public String getAFBrandBannerText() {
		return AccidentFundBanner.getText();
	}
	
	public String getAFResourcesText() {
		return AFResources.getText();
	}
	
	public String getAFWebSiteText() {
		return AFWebsite.getText();
	}
	
	public String getAFUserText() {
		return AFUser.getText();
	}
	
	public String getAFLatestNewsText() {
		return AFLatestNews.getText();
	}
	
	public String getAFHelpDeskText() {
		return AFHelpDesk.getText();
	}
	
	public String getAFBillingText() {
		return AFBilling.getText();
	}
	
	public String getCustom1Text() {
		return AFCustom1.getText();
	}
	
	public String getCustom2Text() {
		return AFCustom2.getText();
	}
}
