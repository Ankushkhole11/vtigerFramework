package comcast.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {

	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="productname")
	private WebElement ProductNameTextfield;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveButton;

	//getters
	public WebElement getProductNameTextfield() {
		return ProductNameTextfield;
	}

	public WebElement getSaveButton() {
		return SaveButton;
	}
	
	//Business logics
	/**
	 * this method is used for creating New Product
	 * @param productName
	 * @author ask97
	 */
	public void createNewProduct(String productName)
	{
		ProductNameTextfield.sendKeys(productName);
		System.out.println(productName);
		SaveButton.click();
	}

}
