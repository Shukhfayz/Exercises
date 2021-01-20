package util;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.base;

public class SeleniumUtils {
	
	WebDriver driver=new ChromeDriver();
	public void takeScreenshot(String pathname) throws IOException {
	    File src = ((TakesScreenshot) base.driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(src, new File(pathname));
	}
	
	public void waitUntilVisibility(String xpath) {
		WebDriverWait wait = new WebDriverWait(base.driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	
	public boolean isObjectPresentByXpath(String xpath) {
		 try {
		        driver.findElement(By.id(xpath));
		    } catch (NoSuchElementException e) {
		        return false;
		    }
		    return true;
	}
}