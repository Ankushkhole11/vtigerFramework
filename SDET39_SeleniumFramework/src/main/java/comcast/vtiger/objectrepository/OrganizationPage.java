package comcast.vtiger.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrganizationPage {
	
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Organizations")
	private WebElement OrganizationTab;
	
	@FindBy(name="search_text")
	private WebElement SearchTextfield;
	
	@FindBy(id="bas_searchfield")
	private WebElement OrgCategoryDropdown;
	
	@FindBy(name="submit")
	private WebElement searchButton;
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement newOrganizationImage;

	public WebElement getNewOrganizationLogo() {
		return newOrganizationImage;
	}

	public WebElement getOrganizationTab() {
		return OrganizationTab;
	}

	public WebElement getSearchTextfield() {
		return SearchTextfield;
	}

	public WebElement getOrgCategoryDropdown() {
		return OrgCategoryDropdown;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}
	
	/**
	 * used for selecting a category dropdown
	 * @param VisibleText
	 * @author ask97
	 */
	public void selectCategoryForOrganization(String VisibleText)
	{
		Select sel = new Select(OrgCategoryDropdown);
		sel.selectByVisibleText(VisibleText);
	}
	
	/**
	 * This method is used for search for a Organization with Category
	 * @param OrgName
	 * @param VisibleText
	 * @author ask97
	 */
	public void searchForganization(String OrgName, String VisibleText)
	{
		SearchTextfield.sendKeys(OrgName);
		selectCategoryForOrganization(VisibleText);
		searchButton.click();
	}
	
	/**
	 * used to create product 
	 * @author ask97
	 */
	public void clickOnCreateOrganization()
	{
		newOrganizationImage.click();
	}
	
	/**
	 * used to fetch data 
	 */
	public void fetchDataUsingHTMLTable(WebDriver driver, int rowNo)
	{
		if(rowNo>=2)
		{
			String orgNam = driver.findElement(By.xpath("//*[@id=\"row_"+rowNo+"\"]/td[3]")).getText();
			System.out.println(orgNam);
		}
		
		
	}
	

}
