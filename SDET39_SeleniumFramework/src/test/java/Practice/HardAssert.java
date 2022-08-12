package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardAssert {
	
	@Test
	public void createC()
	{
		System.out.println("step 1");
		System.out.println("step 2");
		System.out.println("step 3");
		Assert.assertEquals("a", "b");
		System.out.println("step 4");
		System.out.println("step 5");
	}
	
	@Test
	public void modifyC()
	{
		System.out.println("*********************************");
		System.out.println("step 6");
		System.out.println("step 7");

		System.out.println("step 8");
		System.out.println("step 9");
		
	}

}
