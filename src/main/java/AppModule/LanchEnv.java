package AppModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import BaseClass.BaseClass;
import Constants.Constant;
import Reports.Log;
import Utility.Utility;
import Reports.Reports;

public class LanchEnv extends BaseClass{
	public static boolean flag;
	public static WebDriver driver;

	public static boolean lauchBrowser(String browser) {
		
		flag = false;
		   System.out.println(browser);
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", Constant.chromepath);
				driver = new ChromeDriver();
			
			} else {
				Log.warn("Give browser is not valid browser w.r.t. SWD");
			}
			
			Log.info("Browser invoked successfully");
			Reports.pass("Browser Invocation" , "Browser"+browser +" invoked successfully");
			flag = true;
		} catch (Exception e) {
			Log.fail(" " + e.fillInStackTrace());
			Reports.fail("Browser Invocation", "Browserinvocation failed due to " + e.toString(), "");
		}

		return flag;
	}
	
	//-----------------------------------------------------------------------------------------
	public static boolean lauchURL(String ApplicationURL) {
		 flag= false;
		 try {
		 driver.get(ApplicationURL);
		 	Utility.waitImplicit();
			driver.manage().window().maximize();
		 Log.info("Application "+ ApplicationURL +" is invoked successfully");
		 Reports.pass("Lauchisng URL", "Lauch url "+ ApplicationURL +" lauched successully" );
		 flag = true;
		 }catch(Exception e) {
			 Log.fail("Application invacation failed due to "+ e.fillInStackTrace());
			 Reports.fail("Application invoke", "Applicatin invocation failed due to " + e.toString(), "");
		 }
		
	    return flag;	
	}
	
	//-----------------------------------------------------------------------------------------
	public static boolean CloseBrowser() {
		flag = false;
		try {
		driver.close();
		flag = true;
		}catch(Exception e) {
		
		}	
		
		return flag;
	}
	
	
	
	
	
	
	

}
