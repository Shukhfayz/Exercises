package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RShLoginPage {

	public WebDriver driver;
	
	By email=By.xpath("//*[@id='user_email']");
	By password=By.xpath("//*[@id='user_password']");
	By login=By.xpath("//*[@id='new_user']/div[4]/input");
	
	


	public RShLoginPage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	
	this.driver=driver;
	
	}

	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
}