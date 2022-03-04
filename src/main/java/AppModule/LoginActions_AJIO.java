package AppModule;

import Utility.Utility;

import java.util.ArrayList;
import java.util.List;

import Reports.Log;
import Reports.Reports;

public class LoginActions_AJIO extends Utility {
	public static boolean flag;

	public static boolean LoginActions(String un, String pw, String expText) throws InterruptedException {
		flag = false;
		Log.info("Login Actions process started here ");
		//Utility.getLocater("loign_close_button_xpath").click();
		Utility.getLocater("login_sign_in_Button_xpath").click();
		Thread.sleep(2000);
		Utility.getLocater("login_google_button_xpath").click();
		Thread.sleep(1000);
		ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(list.get(1));	
		Thread.sleep(5000);
		//driver.navigate().to("https://accounts.google.com/");
		
		Utility.getLocater("googleAccounts_emailID_textbox_xpath").sendKeys(un);
		Utility.getLocater("googleAccounts_nextemail_button_xpath").click();
		Utility.getLocater("googleAccounts_Pw_textbox_id").sendKeys(pw);
		Utility.getLocater("googleAccounts_nextpw_button_xpath").click();
		Thread.sleep(3000);

		String ActText = Utility.getLocater("Home_loginValidation_getText_xpath").getText();

		if (expText.equalsIgnoreCase(ActText)) {
			Log.info("Login actions activity done successfully. and expeced text " + expText
					+ " is displaying successfully");
			Reports.pass("Login Actions", "Login action is done successfully");
			flag = true;
		} else {
			Log.fail("Login actions failed ");
			Reports.fail("LoginActions", "Login Actions failed", "");
		}

		return flag;
	}

}
