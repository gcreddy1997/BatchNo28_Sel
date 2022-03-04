package Reports;



import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Log {
	  
	public static Logger logger = Logger.getLogger(Reports.class.getName());
	
	public static void startTest(String TestCaseName, String desc) {
		DOMConfigurator.configure("C:\\Users\\User\\eclipse-workspace\\org.magnitia.selenium.gcr_28\\Log4j.xml");
		logger.info("*****************    "  + TestCaseName + "   ***************************** ");
		logger.info("-------------------- "  + desc +"    ---------------------------------    " );		
	}
	// Log.info("browser invoked successfully")  // classname.methodname.
	public static void info(String desc) {
		logger.info(desc);
	}
	
	public static void fail(String desc) {
		logger.error(desc);
	}
	
	public static void warn(String desc) {
		logger.warn(desc);
	}
	
	public static void fatal(String desc) {
		logger.fatal(desc);
	}
	
	public static void endTest() {
		logger.info("  ############################################################################ ");
	}

    
}
