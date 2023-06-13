package com.amazon.qa.testcases;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.CustServicesPage;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;
import com.amazon.qa.pages.SearchResultPage;
import com.amazon.qa.util.TestUtil;
import com.amazon.qa.util.Xls_Reader;

public class SearchResultTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	CustServicesPage custsvpg;
	SearchResultPage searchpage;
	TestUtil tstUtil;
	Xls_Reader xlsR;
	public SearchResultTest() throws IOException {
		super();

	}

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initialization();
		loginpage = new LoginPage();
		custsvpg = new CustServicesPage();
		searchpage = new SearchResultPage();
		tstUtil = new TestUtil();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	@Test(priority = 1)
	public void ValidateTitle() {
		String title = homepage.ValidateHomePageTitle();
		Assert.assertEquals(title, "Amazon.ca: Low Prices – Fast Shipping – Millions of Items");
		System.out.println(title);
	}
		
	@DataProvider
	public Object[][] getxlsData() {
	Object[][] data1 = tstUtil.getTestData("sheet1");
	return data1;
	}
	
	@Test(priority = 2, dataProvider = "getxlsData")
	private void newItemSearch(String item) throws InterruptedException {
		List<String> allitems = searchpage.newSearch(item);
        System.out.println(allitems);
	}
	
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
