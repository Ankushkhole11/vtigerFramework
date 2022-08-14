package comcast.vtiger.genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import comcast.vtiger.objectrepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver=null;
	public static WebDriver sDriver;
	File_Utility plib = new File_Utility();
	@BeforeSuite(groups= {"smokeTest","regressionTest"})
	public void BS()
	{
		System.out.println("Database connection");
	}
	
	@BeforeTest(groups= {"smokeTest","regressionTest"})
	public void BT()
	{
		System.out.println("Execute script in parallel mode");
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	public void BC() throws Throwable
	{
		String BROWSER = plib.getPropertyKeyValue("browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		}
		
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			  driver = new FirefoxDriver();
		}
		
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			  driver = new EdgeDriver();
		}
		
		else
		{
			ChromeDriver driver = new ChromeDriver();
		}
		sDriver=driver;
				
		System.out.println("Launching the browser");
	}
	
	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	public void BM() throws Throwable
	{
		System.out.println("Login to application");
		File_Utility plib = new File_Utility();
		String Url = plib.getPropertyKeyValue("url");
		String username = plib.getPropertyKeyValue("un");
		String password = plib.getPropertyKeyValue("pw");
		driver.get(Url);
		
		LoginPage lp = new LoginPage(driver);
		lp.login(username, password);

		
	}
	
	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void AM()
	{
//		HomePage home = new HomePage(driver);
//		home.signOut(driver);
		
		System.out.println("Logout from Application");
	}
	
	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void AC()
	{
//		driver.close();
		System.out.println("Close the browser");
	}
	
	@AfterTest
	public void AT()
	{
		System.out.println("Execute in parallel done");
	}
	
	@AfterSuite
	public void As()
	{
		System.out.println("database connection close");
	}
	

}
