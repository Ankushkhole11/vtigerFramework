package comcast.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductValidationPage {
	
	public ProductValidationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="span.lvtHeaderText")
	private WebElement ActualProductData;
	
	@FindBy(css="span.dvHeaderText")
	private WebElement ActualCampaignData;
	
	@FindBy(css="span.dvHeaderText")
	private WebElement ActualOrganizationData;

	public WebElement getActualProductData() {
		return ActualProductData;
	}

	public WebElement getActualCampaignData() {
		return ActualCampaignData;
	}

	public WebElement getActualOrganizationData() {
		return ActualOrganizationData;
	}
	
	public String actualProductName() {
		return ActualProductData.getText();
	}
	
	public String actualCampaignName()
	{
		return ActualCampaignData.getText();
	}
	
	public String actualOrganizationName()
	{
		return ActualOrganizationData.getText();
	}
	
	

	

}
