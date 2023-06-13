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

public class CustServicesTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	CustServicesPage custsvpg;

	public CustServicesTest() throws IOException {
		super();

	}

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initialization();
		loginpage = new LoginPage();
		custsvpg = new CustServicesPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		custsvpg = homepage.clickOnCustSrv();
	}
	@Test(priority = 1)
	public void verifyCustLabel() {
		Assert.assertTrue(custsvpg.verifyname(), "Customer Service name is missing");
	}
	
	@Test(priority = 2)
	public void verifyCustpgName() {
		Assert.assertTrue(custsvpg.verifypage());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
