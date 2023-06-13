package com.amazon.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class CustServicesPage extends TestBase {

	

	@FindBy(xpath = "//h1[@class='fs-heading bolded']")
	WebElement CustPageLable;
	
	@FindBy(linkText = "Digital Services and Device Support")
	WebElement DigiService ;
	
	
	public CustServicesPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyname() {
		return CustPageLable.isDisplayed();
	}
 
	public boolean verifypage() {
		return DigiService.isDisplayed();
	}
 
}
