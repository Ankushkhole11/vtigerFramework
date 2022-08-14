package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginToActi {

	public static void main(String[] args) throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		FileInputStream fis = new FileInputStream("./data/property.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		
		String Url = pobj.getProperty("url2");
		String browser = pobj.getProperty("browser");
		String username = pobj.getProperty("un2");
		String password = pobj.getProperty("pw2");
		
		WebDriver driver = new ChromeDriver();
		driver.get(Url);
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("pwd")).sendKeys(password);
		driver.findElement(By.id("loginButton")).click();
	

	}

}
