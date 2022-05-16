package configs;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ConfigurationSupport;
import utilities.ExtentManager;
import utilities.Log;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

	// public static WebDriver driver;
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return driver.get();
	}

	public ConfigurationSupport cs = new ConfigurationSupport("config files//global.properties");
	String browser = cs.getProperty("browser");
	String headless=cs.getProperty("headless");

	@BeforeTest(alwaysRun = true)
	public void report() {
		ExtentManager.generateReport();
		ExtentManager.extent.setSystemInfo("browser", browser);
		ExtentManager.extent.setSystemInfo("headless", headless);
	}

	@BeforeMethod(alwaysRun = true)
	public void methodName(Method method) {
		
	}


	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() {

		DOMConfigurator.configure("config files//log4j.xml");

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		switch (browser) {

		case "edge":
			WebDriverManager.edgedriver().setup();
			EdgeOptions eo = new EdgeOptions();
			if(headless.equals("true"))
				((EdgeOptions) eo).addArguments("headless");
			eo.merge(dc);
			driver.set(new EdgeDriver(eo));
			getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			getDriver().manage().window().maximize();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions fo = new FirefoxOptions();
			if(headless.equals("true"))
				((FirefoxOptions) fo).addArguments("headless");
			fo.merge(dc);
			driver.set(new FirefoxDriver(fo));
			getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			getDriver().manage().window().maximize();
			break;

		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions co = new ChromeOptions();
			if(headless.equals("true"))
			((ChromeOptions) co).addArguments("headless");
			co.merge(dc);
			driver.set(new ChromeDriver(co));
			getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			getDriver().manage().window().maximize();
			break;

		}

		getDriver().get(cs.getProperty("url"));
	}

	@AfterSuite(alwaysRun = true)
	public void afterClass() {

		getDriver().close();
		System.out.println("browser closed");
		ExtentManager.endReport();
	}


}
