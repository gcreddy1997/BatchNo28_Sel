package testJavaClasses;

import org.testng.annotations.Test;

import Reports.Reports;
import Reports.Log;


public class Reports_CallerClass {
	@Test
	  public void TestCaseNo6() {
		 Reports.startTest("infoTestCase", "This is the first test case");
		 Reports.info("StepOne", "Step one is executing successfully");			
		 Reports.endTest();
		 Reports.flush();
	  }
	
  @Test
  public void TestCaseNo1() {
	 Reports.startTest("FirstTestCase", "This is the first test case");
	 Reports.info("StepOne", "Step one is executing successfully");
	 Reports.pass("stepTwo", "This test case highest value is Pass");
	 Reports.endTest();
  }
  
  @Test
  public void TestCaseNo2() {
	 Reports.startTest("SecondTestCase", "This is the Second test case");
	 Reports.info("StepOne", "Step one is executing successfully");
	 Reports.pass("stepTwo", "This test case highest value is Pass");
	 Reports.warn("Step four ", "This warning method");
	 Reports.fail("StepThree", "This is the fail test case", "‪C:\\Users\\User\\Desktop\\general.png");
	 Reports.endTest();
  }
  
  @Test
  public void TestCaseNo3() {
	 Reports.startTest("ThirdTestCase", "This is the Third test case");
	 Reports.info("StepOne", "Step one is executing successfully");
	 Reports.pass("stepTwo", "This test case highest value is Pass");
	 Reports.warn("Step four ", "This warning method");
	 Reports.endTest();
  }
  
  @Test
  public void TestCaseNo4() {
	 Reports.startTest("ForthTestCase", "This is the Forth test case");
	 Reports.info("StepOne", "Step one is executing successfully");
	 Reports.pass("stepTwo", "This test case highest value is Pass");
	 Reports.fail("StepThree", "This is the fail test case", "‪C:\\Users\\User\\Desktop\\general.png");
	 Reports.warn("Step four ", "This warning method");
	 Reports.fatal("Step five", "This is fatal test case");
	 Reports.endTest();
	
  }






}
