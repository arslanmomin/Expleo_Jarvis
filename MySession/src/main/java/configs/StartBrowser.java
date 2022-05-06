
package configs;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ConfigurationSupport;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;

public class StartBrowser {

	public static WebDriver driver;
	public ConfigurationSupport cs = new ConfigurationSupport("config files//global.properties");
	public static ExtentReports extent;
	public static ExtentTest parentTest;
	public static ExtentTest childTest;
	ExtentSparkReporter sparkReporter;

	
	@BeforeTest
	(alwaysRun = true)
	public void generateReport() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		final SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH_mm_ss");
		String name=sdf3.format(timestamp);
		sparkReporter = new ExtentSparkReporter("Report/"+name+".html");
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
	}oioidi

	@BeforeMethod
	(alwaysRun = true)
	public void methodName(Method method) {
		parentTest = extent.createTest(method.getName());
	}

	@BeforeSuite
	(alwaysRun = true)
	public void beforeClass() {
		String browser = cs.getProperty("browser");
		switch (browser) {
		
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			break;

		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			break;

		}
	}

@AfterSuite
(alwaysRun = true)
	public void afterClass() {

		driver.close();
		System.out.println("browser closed");
		extent.flush();
	}

}
