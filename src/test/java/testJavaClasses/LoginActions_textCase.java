package testJavaClasses;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AppModule.LanchEnv;
import AppModule.LoginActions_AJIO;
import Reports.Reports;

public class LoginActions_textCase extends LanchEnv {
	
  
	@BeforeMethod
	public static void invokeBrowser() {
		try {
			Reports.startTest("Login Actions", "Login Actions is executing for hard coded data....");
			Assert.assertTrue(LanchEnv.lauchBrowser(prop_config.getProperty("browser")));		

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void login_hardCodedData() throws InterruptedException {
		Assert.assertTrue(LanchEnv.lauchURL(prop_config.getProperty("ajio_URL")));
		Assert.assertTrue(LoginActions_AJIO.LoginActions("gcreddy1997@gmail.com", "Telus@2022", "Chinnappa Reddy Gopu"));

	}
	
	
	@AfterMethod
	public void closeBrowser() {
		LanchEnv.CloseBrowser();
		Reports.endTest();
	}
	
	

}
