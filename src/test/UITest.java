package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.google.pages.*;

import common.Utility.Common;


public class UITest {
 WebDriver driver;
 GooglePage googlePageObj;
 SearchResultPage searchPageObj;
 String searchParam = "888";
 
 
 @BeforeTest
 	public void setup() {
	 System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
	 driver = new ChromeDriver();	 
 }
 
 	@BeforeMethod
 		public void browserURL() {
 		driver.get(new Common().getURL());	 
 	}
 
 	//Scenario to perform google search by Sendkeys
    @Test
    public void GoogleSearch_TC1() {
    	
    	//Perform Search on Google Home Page
    	googlePageObj = new GooglePage(driver);
        googlePageObj.verifyHomePageTitle();
        googlePageObj.setSearchValue(searchParam);
        googlePageObj.clickSearchButton();
        
        //Validate the results displayed on Search Page
        searchPageObj = new SearchResultPage(driver);
        searchPageObj.VerifySearchPageTitle();
        Assert.assertEquals(searchPageObj.searchResults(searchParam), true);
    }
    
    //Scenario to perform google search by Keyboard events
    @Test
    public void GoogleSearch_TC2() {
    	
    	//Perform Search on Google Home Page
    	 googlePageObj = new GooglePage(driver);
         googlePageObj.verifyHomePageTitle(); 
         googlePageObj.setSearchVlaueByMouseActions(searchParam);
         googlePageObj.clickSearchButton();
         
         //Validate the results displayed on Search Page
         searchPageObj = new SearchResultPage(driver);
         searchPageObj.VerifySearchPageTitle();
         Assert.assertEquals(searchPageObj.searchResults(searchParam), true);
   }
   
    @AfterTest
    public void tearDown() {
      driver.close();	
      driver.quit();
    }
}