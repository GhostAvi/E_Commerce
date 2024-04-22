package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement MyAcccountHeading;
	@FindBy(xpath = "//span[@class='label'][normalize-space()='Account']")
	WebElement btnMyAccount;
	@FindBy(css = "a[title='Log Out']")
	WebElement btnLogOut;

	public boolean isMyAccountPageExists() // MyAccount Page heading display status
	{
		try {
			return (MyAcccountHeading.isDisplayed());
		} catch (Exception e) {
			return (false);
		}
	}

	public void clickLogout() {
		btnMyAccount.click();
		btnLogOut.click();

	}
}
