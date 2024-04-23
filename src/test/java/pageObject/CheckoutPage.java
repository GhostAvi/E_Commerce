package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@title='Street Address']")
	WebElement txtAddress;
	@FindBy(xpath = "//input[@title='City']")
	WebElement txtcity;
	@FindBy(xpath = "//select[@title='State/Province']")
	WebElement selectstate;
	@FindBy(xpath = "//input[@title='Zip']")
	WebElement txtzip;
	@FindBy(xpath = "//select[@title='Country']")
	WebElement selectCountry;
	@FindBy(xpath = "//input[@id='billing:telephone']")
	WebElement txtphoneno;
	@FindBy(xpath = "//button[@onclick='billing.save()']")
	WebElement continue1;
	@FindBy(xpath = "//button[@onclick='shippingMethod.save()']")
	WebElement continue2;
	@FindBy(xpath = "//input[@id='p_method_checkmo']")
	WebElement chechboxpaymentoption;
	@FindBy(xpath = "//button[@onclick='payment.save()']")
	WebElement continue3;
	@FindBy(xpath = "//button[@title='Place Order']")
	WebElement btnplaceorder;
	
	@FindBy(css="div[class='page-title'] h1")
	WebElement cnfplaceorder;

	public void setaddress(String address1) {
		txtAddress.sendKeys(address1);
	}

	public void setcity(String city) {
		txtcity.sendKeys(city);
	}

	public void selectState() {
		Select dropdown = new Select(selectstate);
		dropdown.selectByIndex(1);
	}

	public void setpin(String zip) {
		txtzip.sendKeys(zip);
	}

	public void selectCountry(String Country) {
		Select dropdown = new Select(selectCountry);
		dropdown.selectByVisibleText(Country);
	}
	
	public void setPhone(String telehone) {
		txtphoneno.sendKeys(telehone);
	}

	public void clickcontinue() {
		continue1.click();
		continue2.click();
		chechboxpaymentoption.click();
		continue3.click();
		
	}
	public void clickPlaceorder() {
		btnplaceorder.click();
		
	}
	public boolean confirmOrder() {
		
	boolean status = cnfplaceorder.isDisplayed();
	return status;
	
	}
	
}
