package UiBanK_Uipath;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AppModule.LanchEnv;
import AppModule.LoginActions2;
import Reports.Log;
import Reports.Reports;

public class Login_into_Uibank_withDataProvider extends LoginActions2 {
  @BeforeMethod
  public void OpenBrowserAndURL() throws InterruptedException {
	  Reports.startTest("LoginActions", "Executing the test case for Positive Data only");
	  // launch browser..
	  Assert.assertTrue(LanchEnv.lauchBrowser(prop_config.getProperty("browser")));
	  
	  // launch URL
	  Assert.assertTrue(LanchEnv.lauchURL(prop_config.getProperty("Uipbank_Uipath_url")));
  }
  											// [Rows][Columns]
  @Test (dataProvider = "anyName")      //Object[7]     [5]
  public  void Login_Runner(String rm,  String un,  String pw, String criteria, String ExpectedConditions) {
	  if(rm.equalsIgnoreCase("Yes")) {
		  
	  Assert.assertTrue(LoginActions2.Login(un, pw, criteria, ExpectedConditions)) ; 
	  }
	  else {
		  System.out.println("It is executing for error message where runMode = NO...");
		  Log.info("It is executing for error message where runMode = NO...");
		  Reports.info("No data" , "It is executing for error message where runMode = NO...");
	  }
  }
  
  
  @AfterMethod
  public void closeBroser() {
	 LanchEnv.CloseBrowser();
	 Reports.endTest();
  } 
      
  @ DataProvider(name="anyName")
  public Object[][] gettingTheDatafromExcelSheet() {
	  Object[][] exceldata = null;
	  exceldata = Utility.ExcelUtils.readData("Login_Credentials");	  
	  return exceldata;
	  
  }
  
}
