package com.crm.sdet.product;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import comcast.vtiger.genericUtility.BaseClass;
import comcast.vtiger.genericUtility.Excel_Utility;
import comcast.vtiger.genericUtility.Java_Utility;
import comcast.vtiger.genericUtility.WebDriver_Utility;
import comcast.vtiger.objectrepository.CreateProductPage;
import comcast.vtiger.objectrepository.HomePage;
import comcast.vtiger.objectrepository.ProductPage;
import comcast.vtiger.objectrepository.ProductValidationPage;

@Listeners(comcast.vtiger.genericUtility.ListenerImplementationClass.class)
public class CreateProductAndVerifyTest extends BaseClass{
	
	@Test(groups= {"regressionTest"})
	public  void createProductAndVerify() throws Throwable {
		//fetch data from properties file
		
			WebDriver_Utility wlib = new WebDriver_Utility();
			Java_Utility jlib = new Java_Utility();
			wlib.waitForPageToLoad(driver);
			
			HomePage home = new HomePage(driver);
			home.goToProductPage();
			
			ProductPage pdtPage = new ProductPage(driver);
			pdtPage.clickOnCreateProduct();
			
			int ranNum = jlib.getRandomNum();
			Excel_Utility ex = new Excel_Utility();
			String pdtName = ex.getExcelData("./data/testdata.xlsx", "product", 1, 0)+ranNum;
			
			CreateProductPage createPdt = new CreateProductPage(driver);
			createPdt.createNewProduct(pdtName);
	
			ProductValidationPage actualProductName = new ProductValidationPage(driver);
			String actualProductData = actualProductName.actualProductName();
			Assert.assertEquals(actualProductData.contains(pdtName),true);
		
	//		home.takesScreenshotAs(driver, pdtName);
			home.signOut(driver);
			driver.close();
		
	}
	
			

}
