package com.amazon.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(id = "nav-link-accountList-nav-line-1")
	WebElement usernamelable;

	@FindBy(xpath = "//span[@class='nav-line-2']/div[1]")
	WebElement defLangauge;

	@FindBy(linkText = "Account & Lists")
	WebElement myAcc;

	@FindBy(linkText = "Customer Service")
	WebElement custSrvPg;

	@FindBy(xpath = "//a[contains(text(),'New Releases')]")
	WebElement newrlsPg;

	public HomePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	public String ValidateHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean varifyUsername() {
		return usernamelable.isDisplayed();
	}

	public MyAccountPage clickOnMyAcc() throws IOException {
		myAcc.click();
		return new MyAccountPage();
	}

	public CustServicesPage clickOnCustSrv() throws IOException {
		custSrvPg.click();
		return new CustServicesPage();
	}

	public NewRealisePage clickOnNew() throws IOException {
		newrlsPg.click();
		return new NewRealisePage();
	}
}
