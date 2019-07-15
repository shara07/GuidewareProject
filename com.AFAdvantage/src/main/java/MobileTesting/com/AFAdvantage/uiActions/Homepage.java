package MobileTesting.com.AFAdvantage.uiActions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import MobileTesting.com.AFAdvantage.testBase.TestBase;

public class Homepage extends TestBase {
	
	RemoteWebDriver driver;
	
	@FindBy(xpath="//android.widget.Button[@bounds='[780,1770][1050,1890]']")
	WebElement Agree;
	
	@FindBy(xpath="//android.widget.Button[@text='I agree']")
	WebElement Iagree;
	
	@FindBy(xpath="//android.widget.EditText[@instance='0']")
	WebElement Firstname;
	
	@FindBy(xpath="//android.widget.EditText[@instance='1']")
	WebElement Lastname;
	
	@FindBy(xpath="//android.widget.EditText[@instance='2']")
	WebElement Email;
	
	@FindBy(xpath="//android.widget.Button[@text='Save']")
	WebElement SaveRegistrationInfo;
	
	@FindBy(xpath="//android.widget.Button[@text='Confirm']")
	WebElement ConfirmRegistration;
	
	@FindBy(xpath="//android.widget.Button[@instance='0']")
	WebElement AccidentFund;
	
	@FindBy(xpath="//android.widget.Switch[@text='OFF']")
	WebElement SetDefaultBrand;
	
	@FindBy(xpath="//android.widget.Button[@instance='4']")
	WebElement SaveSelectBrand;
	
	@FindBy(xpath = "//android.widget.Button[@text='Swap']")
	WebElement SwapBrand;
	
	@FindBy(xpath="//android.widget.Button[@instance='1']")
	WebElement CompWest;
	
	@FindBy(xpath="//android.widget.Button[@instance='2']")
	WebElement ThirdCoastUnderwriters;
	
	@FindBy(xpath="//android.widget.Button[@instance='3']")
	WebElement UnitedHeartland;
	
	@FindBy(xpath="//android.widget.TextView[@text='User']")
	WebElement User;
	
	@FindBy(xpath="//android.widget.TextView[@instance='2']")
	WebElement WebsiteMenu;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Resources']")
	WebElement ResourcesMenu;
	
	@FindBy(xpath = "//android.widget.TextView[@bounds='[165,158][1035,219]']")
	WebElement MarketingMaterials;
	
	
	public Homepage(RemoteWebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void userRegistration(String firstname, String lastname, String email) {
		
		Agree.click();
		Iagree.click();
		//Firstname.clear();
		Firstname.sendKeys(firstname);
		//Lastname.clear();
		Lastname.sendKeys(lastname);
		//Email.clear();
		Email.sendKeys(email);
		SaveRegistrationInfo.click();
		ConfirmRegistration.click();
		AccidentFund.click();
		SetDefaultBrand.click();
		SaveSelectBrand.click();
	}
	
	public void swapBetweenBrands(String brand) throws InterruptedException{
		SwapBrand.click();
		
		if (brand.equalsIgnoreCase("AccidentFund")){
			AccidentFund.click();
			
		}
		else if(brand.equalsIgnoreCase("CompWest")) {
			CompWest.click();
		}
		else if(brand.equalsIgnoreCase("ThirdCoastUnderwriters")) {
			ThirdCoastUnderwriters.click();
		}
		else if (brand.equalsIgnoreCase("United Heartland")) {
			UnitedHeartland.click();
		}
		
		SetDefaultBrand.click();
		SaveSelectBrand.click();
		Thread.sleep(4000);
		
	}
	
	public void navigateToUserMenu() {
		User.click();
	}
	
	public void validateUserInformation(String firstname, String lastname, String email) {
		if (firstname.equalsIgnoreCase(Firstname.getText())) {
			Reporter.log("Firstname is verified successfully.");
		}
		
		if (lastname.equalsIgnoreCase(Lastname.getText())) {
			Reporter.log("Lastname is verified successfully.");
		}
		
		if (email.equalsIgnoreCase(Email.getText())) {
			Reporter.log("Email address is verified successfully.");
		}
		else {
			Reporter.log("Email address is failed.");
		}
			
	}
	
	public void navigateToWebsiteMenu() {
		WebsiteMenu.click();
	}
	
	public void navigateToMarketingMaterialsScreen(){
		ResourcesMenu.click();
		MarketingMaterials.click();
		
	}
	
	

}
