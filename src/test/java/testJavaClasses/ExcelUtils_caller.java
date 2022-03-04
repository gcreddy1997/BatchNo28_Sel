package testJavaClasses;

import org.testng.annotations.Test;
import Reports.Reports;
import Utility.ExcelUtils;
import Reports.Log;

public class ExcelUtils_caller {
  @Test
  public void Excel_methodsValidation() {
	  Reports.startTest("Excel invocation", "Checking for the Excel methods execution status");
	  Log.startTest("Excel invocation", "Checking for the Excel methods execution status");
	  
	  // excel invocaiton...
	    ExcelUtils.invokeExcel("C:\\Users\\User\\eclipse-workspace\\org.magnitia.selenium.gcr_28\\inputData.xlsx");
	    
	  // Read the sheet value and return the  Object [] []
	    ExcelUtils.readData("Niharika");
	   
	   // read a specific cell data
	    String data=   ExcelUtils.readSpecificCellData(5,1);
	      System.out.println(data);
	     
	      // setting success message in provided excel sheet and and specified column and row
	    ExcelUtils.SetExcelData("C:\\Users\\User\\eclipse-workspace\\org.magnitia.selenium.gcr_28\\inputData.xlsx", "Success", 5, 6);
	  
	    Reports.endTest();
	    Log.endTest();
	   
	    Reports.flush();
	  
  }
}
