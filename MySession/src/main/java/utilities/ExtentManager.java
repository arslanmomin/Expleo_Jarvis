package utilities;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import configs.Base;

public class ExtentManager extends Base {
	
	public static ExtentReports extent;
	public static ExtentTest parentTest;
	public static ExtentTest childTest;
	static ExtentSparkReporter sparkReporter;
	
	public static void generateReport() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		final SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy_MM_dd HH_mm_ss");
		String name = sdf3.format(timestamp);
		sparkReporter = new ExtentSparkReporter("Report/" + name + ".html");
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Name", "Jarvis");
		
	}
	public static void endReport() {
		extent.flush();
}
}
