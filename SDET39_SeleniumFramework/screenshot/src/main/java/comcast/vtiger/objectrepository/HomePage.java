package comcast.vtiger.objectrepository;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.io.Files;

public class HomePage {
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//declaration
	@FindBy(linkText="Organizations")
	private WebElement OrganizationTab;
	
	@FindBy(linkText="Products")
	private WebElement productTab;
	
	@FindBy(xpath="//img[@src='themes/softed/images/Home.PNG']")
	private WebElement HomeTab;
	
	@FindBy(linkText="More")
	private WebElement MoreOption;
	
	@FindBy(name="Campaigns")
	private WebElement CampaignLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement Administrative;
	
	@FindBy(linkText="Sign Out")
	private WebElement SignOutLink;

	//getters
	public WebElement getOrganizationTab() {
		return OrganizationTab;
	}

	public WebElement getProductTab() {
		return productTab;
	}

	public WebElement getHomeTab() {
		return HomeTab;
	}

	public WebElement getMoreOption() {
		return MoreOption;
	}

	public WebElement getCampaignLink() {
		return CampaignLink;
	}
	
	public WebElement getAdministrative() {
		return Administrative;
	}

	public WebElement getSignOutLink() {
		return SignOutLink;
	}
	
	
	/**
	 * used for go to create organization page
	 * @author ask97
	 */
	public void goToOrganizationPage()
	{
		OrganizationTab.click();
	}
	
	/**
	 * used for go to create product page
	 * @author ask97
	 */
	public void goToProductPage()
	{
		productTab.click();
	}
	
	/**
	 * used for go to create campaign page
	 * @param driver
	 * @author ask97
	 */
	public void goToCampaignPage(WebDriver driver)
	{
		 Actions act = new Actions(driver);
		 act.moveToElement(MoreOption).perform();
		 CampaignLink.click();	
	}
	
	/**
	 * used for go to home page
	 * @author ask97
	 */
	public void goHome()
	{
		HomeTab.click();
	}
	
	/**
	 * used for sign out
	 * @author ask97
	 */
	public void signOut(WebDriver driver)
	{
		 Actions act = new Actions(driver);
		 act.moveToElement(Administrative).perform();
		 SignOutLink.click();
	}
	
	public void takesScreenshotAs(WebDriver driver, String name) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/"+name+".png");
		Files.copy(src, dest);
	}

	

}
