package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.SearchPage;
import testBase.BaseClass;

public class TC_004_SearchProductTest extends BaseClass {

	@Test(groups= {"master"})
	public void verify_pruductSearch() throws InterruptedException {
		logger.info(" Starting TC_004_SearchProductTest ");

		try {
			
			HomePage hm=new HomePage(driver);
			
			//hm.enterProductName("iPhone");
			hm.EntertxttoSearch(p.getProperty("searchProductName"));
			
			hm.clickSearch();
			
			SearchPage sp=new SearchPage(driver);
			sp.isProductExist(p.getProperty("searchProductName"));

			Assert.assertEquals(sp.isProductExist(p.getProperty("searchProductName")),true);

		} catch (Exception e) {
			Assert.fail();
		}

		logger.info(" Finished TC_004_SearchProductTest ");

	}
}
