package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import comcast.vtiger.genericUtility.File_Utility;
import comcast.vtiger.genericUtility.Java_Utility;
import comcast.vtiger.genericUtility.WebDriver_Utility;
import comcast.vtiger.objectrepository.HomePage;
import comcast.vtiger.objectrepository.LoginPage;
import comcast.vtiger.objectrepository.OrganizationPage;

public class FetchDataFromOrgTable {

	public static void main(String[] args) throws Throwable {
		
		WebDriver_Utility wlib = new WebDriver_Utility();
		File_Utility plib = new File_Utility();
		Java_Utility jlib = new Java_Utility();
		
		wlib.setUp("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		String Url = plib.getPropertyKeyValue("url");
		String usernam = plib.getPropertyKeyValue("un");
		String passwor = plib.getPropertyKeyValue("pw");

		//login to vtiger
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(Url);
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(usernam, passwor);
		
		HomePage home = new HomePage(driver);
		home.goToOrganizationPage();
		
		OrganizationPage op = new OrganizationPage(driver);
		
		op.fetchDataUsingHTMLTable(driver, 2);
		driver.close();

	}

}
