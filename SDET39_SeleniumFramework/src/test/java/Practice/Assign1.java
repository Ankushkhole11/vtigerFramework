package Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import AK.Flib;

public class Assign1 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		Thread.sleep(3000);
		Flib flib = new Flib();
		int rc = flib.getRowCount("./data/testdata1.xlsx", "Sheet1");
		
		for(int i=0; i<=rc; i++)
		{
			String firstcolumn = flib.readExcelData("./data/testdata1.xlsx", "Sheet1", i, 0);
			System.out.println(firstcolumn);
			
			String secondcolumn = flib.readExcelData("./data/testdata1.xlsx", "Sheet1", i, 1);
			System.out.println(secondcolumn);
		}
		
		
		
		

	}

}
