package Constants;

import Utility.Utility;

public class Constant {
	
	public static final String TestData_excel_path = System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\ProjectTestData.xlsx";
	
	public static final String locaters_path = System.getProperty("user.dir")+"\\src\\test\\resources\\ObjectRepository\\Locater.properties";
	
	public static final String config_path = System.getProperty("user.dir")+"\\src\\test\\resources\\ObjectRepository\\Config.properties";
	
	public static final String chromepath = System.getProperty("user.dir")+"\\Driver1\\chromedriver.exe";
	
	public static final String log4jpath = System.getProperty("user.dir")+"\\Log4j.xml";
	
	public static final String ReportsPath = System.getProperty("user.dir")+"\\Execution Reports\\"+Utility.getDate()+"\\"+Utility.getDatetime()+".html";
	

}
