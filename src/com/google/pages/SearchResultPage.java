package com.google.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SearchResultPage {
	private WebDriver driver;

	public SearchResultPage(WebDriver driver) {
        this.driver = driver;  
    } 

	public void VerifySearchPageTitle() {
	    Assert.assertTrue(driver.getTitle().contains("- Google Search"), "Search Page Title does not match");
	}
	
	//Search Results
    public boolean searchResults(String searchParam){
    	List<WebElement> elem = driver.findElements(By.xpath("//*[@id='center_col']//*[contains(text(),'"+searchParam+"')]"));
        if(elem.isEmpty())
        	return false;
        else if(elem.size()>1)
          	return true;
        else return false;
    }


}
