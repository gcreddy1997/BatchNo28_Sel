package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



import Reports.Log;
import Reports.Reports;


public class ExcelUtils extends Utility {
	public static FileInputStream fis;
	public static XSSFWorkbook workbook;
	public static XSSFCell cell;
	public static XSSFSheet sheet;
	public static FileOutputStream fout;

	/**
	 * @author Gcreddy
	 * @param ExcelPath
	 * @ messages.... This method is invoking the excel path which you provided and
	 *   it will invoke that excel and not retuns any thing
	 */
	public static void invokeExcel(String ExcelPath) {
		try {
			fis = new FileInputStream(ExcelPath);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace(); // console
			Log.fail("Browser invocation failed " + e.fillInStackTrace());
		//	Reports.fail("Exce invocation", ExcelPath, "");
		}

		try {
			workbook = new XSSFWorkbook(fis);
			Log.info("File Invoked successfully");
		//	Reports.info("Excel Invocation", ExcelPath + " invoked successfyuly");
		} catch (IOException e) {
			Log.fail("Browser invocation failed " + e.fillInStackTrace());
		//	Reports.fail("Exce invocation", ExcelPath, "");
		}
	}

	// ------------------------------------------------------------------------------------------------------------------
	/**
	 * @author Gcreddy
	 * @param rowNum, coluNum This method is retriving the string value from the
	 *                specified cell in specific sheet ... retun type of this method
	 *                is String
	 */
	public static String readSpecificCellData(int rowNum, int columNum) {
		
		String value = null;
		try {
			 cell = sheet.getRow(rowNum).getCell(columNum);
			 value = cell.getStringCellValue();
			 Log.info("provided cell vlaue is :"+value);
		} catch (Exception e) {
			cell = sheet.getRow(rowNum).getCell(columNum);
			DataFormatter formater = new DataFormatter();
			 value = formater.formatCellValue(cell);
		}
	return value;
	}
	
	// -----------------------------------------------------------------------------------------------------------
	public static Object[][] readData(String sheetName){
		Object[][] excelData = null;
		
		 sheet = workbook.getSheet(sheetName);
		 int nur = sheet.getPhysicalNumberOfRows();
		 int nuc = sheet.getRow(0).getPhysicalNumberOfCells();
		
		 // crerating the Object [] [] and transfering the data from excel shee to double dimential array
		 excelData = new Object[nur-1] [nuc];
	    	int ci=0;
	    //   i is representing Rows of excel sheet
	    //  ci represents Object [][] rows.... 
	    	for(int i=1; i<nur; i++, ci++) {
	    		// j represents the excel columns
	    		// cj represent the Object [][] columns
	    		int cj=0;
	    		for(int j=0; j<nuc; j++, cj++) {
	    			 
	    		  //                            excel sheet
	    			excelData[ci] [cj] =   readSpecificCellData(i,j)  ;       
	    			System.out.println("Data store at index-- " + "Data[" + ci + "]" + "[" + cj + "]==>>" + "[" + i
							+ "]" + "[" + j + "]" + "--->" + excelData[ci][cj]);
	    	}		
		
		
	}
	    	return excelData;	
	}
	
  	//---------------------------------------------------------------------------------------------------
	    	public static void SetExcelData(String Filepath, String Result, int rownum, int colnum) {
	    		cell = sheet.getRow(rownum).createCell(colnum);
	    		cell.setCellValue(Result);
	    		try {
	    			fout = new FileOutputStream(Filepath);

	    		} catch (FileNotFoundException e) {
	    			Reports.fail("","", e.toString());
	    			System.out.println("Unable to locate Excel ");
	    			e.printStackTrace();
	    		}
	    		try {
	    			workbook.write(fout);
	    		} catch (IOException e) {
	    			Reports.fail("","",  e.toString());
	    			System.out.println("unable to set Excel Data");
	    		}
	    	}  
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
