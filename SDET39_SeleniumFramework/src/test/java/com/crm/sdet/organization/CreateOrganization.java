package com.crm.sdet.organization;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import comcast.vtiger.genericUtility.BaseClass;
import comcast.vtiger.genericUtility.Excel_Utility;
import comcast.vtiger.genericUtility.Java_Utility;
import comcast.vtiger.genericUtility.WebDriver_Utility;
import comcast.vtiger.objectrepository.CreateOrganizationPage;
import comcast.vtiger.objectrepository.HomePage;
import comcast.vtiger.objectrepository.OrganizationPage;
import comcast.vtiger.objectrepository.ProductValidationPage;
@Listeners(comcast.vtiger.genericUtility.ListenerImplementationClass.class)
public class CreateOrganization extends BaseClass{


	@Test(groups= {"smokeTest","regressionTest"})
	public void createOrganization() throws Throwable {

		WebDriver_Utility wlib = new WebDriver_Utility();
		Java_Utility jlib = new Java_Utility();
		wlib.waitForPageToLoad(driver);

		HomePage home = new HomePage(driver);
		home.goToOrganizationPage();

		OrganizationPage createOrg = new OrganizationPage(driver);
		createOrg.clickOnCreateOrganization();
		//Assert.assertEquals(true, false);

		int ranNum = jlib.getRandomNum();
		Excel_Utility ex = new Excel_Utility();
		String orgName = ex.getExcelData("./data/testdata.xlsx", "Organization", 1, 0)+ranNum;
		CreateOrganizationPage newOrg = new CreateOrganizationPage(driver);
		newOrg.createNewOrganization(orgName);

		ProductValidationPage actualOrganizationName = new ProductValidationPage(driver);
		String actualOrganizationData = actualOrganizationName.actualOrganizationName();
		Assert.assertEquals(actualOrganizationData.contains(orgName),true);

		Thread.sleep(2000);
//		home.takesScreenshotAs(driver, orgName);
		home.signOut(driver);
		driver.close();
		Thread.sleep(1000);


	}

}
