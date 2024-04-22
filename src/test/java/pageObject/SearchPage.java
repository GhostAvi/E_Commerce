package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

	public SearchPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[@class='product-image']")
	List<WebElement> searchProducts;
	@FindBy(xpath = "//button[@title='Add to Cart']")
	WebElement addtocart;
	@FindBy(xpath = "//span[normalize-space()='IPhone was added to your shopping cart.']")
	WebElement cnfmsg;

	public boolean isProductExist(String productName) {
		boolean flag = false;
		for (WebElement product : searchProducts) {
			if (product.getAttribute("title").equalsIgnoreCase(productName)) {

				flag = true;
				break;
			}
		}

		return flag;

	}

	public void selectProduct(String productName) {
		for (WebElement product : searchProducts) {
			if (product.getAttribute("title").equals(productName)) {
				product.click();
			}
		}

	}

	public void addtocart() {
		addtocart.click();
	}
	public boolean checkConfMsg()
	{
		try
		{
		return cnfmsg.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
}
