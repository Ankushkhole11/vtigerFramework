package Practice;

import org.testng.annotations.Test;

public class RunTimeParameterFromEclipse {
	
	@Test
	public void getData()
	{
		System.out.println(System.getProperty("browser"));
		System.out.println(System.getProperty("url1"));
		System.out.println(System.getProperty("un"));
	}

}
