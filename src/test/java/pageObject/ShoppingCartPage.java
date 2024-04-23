package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ShoppingCartPage extends BasePage {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@title='Qty']")
	WebElement txtquantity;

	@FindBy(xpath = "//button[@title='Update']")
	WebElement btnupdate;

	@FindBy(xpath = "//select[@id='country']")
	WebElement dropdowncntry;

	@FindBy(id = "postcode")
	WebElement postcode;
	@FindBy(xpath = "//strong//span[@class='price']")
	WebElement totaprice;
	@FindBy(xpath="//button[@title='Proceed to Checkout']")
	WebElement btnCheckout;

	public void enterQuantity(String qty) {
		txtquantity.clear();
		txtquantity.sendKeys(qty);

	}

	public void clickupdate() {
		btnupdate.click();

	}

	public void selectCountry(String country) {
		Select drp = new Select(dropdowncntry);
		drp.selectByVisibleText(country);

	}

	public void enterPostcode(String Postcode) {
		postcode.sendKeys(Postcode);

	}
	public String getTotalPrice()
	{
		return totaprice.getText();
	}
	public void clickToCheckout() {
		btnCheckout.click();

	}

}
