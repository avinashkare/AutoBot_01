package Utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataFromExcel {
	
		public static void main(String[] args) throws EncryptedDocumentException, IOException {
			myData();
			}
		
		static void myData() throws EncryptedDocumentException, IOException {
			String path = "C:\\Users\\Akash Kare\\OneDrive\\Documents\\Automation\\MyData.xlsx";
			FileInputStream file = new FileInputStream(path);
		
			Sheet sh = WorkbookFactory.create(file).getSheet("First");
			int lastRow = sh.getLastRowNum();
			
			for(int i=0; i<=lastRow; i++) {
				Row r = sh.getRow(i);
				int lastCell = r.getLastCellNum();
				for(int j=0; j<lastCell; j++) {
					String cellData = null;
					Cell c = r.getCell(j);
					if (c.getCellType().toString().equalsIgnoreCase("string")) {
						cellData = c.getStringCellValue();
					}
					else {
						cellData = String.valueOf(c.getNumericCellValue());
					}
					System.out.println(cellData);
				}
			}
		}
		
}
		


