package AK;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import comcast.vtiger.genericUtility.File_Utility;
import comcast.vtiger.genericUtility.Java_Utility;
import comcast.vtiger.genericUtility.WebDriver_Utility;

public class google {

	public static void main(String[] args) throws Throwable {
		WebDriver_Utility wlib = new WebDriver_Utility();
		File_Utility plib = new File_Utility();
		Java_Utility jlib = new Java_Utility();
		
		wlib.setUp("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		wlib.waitForPageToLoad(driver);
		driver.get("https:www.google.com");
		driver.findElement(By.name("q")).sendKeys("java");
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);

		wlib.scrollDown(driver, 1000);
		Thread.sleep(2000);
		driver.close();
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(300,400)");
		
		

	}

}
