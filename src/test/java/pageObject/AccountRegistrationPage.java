package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage {
	

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "firstname")
	WebElement txtFirstname;
	@FindBy(xpath = "//input[@id='middlename']")
	WebElement txtMiddlename;
	@FindBy(xpath = "//input[@id='lastname']")
	WebElement txtLastname;
	@FindBy(xpath = "//input[@id='email_address']")
	WebElement txtEmail;
	@FindBy(xpath = "//input[@id='password']")
	WebElement txtPassword;
	@FindBy(xpath = "//input[@id='confirmation']")
	WebElement txtCnfPassword;

	@FindBy(xpath = "//span[contains(text(),'Register')]")
	WebElement btnRegister;
	@FindBy(xpath = "//span[normalize-space()='Thank you for registering with Main Website Store.']")
	WebElement cnfMessage;

	public void setFirstName(String fname) {
		txtFirstname.sendKeys(fname);

	}

	public void setMiddleName(String mname) {
		txtMiddlename.sendKeys(mname);

	}

	public void setLastName(String lname) {
		txtLastname.sendKeys(lname);

	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);

	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);

	}

	public void setConfirmPassword(String pwd) {
		txtCnfPassword.sendKeys(pwd);

	}

	public void clickRegister() {
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		mywait.until(ExpectedConditions.elementToBeClickable(btnRegister)).click();

	}

	public String getConfirmMessage() {
		try {
			return cnfMessage.getText();
		} catch (Exception e) {
			return (e.getMessage());

		}

	}

}
