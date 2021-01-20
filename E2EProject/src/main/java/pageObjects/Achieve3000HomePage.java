package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Achieve3000HomePage {
	
public WebDriver driver;
	
	By menu=By.xpath("//*[@id='main-navbar']/div/div/div[6]/button");
	By menuItems = By.xpath("//div[@class='col-6 col-lg-2 order-1']/ul/li/a");
	By partnerLogos = By.xpath("//*[@id='fullpage']/div[2]/div[2]/div/div/a/img");
	By partnerHeaders= By.xpath("//*[@id='fullpage']/div[2]/div[2]/div/div[2]/a/*");
	By partnerTextDescriptions= By.xpath("//*[@id='fullpage']/div[2]/div[2]/div/div[2]/div/p");
	
	
	public Achieve3000HomePage(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement clickMenu()
	{
		return driver.findElement(menu);
	}
	public List<WebElement> getMenuItems(){
		return driver.findElements(menuItems);
	}
	public List<WebElement> getPartnerLogos(){
		return driver.findElements(partnerLogos);
	}
	public List<WebElement> getPartnerHeaders(){
		return driver.findElements(partnerHeaders);
	}
	public List<WebElement> getTextDescriptions(){
		return driver.findElements(partnerTextDescriptions);
	}
	
	
	

	
	
	

}
