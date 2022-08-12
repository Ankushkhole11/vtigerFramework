package comcast.vtiger.genericUtility;

import java.time.Duration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriver_Utility {
	/**
	 * wait for page to load before identifying any synchronized element in DOM
	 * @param driver
	 * @author Ankush
	 */
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}

	/**
	 * after every action it will for next action to perform
	 * @param driver
	 * @author Ankush
	 */
	public void scriptTimeOut(WebDriver driver)
	{
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
	}

	/**\
	 * used to wait for element to be clickable in GUI and check for specific element for every 500ms
	 * @param driver
	 * @param element
	 * @param pollingTime
	 * @author Ankush
	 */
	public void waitForElementWithCustomTimeOut(WebDriver driver, WebElement element, int pollingTime)
	{
		FluentWait wait = new FluentWait(driver);
		//wait.withTimeout(20, TimeUnit.SECONDS);
		wait.pollingEvery(pollingTime, TimeUnit.SECONDS);
		//wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * used to wait for element to be clickable in GUI and check for specific element for every 500ms
	 * @param driver
	 * @param element
	 * @author Ankush
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * used to switch to any window based on window title
	 * @param driver
	 * @param PartialWindowTitle
	 * @author Ankush
	 */
	public void switchToWindow(WebDriver driver, String PartialWindowTitle)
	{
		Set<String> allId = driver.getWindowHandles();
		Iterator<String> it = allId.iterator();
		while(it.hasNext())
		{
			String wid = it.next();
			driver.switchTo().window(wid);
			if(driver.getTitle().contains(PartialWindowTitle))
			{
				break;
			}
		}

	}
	
	/**
	 * used to switch AlertWindow and accept it
	 * @param driver
	 * @author Ankush
	 */
	public void switchToAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * used to switch AlertWindow and dismiss it
	 * @param driver
	 * @author Ankush
	 */
	public void switchToAlertAndDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();	
	}
	
	/**
	 * used to switch to frame window based on index
	 * @param driver
	 * @param
	 * @author Ankush
	 */
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * used to switch to frame window based on nameOrId
	 * @param driver
	 * @param nameOrId
	 * @author Ankush
	 */
	public void switchToFrame(WebDriver driver, String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	
	/**
	 * used to switch to frame window based on WebElement ele
	 * @param driver
	 * @param element
	 * @author Ankush
	 */
	public void switchToFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	/**
	 * used to select the value from the DropDown based on index
	 * @param element
	 * @param index
	 * @author Ankush
	 */
	public void select(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * used to select the value from the DropDown based on value
	 * @param element
	 * @param index
	 * @author Ankush
	 */
	public void select(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	
	/**
	 * used to select the value from the DropDown based on value
	 * @param element
	 * @param index
	 * @author Ankush
	 */
	public void selectByVisibleText(WebElement element, String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	/**
	 * used to place mouse cursor on specific element
	 * @param driver
	 * @param element
	 * @author Ankush
	 */
	public void mouseOverOnElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * used to right click on specific element
	 * @param driver
	 * @param element
	 * @author Ankush
	 */
	public void rightClickOnElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * 
	 */
	public void setUp(String key , String value)
	{
		System.setProperty(key, value);
	}
	
	/**
	 * used to scroll down
	 * @param driver
	 * @param pixels
	 * @author Ankush
	 */
	public void scrollDown(WebDriver driver,int Yaxis)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,"+Yaxis+")");
	}
	
	/**
	 * used to scroll up
	 * @param driver
	 * @param pixels
	 * @author Ankush
	 */
	public void scrollUp(WebDriver driver,int Yaxis)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,"+Yaxis+")");
	}
	
	/**
	 * used to scroll right
	 * @param driver
	 * @param pixels
	 * @author Ankush
	 */
	public void scrollRight(WebDriver driver,int Xaxis)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy("+Xaxis+",0)");
	}
	
	/**
	 * used to scroll right
	 * @param driver
	 * @param pixels
	 * @author Ankush
	 */
	public void scrollLeft(WebDriver driver,int Xaxis)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy("+Xaxis+",0)");
	}
	
	/**
	 * 
	 */
	public void moveByOffset(WebDriver driver, int xaxis, int yaxis)
	{
		Actions act=new Actions(driver);
		act.moveByOffset(xaxis, yaxis);
	}
}
