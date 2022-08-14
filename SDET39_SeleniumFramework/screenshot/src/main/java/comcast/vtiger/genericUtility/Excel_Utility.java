package comcast.vtiger.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	
	public String getExcelData(String Excelpath, String sheetName, int rowcount, int cellcount) throws Throwable
	{
		FileInputStream fis = new FileInputStream(Excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
//		Row rw = sh.getRow(rowcount);
//		Cell cel = rw.getCell(cellcount);
//		String Name = cel.getStringCellValue();
//		System.out.println(Name);
//		
		
      DataFormatter format = new DataFormatter();
      return format.formatCellValue(sh.getRow(rowcount).getCell(cellcount));
//		return Name;
	}

}
