package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	@Test(groups= {"regression","master"})
	public void verify_account_registration() {
		logger.info("**** starting TC_001_AccountRegistrationTest  *****");

		logger.debug("application logs started......");

		try {

			HomePage hp = new HomePage(driver);

			logger.info("Clicked on MyAccount link");

			hp.clickMyAccount();

			logger.info("Clicked on Register link");

			hp.clickRegister();

			logger.info("Entering customer details.. ");

			AccountRegistrationPage ac = new AccountRegistrationPage(driver);
			ac.setFirstName(randomeString().toUpperCase());
			ac.setMiddleName(randomeString().toUpperCase());
			ac.setLastName(randomeString().toUpperCase());
			ac.setEmail(randomeString() + "@gmail.com");
			String password = randomAlphaNumeric();
			ac.setPassword(password);
			ac.setConfirmPassword(password);
			ac.clickRegister();

			logger.info("Validating expected message..");

			String cnfmsg = ac.getConfirmMessage();

			Assert.assertEquals(cnfmsg, "Thank you for registering with Main Website Store.");
		} catch (Exception e) {
			logger.error("test failed..");
			Assert.fail("An exception occurred: " + e.getMessage());
		}

		logger.debug("application logs end.......");
		logger.info("**** finished TC_001_AccountRegistrationTest  *****");

	}

}
