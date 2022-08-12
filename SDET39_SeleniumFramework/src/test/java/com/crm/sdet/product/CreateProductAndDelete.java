package com.crm.sdet.product;

import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import comcast.vtiger.genericUtility.BaseClass;
import comcast.vtiger.genericUtility.Excel_Utility;
import comcast.vtiger.genericUtility.File_Utility;
import comcast.vtiger.genericUtility.Java_Utility;
import comcast.vtiger.genericUtility.WebDriver_Utility;
import comcast.vtiger.objectrepository.CreateProductPage;
import comcast.vtiger.objectrepository.HomePage;
import comcast.vtiger.objectrepository.LoginPage;
import comcast.vtiger.objectrepository.ProductPage;
import comcast.vtiger.objectrepository.ProductValidationPage;
@Listeners(comcast.vtiger.genericUtility.ListenerImplementationClass.class)
public class CreateProductAndDelete extends BaseClass {

	@Test
	public void createProductAndDelete() throws Throwable {

		//fetch data from properties file
		
		WebDriver_Utility wlib = new WebDriver_Utility();
		Java_Utility jlib = new Java_Utility();
		wlib.waitForPageToLoad(driver);
		
		HomePage hp = new HomePage(driver);
		hp.goToProductPage();
		
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
		Thread.sleep(3000);
		hp.takesScreenshotAs(driver, pdtName);
		driver.findElement(By.xpath("//input[@title='Delete [Alt+D]']")).click();
		wlib.switchToAlertAndAccept(driver);
		Thread.sleep(2000);
	//	hp.takesScreenshotAs(driver, pdtName);
		hp.signOut(driver);
		driver.close();
	

		
		
		
		
		
//		driver.findElement(By.linkText("Products")).click();
//		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
//
//		//to use random cell value
//		int ranNum = jlib.getRandomNum();
//
//		Excel_Utility excel = new Excel_Utility();
//		String pdtName = excel.getExcelData("./data/testdata.xlsx", "product", 1, 0)+ranNum;
//		System.out.println(pdtName);
//
//		driver.findElement(By.name("productname")).sendKeys(pdtName);
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//
//		String actData = driver.findElement(By.cssSelector("span.lvtHeaderText")).getText();
//		if(actData.contains(pdtName))
//		{
//			System.out.println("pass");
//		}
//		else {
//			System.out.println("fail");
//		}
//		
//		driver.findElement(By.xpath("//input[@title='Delete [Alt+D]']")).click();
//		Thread.sleep(2000);
//
//		wlib.switchToAlertAndAccept(driver);                       //accept alert popup
//		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//		wlib.mouseOverOnElement(driver, element);                 // mouse over action
//		driver.findElement(By.linkText("Sign Out")).click();
//		Thread.sleep(2000);
//		driver.close();

	}

}
