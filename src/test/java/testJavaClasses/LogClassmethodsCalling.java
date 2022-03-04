package testJavaClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import Reports.Log;

public class LogClassmethodsCalling {
  @Test
  public void LoggerCallerfail() {
	  Log.startTest("Login Actions", "Login actions test case stating from here");
	  try {
		   Log.info("Browser Invoked successsfully");
	  }
	  catch(Exception e) {
		  e.printStackTrace();            // console
		  Log.fail("Browser invocation failed due to  "+ e.fillInStackTrace()  ); // it will writes into the log file
	  }
	  
	//  Log.warn("Your input is not correct please enter correct data......");
	//  Log.fatal("Our database don't have space hecne applicate data not inserting into data base ");
	
	  Assert.fail();
	  Log.endTest();
	  
		  
	  }
  
  
  @Test
  public void LoggerCallerPass() {
	  Log.startTest("Login Actions", "Login actions test case stating from here");
	  try {
		   Log.info("Broser Invoked successsfully");
	  }
	  catch(Exception e) {
		  e.printStackTrace();            // console
		  Log.fail("Browser invocation failed due to  "+ e.fillInStackTrace()  ); // it will writes into the log file
	  }
	  
	  Log.warn("Your input is not correct please enter correct data......");
	  Log.fatal("Our database don't have space hecne applicate data not inserting into data base ");
	  Log.endTest();
	  
		  
	  }
	  
  }

  

