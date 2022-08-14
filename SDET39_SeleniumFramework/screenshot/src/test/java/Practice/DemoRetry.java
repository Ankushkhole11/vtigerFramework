package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoRetry {
	
	@Test(retryAnalyzer=comcast.vtiger.genericUtility.RetryImpClass.class)
	public void modifyContact() 
	{
		Assert.assertEquals(true, false);
		System.out.println("modify contact");
	}

}
