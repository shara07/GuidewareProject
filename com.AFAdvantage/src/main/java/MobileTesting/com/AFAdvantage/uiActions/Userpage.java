package MobileTesting.com.AFAdvantage.uiActions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Userpage {
	
	RemoteWebDriver driver;
	
	public Userpage(RemoteWebDriver driver) {
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(xpath="//android.widget.TextView[@text='Your Information']")
	 WebElement UserMenuCaption;
	
	@FindBy(xpath="//android.widget.Button[@index='0']")
	WebElement NavigateBackToMain;
	
	public boolean userMenuCaptionDisplayed() {
		try {
			return UserMenuCaption.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public void navigateBackToHomeScreen() {
		
		NavigateBackToMain.click();		
	}

}
