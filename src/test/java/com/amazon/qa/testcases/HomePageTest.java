package com.amazon.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.CustServicesPage;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;

public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	CustServicesPage custsvpg;
	public HomePageTest() throws IOException {
		super();

	}

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initialization();
		loginpage = new LoginPage();
		custsvpg = new CustServicesPage();
		
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

	}
	

	@Test(priority = 1)
	public void ValidateTitle() {
		String title = homepage.ValidateHomePageTitle();
		Assert.assertEquals(title, "Amazon.ca: Low Prices – Fast Shipping – Millions of Items");
		System.out.println(title);

	}
	
	@Test(priority = 2)
	public void verifyUsernameTest() {
		Assert.assertTrue(homepage.varifyUsername());
	}
	
	@Test(priority = 3)
	public void verifyCustSrvPage() throws IOException {
		custsvpg = homepage.clickOnCustSrv();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
