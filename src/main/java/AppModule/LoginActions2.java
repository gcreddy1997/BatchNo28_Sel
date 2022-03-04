package AppModule;

import org.testng.Assert;

import Reports.Log;
import Reports.Reports;
import Utility.Utility;


public class LoginActions2 extends Utility {
	public static boolean flag;

	public static boolean Login(String uname, String password, String Criteria, String Expmessages) {
		flag = false;
		try {

			Log.info("Performing Login operation");
			Utility.getLocater("Login_UserName_TxtBox_id").sendKeys(uname);
			Log.info("Username entered : " + uname);
			Utility.getLocater("Login_Pasword_TxtBox_name").sendKeys(password);
			Log.info("Password entered : " + password);
			Utility.getLocater("Login_signIn_button_xpath").click();
			Log.info("Submit button clicked");

			if (Criteria.equalsIgnoreCase("valid")) {

				try {
					Assert.assertEquals(prop_config.getProperty("HomePage_title"), driver.getTitle());
					Reports.pass("Test Login", "User successfully Logged in");
					flag = true;
				} catch (AssertionError e) {
					Reports.fail("Test Login", "Unable to Login", "");
					Reports.info("Login", "Test case passed successfully");
				}
			} else if (Criteria.equalsIgnoreCase("invalid") && (uname != "")) {
				String message = Utility.getLocater("Login_invalidun_message_xpath").getText();
				System.out.println(message);
				System.out.println(Expmessages);
				try {
					Assert.assertEquals(message, Expmessages);
					Reports.pass("Invalid us", "Test case passed successfully ...");
				} catch (Exception e) {
					Reports.fail("invalid us", "expeted is not matched with actual", "");
				}
			} else if (Criteria.equalsIgnoreCase("invalid") && (uname == "")) {
				String message = Utility.getLocater("Login_nullun_message_xpath").getText();
				System.out.println(message);
				System.out.println(Expmessages);
				try {
					Assert.assertEquals(message, Expmessages);
					System.out.println("test case passed.... for uname = ");
					Reports.pass("Invalid us", "Test case passed successfully ...");
				} catch (Exception e) {
					Reports.fail("invalid us", "expeted is not matched with actual", "");
				}
			}
			Reports.pass("User Login", "User successfully Logged in with UID " + uname + "and password " + password);
			flag=true;
		} catch (Exception e) {
			String filepath = Utility.getfailScreenshot();
			Reports.fail("Login", e.getMessage(), filepath);
			e.printStackTrace();
		}
		return flag;
	}

}
