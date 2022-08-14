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
import comcast.vtiger.objectrepository.HomePage;
import comcast.vtiger.objectrepository.ProductValidationPage;
@Listeners(comcast.vtiger.genericUtility.ListenerImplementationClass.class)
public class CreateCampaign extends BaseClass {

	
	@Test(groups= {"smokeTest"}, retryAnalyzer=comcast.vtiger.genericUtility.RetryImpClass.class)
	public void createCampaign() throws Throwable {
		//fetch data from properties file
		
		WebDriver_Utility wlib = new WebDriver_Utility();
		Java_Utility jlib = new Java_Utility();
		wlib.waitForPageToLoad(driver);

		HomePage hp = new HomePage(driver);
		hp.goToCampaignPage(driver);
	    CampaignPage cp = new CampaignPage(driver);
	    cp.createNewCampaignPage();
//	    Assert.assertEquals(true, false);
	    int ranNum = jlib.getRandomNum();

        //fetching data from excel
		Excel_Utility excel = new Excel_Utility();
		String cpnName = excel.getExcelData("./data/testdata.xlsx", "campaign", 1, 0)+ranNum;
		System.out.println(cpnName);

	    CreateCampaignPage ncp = new CreateCampaignPage(driver);
	    ncp.campaignTextfield(cpnName);
	    ncp.saveButton();

	    Thread.sleep(2000);
	    hp.takesScreenshotAs(driver, cpnName);
	    ProductValidationPage actualCampaignName = new ProductValidationPage(driver);
		String actualCampaignData = actualCampaignName.actualCampaignName();
		Assert.assertEquals(actualCampaignData.contains(cpnName),true);

		Thread.sleep(2000);
	//	hp.takesScreenshotAs(driver, cpnName);
		hp.signOut(driver);
		Thread.sleep(2000);
		driver.close();


	}
}
