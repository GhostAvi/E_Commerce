package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[@class='label'][normalize-space()='Account']")
	WebElement lnMyAccount;
	@FindBy(xpath = "//a[@title='Register']")
	WebElement lnRegister;
	@FindBy(xpath = "//a[normalize-space()='Log In']")
	WebElement loginbtn;
	@FindBy(xpath = "//input[@id='search']")
	WebElement txtsearch;
	@FindBy(xpath = "//button[@title='Search']")
	WebElement btnsearch;

	public void clickMyAccount() {
		lnMyAccount.click();
	}

	public void clickRegister() {
		lnRegister.click();
	}

	public void clickLogin() {
		loginbtn.click();
	}

	public void EntertxttoSearch(String txt) {
		txtsearch.sendKeys(txt);
	}

	public void clickSearch() {
		btnsearch.click();
	}

}
