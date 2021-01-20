package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public String path;
	public FileInputStream fis = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	public ExcelReader(String path) throws IOException {
		this.path = path;
		try {
			fis = new FileInputStream("C:\\Users\\ttatr\\Desktop\\ExcelData.xlsx");
			workbook = new XSSFWorkbook(fis);
			int sheets = workbook.getNumberOfSheets();
			for (int i = 0; i < sheets; i++) {
				if (workbook.getSheetName(i).equalsIgnoreCase("testdata1")) {
					sheet = workbook.getSheetAt(i);
				}
			}
			
			fis.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// Method to call the value
	public ArrayList<String> getCellData(String ColumnName, String RowName) {
		
		ArrayList<String> a = new ArrayList<String>();
		Iterator<Row> rows = sheet.iterator();
		Row first_row = rows.next();
		Iterator<Cell> ce = first_row.cellIterator();
		
		int i = 0;
		int col_Num = 0;
		while (ce.hasNext()) {
			Cell value = ce.next();
			if(value.getStringCellValue().equalsIgnoreCase(ColumnName)) {
				col_Num = i;
				
			}
			
			i++;
		}
		
		while (rows.hasNext()) {
			Row r = rows.next();
			if(r.getCell(col_Num).getStringCellValue().equalsIgnoreCase(RowName)) {
				Iterator<Cell> cv = r.cellIterator();
				while (cv.hasNext()) {
					a.add(cv.next().getStringCellValue());
					
				}
			}
		}
		return a;
		
		

		}
	}

