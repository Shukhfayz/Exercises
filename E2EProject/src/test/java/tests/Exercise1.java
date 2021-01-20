package tests;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Achieve3000HomePage;
import resources.base;

public class Exercise1 extends base{
	
	public static Logger log =LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("ClientURL"));
		log.info("Navigated to Home page");
		driver.manage().window().maximize();
		getScreenshot("HomePage");
	}
	
	@Test
	public void validateHomePage() throws Exception {
		Achieve3000HomePage aHome=new Achieve3000HomePage(driver);
		aHome.clickMenu().click();
		getScreenshot("Menu");
		List<WebElement> menuItems=aHome.getMenuItems();
		for(int i=0; i<menuItems.size();i++) {
			if(menuItems.get(i).getText().equals("Our Partners")) {
			WebElement ourPartners=menuItems.get(i);
			ourPartners.click();
			log.info("Landed on Our Partners page");
			getScreenshot("OurPartners");
			break;
			}
		}
		
		List<WebElement> partnerLogos=aHome.getPartnerLogos();
		for(int i=0; i<partnerLogos.size();i++) {
			if(partnerLogos.get(i).isDisplayed()) {
				log.info("Logo is displayed");
				System.out.println("Logo of partner "+(i+1)+" is displayed");
			}else {
				log.info("Logo is not displayed");
				System.out.println("Logo of partner "+(i+1)+" is not displayed");
			}
		}
		
		List<WebElement> partnerHeaders=aHome.getPartnerHeaders();
		for(int i=0; i<partnerHeaders.size();i++) {
			if(partnerHeaders.get(i).isDisplayed()) {
				log.info("Header is displayed");
				System.out.println("Header of partner "+(i+1)+" is displayed");
			}else {
				log.info("Header is not displayed");
				System.out.println("Header of partner "+(i+1)+" is not displayed");
			}
		}
	
		List<WebElement> partnerTextDescriptions=aHome.getTextDescriptions();
		for(int i=0; i<partnerTextDescriptions.size();i++) {
			if(partnerTextDescriptions.get(i).isDisplayed()) {
				log.info("TextDescription is displayed");
				System.out.println("Text description "+(i+1)+" is displayed");
			}else {
				log.info("Text description is not displayed");
				System.out.println("Text description "+(i+1)+" is not displayed");
			}
		}
	}
	
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver.quit();	
	}
	
	

}
