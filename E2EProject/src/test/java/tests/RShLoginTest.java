package tests;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.RShHomePage;
import pageObjects.RShLoginPage;
import resources.base;
import util.ExcelReader;

public class RShLoginTest extends base {
	
		public static Logger log =LogManager.getLogger(base.class.getName());
		@BeforeTest
		public void initialize() throws IOException
		{
			 driver =initializeDriver();
			 log.info("Driver is initialized");	
			 driver.get(prop.getProperty("RShURL"));
			 log.info("Navigated to Home page");
		}

		@Test
		public static void Login () throws IOException, InterruptedException {
			
			RShHomePage rsh= new RShHomePage(driver);
			rsh.getLogin().click();
			ExcelReader reader = new ExcelReader(null);
			ArrayList<String> data = reader.getCellData("TestCases","Login");
					//("TestCases","Login");
			RShLoginPage rsl = new RShLoginPage(driver);
			rsl.getEmail().sendKeys(data.get(1));
			rsl.getPassword().sendKeys(data.get(2));
			rsl.getLogin().click();	

		}
		
		@AfterTest
		public void teardown()
		{
			
			driver.close();
			driver.quit();
			
		}
}
