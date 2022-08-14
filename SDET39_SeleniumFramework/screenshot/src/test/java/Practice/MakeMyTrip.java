package Practice;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import comcast.vtiger.genericUtility.WebDriver_Utility;

public class MakeMyTrip {
	
	public static void main(String[] args) throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/flights");
		Thread.sleep(4000);
		
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.moveByOffset(driver, 10, 10);
//		driver.findElement(By.xpath("//span[text()='Flights']")).click();
		Thread.sleep(2000);
		WebElement src = driver.findElement(By.xpath("//input[@id='fromCity']"));
		WebElement dest = driver.findElement(By.xpath("//input[@id='toCity']"));
		
		src.sendKeys("Bangkok");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//p[text()='Bangkok, Thailand'][1]")).click();
//		Robot r = new Robot();
//		r.keyPress(KeyEvent.VK_ENTER);
//		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		
		dest.sendKeys("mumbai");
		driver.findElement(By.xpath("//p[text()='Mumbai, India'][1]")).click();
		Thread.sleep(3000);
		
		//navigate to departure
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		String reqdMonth="November";
		String reqdYear="2022";
		String reqdDate="29";
		
		String currentMonthYear=driver.findElement(By.xpath("//div[@class='DayPicker-Caption']/div")).getText();
		String currentMonth=currentMonthYear.split(" ")[0];
		String currentYear=currentMonthYear.split(" ")[1];
		
		//!(Aug=nov && 22=22)          !(nov=nov && 22=22)
		while(!(currentMonth.equalsIgnoreCase(reqdMonth) && currentYear.equals(reqdYear)))
		{
			driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
			currentMonthYear=driver.findElement(By.xpath("//div[@class='DayPicker-Caption']/div")).getText();
			currentMonth=currentMonthYear.split(" ")[0];
			currentYear=currentMonthYear.split(" ")[1];
		}
		driver.findElement(By.xpath("//p[.='"+reqdDate+"']")).click();
		
		

		
	}


}
