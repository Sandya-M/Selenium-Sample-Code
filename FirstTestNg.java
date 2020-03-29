package testcases;


import utils.Driver;
import utils.excelRead;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FirstTestNg {

		// TODO Auto-generated method stub
		// facebook login with 4 different values using getdata()
	
		@DataProvider
		public Object[][] getLogindata() throws Exception
		{
			return excelRead.getData("login");
		}
		
		@Test(dataProvider="getLogindata")
		public void fblogin(String data1, String data2, String title, String resultInd) throws Exception
		{
			String username = data1;
			String passwd = data2;
			
			WebDriver driver = Driver.getDriver();
	        driver.get("https://facebook.com/");
	       
	        // by browser link to xpath and css
	        driver.findElement(By.xpath("//*[@id='email']")).sendKeys(username);
	        driver.findElement(By.cssSelector("#pass")).sendKeys(passwd);
	        
	        // by customized xpath and css
	        
	        driver.findElement(By.id("loginbutton")).click();
	        Thread.sleep(5000);
	      //  driver.findElement(By.id("userNavigationLabel")).click();
	              
	        //System.out.println(driver.getTitle());
	      Assert.assertEquals(driver.getTitle(), title);
	
	      if (resultInd.equalsIgnoreCase("Yes")) {
	          WebElement e =  driver.findElement(By.xpath("//*[@id='u_0_c']/a"));
	          Assert.assertTrue( e.isEnabled());
	      }
		    
		} 
	     	
	    	        
}
