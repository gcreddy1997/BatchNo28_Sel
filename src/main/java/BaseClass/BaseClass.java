package BaseClass;

import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;


import Constants.Constant;
import Reports.Reports;
import Utility.ExcelUtils;
import Utility.Utility;

public class BaseClass {
	
	public static Properties prop_config;
	public static Properties prop_loct;
	
	@BeforeSuite
	public void intiliaseFiles()
	{		
		DOMConfigurator.configure("Log4j.xml");
		prop_config = Utility.loadProperty(Constant.config_path);
		System.out.println("Config file read");
		prop_loct   = Utility.loadProperty(Constant.locaters_path);
		System.out.println("Locators file read");
		ExcelUtils.invokeExcel(Constant.TestData_excel_path);
		System.out.println("Three input files invoked sussessfully");
	}
	
	@AfterTest
	public void FLushReports()
	{
		Reports.flush();
	}  

}
