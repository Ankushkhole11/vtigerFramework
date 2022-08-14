
package comcast.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {
	
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="search_text")
	private WebElement SearchProductTextfield;
	
	@FindBy(id="bas_searchfield")
	private WebElement ProductDropdown;
	
	@FindBy(name="submit")
	private WebElement SubmitButton;
	
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement CreateProductlogo;

	public WebElement getSearchProductTextfield() {
		return SearchProductTextfield;
	}

	public WebElement getCreateProductLogo() {
		return CreateProductlogo;
	}

	public WebElement SearchProductTextfield() {
		return SearchProductTextfield;
	}

	public WebElement getProductDropdown() {
		return ProductDropdown;
	}

	public WebElement getSubmitButton() {
		return SubmitButton;
	}
	
	/**
	 * used to select product category dropdown
	 * @param VisibleText
	 * @author ask97
	 */
	public void selectCategoryForProduct(String VisibleText)
	{
		Select sel = new Select(ProductDropdown);
		sel.selectByVisibleText(VisibleText);
	}
	
	/**
	 * This method is used for search for a Organization with Category
	 * @param productName
	 * @param VisibleText
	 * @author ask97
	 */
	public void searchProduct(String VisibleText, String productName)
	{
		selectCategoryForProduct(VisibleText);
		SearchProductTextfield.sendKeys(productName);
		SubmitButton.click();
	}
	
	/**
	 * used to create product 
	 * @author ask97
	 */
	public void clickOnCreateProduct()
	{
		CreateProductlogo.click();
	}

}
