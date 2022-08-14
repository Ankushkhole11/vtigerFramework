package comcast.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CampaignPage {
	
	public CampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="search_text")
	private WebElement SearchCampaignTextfield;
	
	@FindBy(id="bas_searchfield")
	private WebElement CampaignDropdown;
	
	@FindBy(name="submit")
	private WebElement SubmitButton;

	@FindBy(xpath="//img[@alt='Create Campaign...']")
	private WebElement createNewCampaignLogo;
	

	public WebElement getSearchCampaignTextfield() {
		return SearchCampaignTextfield;
	}

	public WebElement getCampaignDropdown() {
		return CampaignDropdown;
	}

	public WebElement getSubmitButton() {
		return SubmitButton;
	}
	
	public WebElement getCreateNewCampaignLogo() {
		return createNewCampaignLogo;
	}

	
	/**
	 * used to select product category dropdown
	 * @param VisibleText
	 * @author ask97
	 */
	public void selectCategoryForCampaign(String VisibleText)
	{
		Select sel = new Select(CampaignDropdown);
		sel.selectByVisibleText(VisibleText);
	}
	
	/**
	 * This method is used for search for a Organization with Category
	 * @param productName
	 * @param VisibleText
	 * @author ask97
	 */
	public void searchOrganization(String CampaignName, String VisibleText)
	{
		SearchCampaignTextfield.sendKeys(CampaignName);
		selectCategoryForCampaign(VisibleText);
		SubmitButton.click();
	}
	
	/**
	 * used to create Campaign 
	 * @author ask97
	 */
	public void createNewCampaignPage()
	{
		createNewCampaignLogo.click();
	}

	
}
