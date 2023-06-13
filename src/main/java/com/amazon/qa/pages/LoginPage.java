package com.amazon.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class LoginPage extends TestBase {

	
//object repo
	@FindBy(name = "email")
	WebElement username;
	
	@FindBy(id = "ap_password")
	WebElement password;
	
	@FindBy(id = "continue")
	WebElement SubmitBtn1;
	
	@FindBy(id = "signInSubmit")
	WebElement signbtn;
	
	@FindBy(id = "createAccountSubmit")
	WebElement SignUpBtn;
	
	@FindBy(xpath = "//i[@class='a-icon a-icon-logo']")
	WebElement amzlogo;
	
	
	
	
	//Initialization of the page objects
	public LoginPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		
	}
	//Actions on login page
	public String ValidateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean ValidateAMZinage() {
		return amzlogo.isDisplayed();
	}
	
	public HomePage login(String un, String pass) throws IOException, InterruptedException {
		username.sendKeys(un);
		SubmitBtn1.click();
		password.sendKeys(pass);
		signbtn.click();
		
		return new HomePage();
		
		
		
	}

}