package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//input[@id='email']")
	WebElement txtEmail;
	
	@FindBy(xpath = "//input[@type='password']")
	WebElement txtpwd;
	
	@FindBy(xpath = "//button[@id='send2']")
	WebElement btnlogin;
	
	
	public void setEmailAddress(String email) {
		txtEmail.sendKeys(email);

	}
	public void setPassword(String pwd) {
		txtpwd.sendKeys(pwd);

	}
	public void clickLogin() {
		btnlogin.click();;

	}

}
