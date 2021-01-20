package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RShHomePage {
	
	public WebDriver driver;
	
	By login = By.xpath("/html/body/app-root/div/header/div[1]/div/div/div[2]/div[2]/a");	

	public RShHomePage(WebDriver driver) {
	
	this.driver=driver;
	
	}
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
	
	
	
	
}

