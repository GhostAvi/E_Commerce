package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObject.AccountRegistrationPage;
import pageObject.CheckoutPage;
import pageObject.HomePage;
import pageObject.MyAccountPage;
import pageObject.SearchPage;
import pageObject.ShoppingCartPage;
import pageObject.LoginPage;
import testBase.BaseClass;

public class TC_006_EndToEndTest extends BaseClass {
	@Test(groups = { "master" })
	public void endToendTest() throws InterruptedException {

		SoftAssert myassert = new SoftAssert();
		// Account Registration
		System.out.println("Account Registration................");

		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		AccountRegistrationPage ac = new AccountRegistrationPage(driver);
		ac.setFirstName(randomeString().toUpperCase());
		ac.setMiddleName(randomeString().toUpperCase());
		ac.setLastName(randomeString().toUpperCase());
		String email = randomeString() + "@gmail.com";
		ac.setEmail(email);
		//String password = randomAlphaNumeric();
		ac.setPassword("test123");
		ac.setConfirmPassword("test123");
		ac.clickRegister();
		String cnfmsg = ac.getConfirmMessage();
		myassert.assertEquals(cnfmsg, "Thank you for registering with Main Website Store.");
		MyAccountPage mc = new MyAccountPage(driver);
		mc.clickLogout();
		System.out.println("Login to application...............");
		hp.clickMyAccount();
		hp.clickLogin();

		LoginPage lp = new LoginPage(driver);
		lp.setEmailAddress(email);
		lp.setPassword("test123");
		lp.clickLogin();
		System.out.println("Going to My Account Page? " + mc.isMyAccountPageExists());
		myassert.assertEquals(mc.isMyAccountPageExists(), true);
		// search & add product to cart
		System.out.println("search & add product to cart...............");
		hp.EntertxttoSearch(p.getProperty("searchProductName"));
		hp.clickSearch();

		SearchPage sp = new SearchPage(driver);

		if (sp.isProductExist(p.getProperty("searchProductName"))) {
			sp.selectProduct(p.getProperty("searchProductName"));
			sp.addtocart();
		}
		System.out.println("Added product to cart ? " + sp.checkConfMsg());
		myassert.assertEquals(sp.checkConfMsg(), true);
		// Shopping cart
		System.out.println("Shopping cart...............");
		ShoppingCartPage sc = new ShoppingCartPage(driver);
		sc.enterQuantity(p.getProperty("Quantity"));
		sc.clickupdate();
		sc.selectCountry(p.getProperty("Country"));
		sc.enterPostcode(p.getProperty("post"));
		System.out.println(sc.getTotalPrice());
		sc.clickToCheckout();

		// CheckOutPage
		System.out.println("CheckOut and Place Order....................");
		CheckoutPage ck = new CheckoutPage(driver);
		ck.setaddress("Address");
		ck.setcity("Pune");
		ck.selectState();
		ck.setpin("441911");
		ck.selectCountry("India");
		ck.setPhone("9212345612");
		ck.clickcontinue();
		ck.clickPlaceorder();
		myassert.assertEquals(ck.confirmOrder(), true);
		System.out.println("Placed Order Successfully");
	}
}