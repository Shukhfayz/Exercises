package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
 
public class AutoSuggest {
 

	@Test(description="Auto Suggest")
	public void selectValues() throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/maps");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"searchboxinput\"]")).sendKeys("Glen A");

		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='suggestions-grid']/div")));		

		List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"suggestions-grid\"]/div"));
		
		System.out.println("Auto Suggest List ::" + list.size());
		
		for(int i = 0; i< list.size();i++)
		{
			String actualText = list.get(i).getText();
			
			if(actualText.equals("Glen Arm MD"))
			{
				list.get(i).click();
				break;
			}
		}
	}
  }
	