package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./data/testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int rc = sh.getLastRowNum();
		
		for( int i = 0; i<=rc;i++)
		{
			  Row row = sh.getRow(i);
			  Cell cell = row.getCell(0);
			  String data = cell.getStringCellValue();
			  System.out.println(data);
			  
			  Row row1 = sh.getRow(i);
			  Cell cell1 = row1.getCell(1);
			  String data2 = cell1.getStringCellValue();
			  System.out.println(data2);
		}

	}

}
