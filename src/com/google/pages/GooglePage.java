package com.google.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class GooglePage {
	  
    private WebDriver driver;

	public GooglePage(WebDriver driver) {
        this.driver = driver;     
    } 
	
	By searchBox = By.name("q");
    By searchButton = By.name("btnK");
  
    //Verify 
    public void verifyHomePageTitle() {
	    Assert.assertTrue(driver.getTitle().contains("Google"), "Home Page Title does not match");
	}
    
  //Enter Search value
    public void setSearchValue(String searchParam){
        driver.findElement(searchBox).sendKeys(searchParam);
    }
    
    //Click Search Button
    public void clickSearchButton(){
    	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(searchButton).click();
    }
    
	//Enter search value by mouse and keyboard
	public void setSearchVlaueByMouseActions(String searchParam) {
		Actions builder = new Actions(driver);
    	Action seriesOfActions = builder
    		.moveToElement(driver.findElement(searchBox))
    		.click()
    		.sendKeys(driver.findElement(searchBox),searchParam)
    		.build();
    	
    	seriesOfActions.perform();
		
	}

    }

