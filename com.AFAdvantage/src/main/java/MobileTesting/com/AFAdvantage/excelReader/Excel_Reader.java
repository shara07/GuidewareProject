package MobileTesting.com.AFAdvantage.excelReader;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Reader {
	
	public FileOutputStream fileOut = null;
	public String path;
	public FileInputStream fis;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	
	
	public Excel_Reader(String path) {
		this.path = path;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	/**
	 * This Method will return 2D object data for each record in excel sheet.
	 * @param sheetName
	 * @param fileName
	 * @return
	 */
@SuppressWarnings({"deprecation"})
public String[][] getDataFromSheet(String sheetName, String ExcelName){
	
	
	String dataSets[][]=null;
	
	try {
		//get sheet from excel workbook
		XSSFSheet sheet = workbook.getSheet(sheetName);
		//count number of active rows
		int totalRow = sheet.getLastRowNum()+1;
		//count number of active columns in row
		int totalColumn = sheet.getRow(0).getLastCellNum();
		//Create array of rows and column
		dataSets = new String[totalRow-1][totalColumn];
		
		for(int i=1;i< totalRow; i++)
		{
			XSSFRow rows = sheet.getRow(i);
			for (int j=0; j< totalColumn; j++)
			{
				XSSFCell cell = rows.getCell(j);
				// if cell type is String then, this if condition will work
				if (cell.getCellType()==Cell.CELL_TYPE_STRING) {
					dataSets[i-1][j] = cell.getStringCellValue();
				   
				// if cell type is Number then this if condition will work
				}else if (cell.getCellType()==Cell.CELL_TYPE_NUMERIC) {
					String cellText = String.valueOf(cell.getNumericCellValue());
					dataSets[i-1][j] = cellText;
					
				}
				else {
					//if cell type is boolean, then this if condition will work
					String bCell = String.valueOf(cell.getBooleanCellValue());
					dataSets[i-1][j]= bCell;
					
				}
			}
			return dataSets;
		} 
	    } catch(Exception e) {
			System.out.println("Exception in reading xlsx file "+ e.getMessage());
	    }
		return dataSets;	
	} 
	
	


@SuppressWarnings({"deprecation"})
public String getCellData(String sheetName, String colName, int rowNum) {
	
	
	
	try {
		int col_Num = 0;
		int index = workbook.getSheetIndex(sheetName);
		sheet = workbook.getSheetAt(index);
		XSSFRow row = sheet.getRow(0);
		for(int i = 0; i<row.getLastCellNum(); i++) {
			if(row.getCell(i).getStringCellValue().equals(colName)) {
				col_Num = 1;
				break;
			}
		}
		
		row = sheet.getRow(rowNum-1);
		XSSFCell cell = row.getCell(col_Num);
		if (cell.getCellType()==Cell.CELL_TYPE_STRING) {
			return cell.getStringCellValue();
		}else if (cell.getCellType()==Cell.CELL_TYPE_BLANK) {
			return "";
		}
	} catch (Exception e) {
	
		e.printStackTrace();
	}

return null;

}






}
