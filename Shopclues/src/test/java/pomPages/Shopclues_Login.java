package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import frameworkUtils.FuncLibrary;

public class Shopclues_Login extends FuncLibrary {

	WebDriver driver;
	
	@FindBy(linkText = "//*[@id='sign-in']/a")
	WebElement Sign_in;
	
	@FindBy(id = "main_user_login")
	WebElement emailorphone;
	
	@FindBy(xpath = "//a[text()='Login via OTP']")
	WebElement login_otp;
	
	@FindBy(xpath = "//*[@id=\"login\"]/form/fieldset/div[2]/div[1]/span")
	WebElement error_message;
	
	public Shopclues_Login(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	public void enter_EmailorPhoneNo(String emailPhone) {
		
		enterText(emailorphone, emailPhone);
		
		sleep(1000);
		eleClick(login_otp);
		
	}
	
	public String verify_errorMessage() {
		String error = null;
		if(error_message.isDisplayed()) {
			
		 error = getText(error_message);
		}
		
		return error;
	}
	
	public String log_in(String emailphone) {
		
	   if(Sign_in.isDisplayed()) {
		eleClick(Sign_in);
		
	   }
		
		enter_EmailorPhoneNo(emailphone);
		
		String error = verify_errorMessage();
		
		return error;
		
		
	}
}
