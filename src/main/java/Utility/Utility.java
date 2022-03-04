package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import AppModule.LanchEnv;
import Reports.Reports;
import Reports.Log;

public class Utility extends LanchEnv {
	public static Properties prop;
	public static FileInputStream fis;
	public static WebElement element;
	public static JavascriptExecutor js;
	public static String filepath;

	public static Properties loadProperty(String Filepath) {
		prop = null;
		try {
			fis = new FileInputStream(Filepath);
			Log.info("Properites File invoked successfully" + Filepath);
			//Reports.info("Properties file invoke", "Properties file " + Filepath + "invoked successfuly");
		} catch (FileNotFoundException e) {
			Log.fail("Properites File invokation failed" + Filepath + e.fillInStackTrace());
		//	Reports.fail("Properties file invoke",
			//		"Properties file " + Filepath + "invocation failed due to" + e.toString(), "");
		}
		prop = new Properties();

		try {
			prop.load(fis);
			Log.info("Properties loaded successfuly");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Log.fail("Properties not loaded due to " + e.fillInStackTrace());
		}

		return prop;
	}

	// ----------------------------------------------------------------------------------------------
	public static WebElement getLocater(String key) {
		element = null;
		String value = prop_loct.getProperty(key);
		Log.info("Locator information is " + key + " =  " + value);
		if (key.endsWith("_id")) {
			element = driver.findElement(By.id(value));
			ElementHighlight(element);
		} else if (key.endsWith("_name")) {
			element = driver.findElement(By.name(value));
			ElementHighlight(element);
		} else if (key.endsWith("_className")) {
			element = driver.findElement(By.className(value));
			ElementHighlight(element);
		} else if (key.endsWith("_xpath")) {
			element = driver.findElement(By.xpath(value));
			ElementHighlight(element);
		} else
			Log.warn("Provided key is not avaialbe in the locator.properties ");

		return element;

	}

	public static void ElementHighlight(WebElement element) {
		 js = (JavascriptExecutor)driver;
	//	.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:2px solid red;');", element);
		 try {
		 js.executeScript(" arguments[0].setAttribute('style', 'background: yellow; border: 2px dashed red');" , element);
		 Thread.sleep(1000);
		//   Log.info("Element  highlighted successfully");
		 } catch(Exception e) {
			Log.fail("High light of an element failed");
			
		 }
	
	}

	/***************************************************************************************
	 * This function will close the current session
	 * 
	 * @throws IOException
	 **************************************************************************************/
	public static void closeBrowser() throws IOException {
		try {
			Log.info("Closing Browser");
			driver.quit();	
		} catch (Exception e) {
			Reports.fail("",e.toString(),"");
			Log.info(""+ e.fillInStackTrace());
		}	
	}	
	//--------------------------------------------------------------------------------------------------------

	public static List<WebElement> ElementCollection(String xpath)
	{
		List<WebElement> collections = driver.findElements(By.xpath(xpath));
		return collections;
	}

	/*****************************************************************************************
	 * This function will dynamically wait for pageload.
	 * 
	 * @exception Exception
	 ****************************************************************************************/
	public static void Elementwait() throws Exception {
	
		Log.info("Waiting for page load");
		Thread.sleep(1000);
		WebDriverWait explicitwait = new WebDriverWait(driver, 120);
		explicitwait.withTimeout(90, TimeUnit.SECONDS);
		explicitwait.pollingEvery(2, TimeUnit.SECONDS);
		explicitwait.ignoring(NoSuchElementException.class);
		Thread.sleep(500);
	
		
	}

	/*****************************************************************************************
	 * This function wait implicitly for mentioned time duration.
	 * 
	 * @exception Exception
	 ****************************************************************************************/
	public static void waitImplicit() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	/*****************************************************************************************
	 * This function will dynamically wait for text on element to be present.
	 * 
	 * @param Key
	 * @param text
	 * @throws InterruptedException 
	 * @exception Exception
	 ****************************************************************************************/
	public static void waitForTextToBeDisplayed(String Key) throws InterruptedException {
			Thread.sleep(1000);
			Log.info("Waiting for the Element to be visible");
			WebDriverWait wait = new WebDriverWait(driver, 200);
			wait.withTimeout(900, TimeUnit.SECONDS);
			wait.pollingEvery(2, TimeUnit.SECONDS);
			wait.ignoring(NoSuchElementException.class);
			wait.ignoring(InvalidSelectorException.class);
			wait.until(ExpectedConditions.visibilityOf(Utility.getLocater(Key)));		
	}
	//------------------------------------------------------------------------------------------	
		public static void waitForElementClickable(String Key) throws InterruptedException {
	
			Thread.sleep(2000);
			Log.info("Waiting for the Element to be clickable");
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.withTimeout(60, TimeUnit.SECONDS);
			wait.pollingEvery(2, TimeUnit.SECONDS);
			wait.ignoring(NoSuchElementException.class);
			wait.ignoring(InvalidSelectorException.class);
			wait.ignoring(WebDriverException.class);
			wait.until(ExpectedConditions.elementToBeClickable(getLocater(Key)));	
	}
	//------------------------------------------------------------------------------------------

		public static void getCurrentDate() {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
			Date date = new Date();
			System.out.println(date);		
		}

		/***************************************************************************************
		 * This function will give you System date time in string format
		 * 
		 * @return This function will return date time in String format.
		 **************************************************************************************/
		public static String getDate() {
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			String founddate = dateFormat.format(date);
			String[] parts = founddate.split(" ");
			String[] appenderpart1 = parts[0].split("/");
			String appender = appenderpart1[1] + "-" + appenderpart1[2] + "-" + appenderpart1[0];
			return appender;
		}

		/***************************************************************************************
		 * This function will give you System date time in string format
		 * 
		 * @return This function will return date time in String format.
		 **************************************************************************************/
		public static String getDatetime() {
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			String founddate = dateFormat.format(date);
			Log.info(dateFormat.format(date));      // 2014/08/06 15:59:48
		
			String[] parts = founddate.split(" ");
			// String part1 = parts[0]; // 004
			String[] appenderpart1 = parts[0].split("/");
			String[] appenderpart2 = parts[1].split(":");
			String appender = appenderpart1[1] + appenderpart1[2] + appenderpart2[0] + appenderpart2[1] + appenderpart2[2];
			Log.info(appender);
			return appender;
		}

		/***************************************************************************************
		 * This function will take screenshot on faliure of test cases.
		 * 
		 * @return filepath
		 * @see Use this function on negative secnarios.
		 * 
		 **************************************************************************************/
		
		public static String getfailScreenshot() {
			try {
				filepath = null;
				File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				filepath = System.getProperty("user.dir") + "\\Screenshots\\FaliureScreenshots\\" + System.currentTimeMillis()
						+ ".png";
				FileUtils.copyFile(file, new File(filepath));
			} catch (IOException e) {
				Reports.fail("",e.toString(),"");
				e.printStackTrace();
			}
			return filepath;
		}

		/*************************************************************************************
		 * This function will get screenshot on Success of executed Test Cases.
		 * 
		 * @return filepath This function will return the String path of the
		 *         screenshot.
		 * @exception IOException
		 **************************************************************************************/
		public static String getSuccessScreenshot() {
			try {
				filepath = null;
				File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				filepath = System.getProperty("user.dir") + "\\Screenshots\\SuccessScreenshots\\"
						+ System.currentTimeMillis() + ".png";
				FileUtils.copyFile(file, new File(filepath));
			} catch (IOException e) {
				Reports.fail("",e.toString(),"");
				e.printStackTrace();
			}
			return filepath;
		}

		/*******************************************************************************************
		 * This function will clean the framework and will delete the files and
		 * folder for specific mentioned time duration
		 * 
		 * @param daysBack
		 * @param dirWay
		 ******************************************************************************************/
		public static void FrameworkcleanUp(int daysBack, String dirWay) {
		
			File directory = new File(dirWay);
			if (directory.exists()) {
		
				File[] listFiles = directory.listFiles();
				long purgeTime = System.currentTimeMillis() - (daysBack * 24 * 60 * 60 * 1000);
				for (File listFile : listFiles) {
					if (listFile.lastModified() < purgeTime) {
						if (!listFile.delete()) {
							System.err.println("Unable to delete file: " + listFile);
						}
					}
				}
			}
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
