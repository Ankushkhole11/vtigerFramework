package comcast.vtiger.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_Utility {
	
	public String getPropertyKeyValue(String Key) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./data/property.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String value = pro.getProperty(Key);
		return value;
		
	}
	

}
