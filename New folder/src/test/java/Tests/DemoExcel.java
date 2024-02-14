package Tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DemoExcel {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("Sample.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		int sheetcount=wb.getNumberOfSheets();
		
		for(int i=0; i<sheetcount; i++) {
			if(wb.getSheetName(i).equals("Data")) {
				XSSFSheet sheet = wb.getSheetAt(i);
				Iterator<Row> rows = sheet.rowIterator();
				Row firstRow = rows.next();
				Iterator<Cell>firstRowCells = firstRow.cellIterator();
				while(firstRowCells.hasNext()) {
					
				}
			}
		}
		
		

	}

}
