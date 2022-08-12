package com.crm.sdet.campaign;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import comcast.vtiger.genericUtility.BaseClass;
import comcast.vtiger.genericUtility.Excel_Utility;
import comcast.vtiger.genericUtility.Java_Utility;
import comcast.vtiger.genericUtility.WebDriver_Utility;
import comcast.vtiger.objectrepository.CampaignPage;
import comcast.vtiger.objectrepository.CreateCampaignPage;
import comcast.vtiger.objectrepository.CreateProductPage;
import comcast.vtiger.objectrepository.HomePage;
import comcast.vtiger.objectrepository.ProductPage;
import comcast.vtiger.objectrepository.ProductValidationPage;
@Listeners(comcast.vtiger.genericUtility.ListenerImplementationClass.class)
public class CampaignWithProduct extends BaseClass {

	@Test
	public void campaignWithProduct() throws Throwable {

		WebDriver_Utility wlib = new WebDriver_Utility();
		Java_Utility jlib = new Java_Utility();
		wlib.waitForPageToLoad(driver);

		HomePage hp = new HomePage(driver);
		hp.goToProductPage();

		int ranNum = jlib.getRandomNum();
		int ranNum1 = jlib.getRandomNum();

		Excel_Utility excel = new Excel_Utility();
		String pdtName = excel.getExcelData("./data/testdata.xlsx", "product", 2, 0)+ranNum;
		String cpnName = excel.getExcelData("./data/testdata.xlsx", "campaign", 1, 0)+ranNum1;
		System.out.println(pdtName);
		System.out.println(cpnName);

		ProductPage pd = new ProductPage(driver);
		pd.clickOnCreateProduct();
		CreateProductPage npd = new CreateProductPage(driver);
		npd.createNewProduct(pdtName);

		hp.goToCampaignPage(driver);
		CampaignPage cp = new CampaignPage(driver);
		cp.createNewCampaignPage();

		CreateCampaignPage ncp = new CreateCampaignPage(driver);

		//ncp.createProduct(driver, pdtName);
		ncp.campaignTextfield(cpnName);
		ncp.productSelectionImage();
		wlib.switchToWindow(driver, "Products&action");
		Thread.sleep(2000);
		ncp.productTextfield(pdtName);
		ncp.searchProductButton(driver, pdtName);

		wlib.switchToWindow(driver, "Campaigns&action");
		ncp.saveButton();

		ProductValidationPage actualCampaignName = new ProductValidationPage(driver);
		String actualCampaignData = actualCampaignName.actualCampaignName();
		Assert.assertEquals(actualCampaignData.contains(cpnName),true);
		Thread.sleep(2000);
	//	hp.takesScreenshotAs(driver, cpnName);

		hp.signOut(driver);
		Thread.sleep(1000);
		driver.close();




		
		
		
		
		
		
		
		
		
		
		

		//		driver.findElement(By.name("user_name")).sendKeys(username);
		//		driver.findElement(By.name("user_password")).sendKeys(password);
		//		driver.findElement(By.id("submitButton")).click();

		//
		//		driver.findElement(By.linkText("Products")).click();
		//		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();

		//to use random cell value


		//fetch the product and campaign from excel through generic methods

		//
		//		driver.findElement(By.name("productname")).sendKeys(pdtName);
		//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//
		//		WebElement element = driver.findElement(By.linkText("More"));
		//		wlib.mouseOverOnElement(driver, element);
		//		driver.findElement(By.linkText("Campaigns")).click();
		//		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		//		//campaign name from excel
		//
		//		driver.findElement(By.cssSelector("input[name='campaignname']")).sendKeys(cpnName);
		//		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		//		Thread.sleep(2000);
		//		
		//		//window switch from generic method
		//		wlib.switchToWindow(driver, "Products&action");
		//

		//		driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(pdtName);
		//		driver.findElement(By.cssSelector("input[name='search']")).click();
		//		driver.findElement(By.xpath("//a[text()='"+pdtName+"']")).click();
		//		
		//		wlib.switchToWindow(driver, "Campaigns&action");
		//
		//		Thread.sleep(3000);
		//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

	}

}
