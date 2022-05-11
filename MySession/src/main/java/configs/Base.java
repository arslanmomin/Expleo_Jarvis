
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

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;

public class Base {

	//public static WebDriver driver;
	public static ThreadLocal<RemoteWebDriver> driver=new ThreadLocal<>();
	public static WebDriver getDriver() {
		return driver.get();
	}
	public ConfigurationSupport cs = new ConfigurationSupport("config files//global.properties");
	public static ExtentReports extent;
	public static ExtentTest parentTest;
	public static ExtentTest childTest;
	ExtentSparkReporter sparkReporter;

	
	@BeforeTest
	(alwaysRun = true)
	public void generateReport() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		final SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy_MM_dd HH_mm_ss");
		String name=sdf3.format(timestamp);
		sparkReporter = new ExtentSparkReporter("Report/"+name+".html");
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
	}

	@BeforeMethod
	(alwaysRun = true)
	public void methodName(Method method) {
		parentTest = extent.createTest(method.getName());
	}

	@BeforeSuite
	(alwaysRun = true)
	public void beforeSuite() {
		String browser = cs.getProperty("browser");
		
		DOMConfigurator.configure("config files//log4j.xml");
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true );
		
		switch (browser) {
		
		case "edge":
			WebDriverManager.edgedriver().setup();
			EdgeOptions eo= new EdgeOptions();
			eo.merge(dc);
			driver.set(new EdgeDriver(eo));
			getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			getDriver().manage().window().maximize();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions fo= new FirefoxOptions();
			fo.merge(dc);
			driver.set(new FirefoxDriver(fo));
			getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			getDriver().manage().window().maximize();
			break;

		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions co= new ChromeOptions();
			co.merge(dc);
			driver.set(new ChromeDriver(co));
			getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			getDriver().manage().window().maximize();
			break;

		}
		
		getDriver().get(cs.getProperty("url"));
	}

@AfterSuite
(alwaysRun = true)
	public void afterClass() {

	getDriver().close();
		System.out.println("browser closed");
		extent.flush();
	}

}
