package utilities;


import org.apache.log4j.Logger;

import configs.Base;

public class Log extends Base{
	
	// Initialize Log4j logs
	public static Logger Log = Logger.getLogger(Log.class.getName());

	public static void startTestCase(String sTestCaseName){		  
		 Log.info("====================================="+sTestCaseName+"  START=========================================");
		 }
	
	public static void endTestCase(String sTestCaseName){
		Log.info("====================================="+sTestCaseName+"  END=========================================");
		 }
	public static void failTestCase(String sTestCaseName){
		Log.info("====================================="+sTestCaseName+"  FAILED=========================================");
		 }
	
	// Need to create below methods, so that they can be called  

	 public static void info(String message) {

			Log.info(message);

			}
	 public static void exception(String msg,Exception e) {

			Log.error(msg,e);

			}
	 public static void exception(String msg) {

			Log.error(msg);

			}

	 public static void warn(String message) {

	    Log.warn(message);

		}

	 public static void error(String message) {

	    Log.error(message);

		}

	 public static void fatal(String message) {

	    Log.fatal(message);

		}

//	 public static void debug(String message) {
//
//	    Log.debug(message);
//
//		}
	
}
