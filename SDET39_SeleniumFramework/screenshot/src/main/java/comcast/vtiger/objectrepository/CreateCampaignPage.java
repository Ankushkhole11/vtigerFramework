package comcast.vtiger.objectrepository;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mysql.cj.jdbc.Driver;

public class CreateCampaignPage {
	
	public CreateCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//img[@alt='Select']")
	private WebElement AddProductSign;
	
	@FindBy(xpath="//input[@name='campaignname']")
	private WebElement CampaignNameTextfield;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(id="search_txt")
	private WebElement ProductNameSearchField;
	
	@FindBy(name="search")
	private WebElement ProductSearchButton;
	
	@FindBy(xpath="//input[@name='product_name']")
	private WebElement ProductNameTextfield;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement productSaveButton;
	
	@FindBy(xpath="//a[.='Products']")
	private WebElement productTab;
	
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement CreateProductlogo;

	public WebElement getAddProductSign() {
		return AddProductSign;
	}

	public WebElement getCampaignNameTextfield() {
		return CampaignNameTextfield;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getProductNameSearchField() {
		return ProductNameSearchField;
	}

	public WebElement getProductSearchButton() {
		return ProductSearchButton;
	}

	public WebElement getProductNameTextfield() {
		return ProductNameTextfield;
	}

	public WebElement getProductSaveButton() {
		return productSaveButton;
	}

	public WebElement getProductTab() {
		return productTab;
	}

	public WebElement getCreateProductlogo() {
		return CreateProductlogo;
	}

	/**
	 * 
	 * @param CampaignName
	 * @author ask97
	 * @param cpnName
	 */
	public void campaignTextfield(String cpnName)
	{
		CampaignNameTextfield.sendKeys(cpnName);
	}
	
	/**
	 * 
	 * @author ask97
	 */
	public void saveButton()
	{
		saveButton.click();
	}
	
	/**
	 * 
	 */
	public void productSelectionImage()
	{
		AddProductSign.click();
	}
	
	/**
	 * @throws Throwable 
	 * 
	 */
	public void productTextfield(String pdtName) throws Throwable
	{
		Thread.sleep(2000);
		ProductNameSearchField.sendKeys(pdtName);
	}
	
	/**
	 * @throws Throwable 
	 * 
	 */
	public void searchProductButton(WebDriver driver, String pdtName) throws Throwable 
	{
		Thread.sleep(2000);
		ProductSearchButton.click();
		driver.findElement(By.xpath("//a[text()='"+pdtName+"']")).click();
	}
	
	public void createProduct(WebDriver driver, String pdtName) 
	{
		HomePage hp = new HomePage(driver);
		hp.goToProductPage();
		ProductPage pd = new ProductPage(driver);
		pd.clickOnCreateProduct();
		CreateProductPage cpd = new CreateProductPage(driver);
		cpd.createNewProduct(pdtName);
	}
	
	
}
