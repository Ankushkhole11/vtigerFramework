package comcast.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {
	
	//initialization
		public CreateOrganizationPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//Declaration

		@FindBy(name="accountname")
		private WebElement OrgNameTextfield;
		
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement SaveButton;

		//getter methods

		public WebElement getOrgNameTextfield() {
			return OrgNameTextfield;
		}

		public WebElement getSaveButton() {
			return SaveButton;
		}
		
		//business
		/**
		 * this method is used to create organization
		 * @param OrgName
		 * @author ask97
		 */
		public void createNewOrganization(String OrgName)
		{
			OrgNameTextfield.sendKeys(OrgName);
			System.out.println(OrgName);
			SaveButton.click();
		}

	
		


}
