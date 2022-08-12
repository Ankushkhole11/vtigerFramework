package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	
	@Test(dataProvider="dataProvidermethod")
	public void bookTiket(String src, String dest)
	{
		System.out.println("Book tickets from "+src+" to "+dest+"");
	}
	
	@DataProvider
	public Object[][] dataProvidermethod()
	{
		Object[][] obj = new Object[5][2];
		obj[0][0]="Bangalore";
		obj[0][1]="Goa";
		
		obj[1][0]="Bangalore";
		obj[1][1]="mumbai";
		
		obj[2][0]="Bangalore";
		obj[2][1]="Akola";
		
		obj[3][0]="Bangalore";
		obj[3][1]="akot";
		
		obj[4][0]="Bangalore";
		obj[4][1]="Telhara";
		return obj;
	}
	

}
