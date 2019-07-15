package MobileTesting.com.AFAdvantage.uiActions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Websitepage {
	
	RemoteWebDriver driver;
	
	public Websitepage(RemoteWebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//android.view.View[@text='Accident Fund Insurance Company of America logo']")
	WebElement AFLogo;
	
	@FindBy(xpath="//android.view.View[@text='Report a Claim Learn More']")
	WebElement ReportClaim;
	
	@FindBy(xpath="//android.view.View[@text='Subscribe to our e-newsletter Learn More']")
	WebElement ENewsLetter;
	
	@FindBy(xpath="//android.view.View[@text='What is Workers’ Compensation? LEARN MORE']")
	WebElement WhatIsWorkersComp;
	
	@FindBy(xpath="//android.view.View[@text='Customer Toolbox LEARN MORE']")
	WebElement CustomerToolbox;
	
	@FindBy(xpath="//android.view.View[@text='Workers’ Compensation Safety Campaigns LEARN MORE']")
	WebElement WorkersCompSafetyCampaigns;
	
	@FindBy(xpath="//android.view.View[@text='NEWS']")
	WebElement News;
	
	@FindBy(xpath="//android.view.View[@text='VIDEOS']")
	WebElement Videos;
	
	@FindBy(xpath= "//android.view.View[@text='WORKSAFE SOLUTIONS']")
	WebElement WORKSAFESOLUTIONS;
	
	@FindBy(xpath = "//android.view.View[@text='CASE STUDY']")
	WebElement CaseStudy;
	
	@FindBy(xpath="//android.view.View[@text='CompWest Insurance Company logo']")
	WebElement CWLogo;
	
	@FindBy(xpath="//android.view.View[@text='Did you see that our address changed? CompWest Insurance Company LEARN MORE']")
	WebElement AddressChanged;
	
	@FindBy(xpath="//android.view.View[@text='eLink Info for Agents LEARN MORE']")
	WebElement ELinkForAgents;
	
	@FindBy(xpath="//android.view.View[@text='INMOTION']")
	WebElement Inmotion;
	
	@FindBy(xpath = "//android.view.View[@text='Third Coast Underwriters logo']")
	WebElement ThirdCULogo;
	
	@FindBy(xpath = "//android.view.View[@text='Report a Workers’ Compensation Claim Learn More']")
	WebElement ReportWCClaim;
	
	@FindBy(xpath = "//android.view.View[@text='Managing Your Comp Learn More']")
	WebElement ManagingYourComp;
	
	@FindBy(xpath = "//android.view.View[@text='THE ANGLE LEARN MORE']")
	WebElement Angle;
	
	@FindBy(xpath = "//android.view.View[@text='Do you know how to implement a successful work safety program? LEARN MORE']")
	WebElement SuccessfulWSProgram;
	
	@FindBy(xpath = "//android.view.View[@text='1-866-641-23CU']")
	WebElement Phone3CU;
	
	@FindBy(xpath="//android.view.View[@text='United Wisconsin Insurance Company logo']")
	WebElement UHLogo;
	
	@FindBy(xpath = "//android.view.View[@text='White Paper LEARN MORE']")
	WebElement WhitePaper;
	
	@FindBy(xpath = "//android.view.View[@text='RISK CONNECTION']")
	WebElement RiskConnection;
	
	@FindBy(xpath = "//android.view.View[@text='1-800-258-2667']")
	WebElement UHContact;
	
	@FindBy(xpath = "//android.view.View[@text='1-866-206-5851']")
	WebElement AFContact;
	
	@FindBy(xpath = "//android.view.View[@text='1-888-CompWest']")
	WebElement CWContact;
	
	public boolean afLogoDisplayed() {
		try {
			return AFLogo.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean reportAClaimLinkDisplayed() {
		try {
			return ReportClaim.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean eNewsLetterDisplayed() {
		try {
			return ENewsLetter.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean whatIsWorkCompDisplayed() {
		try {
			return WhatIsWorkersComp.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean customerToolBoxDisplayed() {
		try {
			return CustomerToolbox.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean workersCompSafetyCampaignDisplayed() {
		try {
			return WorkersCompSafetyCampaigns.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean newsDisplayed() {
		try {
			return News.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean videoDisplayed() {
		try {
			return Videos.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean workSafeSolutionsDisplayed() {
		try {
			return WORKSAFESOLUTIONS.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean caseStudyDisplayed() {
		try {
			return CaseStudy.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean cwLogoDisplayed() {
		try {
			CWLogo.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean addressChangedLinkDisplayed() {
		try {
			return AddressChanged.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean eLinkForAgentsDisplayed() {
		try {
			return ELinkForAgents.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean inMotionDisplayed() {
		try {
			return Inmotion.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean tcuLogoDisplayed() {
		try {
			return ThirdCULogo.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean reportWCClaimDisplayed() {
		try {
			return ReportWCClaim.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean managingyourCompDisplayed() {
		try {
			return ManagingYourComp.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean angleDisplayed() {
		try {
			return Angle.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean workSafetyDisplayed() {
		try {
			return SuccessfulWSProgram.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean phoneNumberDisplayed() {
		try {
			return Phone3CU.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean uhLogoDisplayed() {
		try {
			UHLogo.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;			
		}
		
	}
	
	public boolean whitePaperDisplayed() {
		try {
			WhitePaper.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean riskConnectionDisplayed() {
		return RiskConnection.isDisplayed();
	}
	
	public boolean uhContactNumberDisplayed() {
		return UHContact.isDisplayed();
	}
	
	public boolean afContactDisplayed() {
		return AFContact.isDisplayed();
	}
	
	public boolean cwContactDisplayed() {
		return CWContact.isDisplayed();
	}

}
