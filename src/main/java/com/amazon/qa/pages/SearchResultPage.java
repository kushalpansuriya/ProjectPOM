package com.amazon.qa.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class SearchResultPage extends TestBase {

	public SearchResultPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchbar;
	
	@FindBy(xpath="//div[@class='left-pane-results-container']/div")
	WebElement searchbarlist;
	
	public List<String> newSearch(String item) throws InterruptedException {
		searchbar.sendKeys(item);
	    Thread.sleep(2000);
	    
		List<WebElement> AllItems = driver.findElements(By.xpath("//div[@class='left-pane-results-container']/div"));
		
		List<String> texts = new ArrayList<>();
        for (WebElement AllItem : AllItems) {
            texts.add(AllItem.getText());
        }
        return texts;
	}
}
