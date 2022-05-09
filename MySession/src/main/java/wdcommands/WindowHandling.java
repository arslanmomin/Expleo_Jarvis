package wdcommands;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.MediaEntityBuilder;

import configs.StartBrowser;


public class WindowHandling {
	public WebDriver driver;

	public WindowHandling() {
		driver = StartBrowser.driver;
	}
	


	
	public void SwitchToChild()  {
		try {
			String mainWindowHandle = driver.getWindowHandle();
	        Set<String> allWindowHandles = driver.getWindowHandles();
	        Iterator<String> iterator = allWindowHandles.iterator();

	        // Here we will check if child window has other child windows and will fetch the heading of the child window
	        while (iterator.hasNext()) {
	            String ChildWindow = iterator.next();
	                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
	                driver.switchTo().window(ChildWindow);
	               // WebElement text = driver.findElement(By.id("sampleHeading"));
	              //  System.out.println("Heading of child window is " + text.getText());
	       
				StartBrowser.childTest.pass("Switched To Child Window");
				
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
	                }}	
		} 
	                catch (Exception e) {
			StartBrowser.childTest.fail("can to switch to child window ");
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			StartBrowser.childTest.info(e);
			throw e;
			
		}
	}
	
	public void SwitchBack()  {
		try {
			  String mainwindow = driver.getWindowHandle();
		        Set<String> s1 = driver.getWindowHandles();
		        Iterator<String> i1 = s1.iterator();
		        
		        while (i1.hasNext()) {
		            String ChildWindow = i1.next();
		                if (!mainwindow.equalsIgnoreCase(ChildWindow)) {
		                driver.switchTo().window(ChildWindow);
		             //   WebElement text = driver.findElement(By.id("sampleHeading"));
		              //  System.out.println("Heading of child window is " + text.getText());
		                driver.close();
		                System.out.println("Child window closed");
		            	StartBrowser.childTest.pass("Switched To Main  Window");
		            }
		        }    
		  
		        //  Switch back to the main window which is the parent window.
		        	driver.switchTo().window(mainwindow);	
		} 
	                catch (Exception e) {
			StartBrowser.childTest.fail("Cannot Switch Back to Main Window ");
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			StartBrowser.childTest.info(e);
			throw e;
			
		}
	}
	
	public void maximizeWindow() throws Exception {
		try {
			driver.manage().window().maximize();
			StartBrowser.childTest.pass("window maximized");
		} catch (Exception e) {
			StartBrowser.childTest.pass("can not maximize window :");
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			StartBrowser.childTest.info(e);
			throw e;
		}
	}

	 
	public void WindowHandle() {
		try {
			String wh=driver.getWindowHandle();
			StartBrowser.childTest.pass("Window Handle :" +wh);
		
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			
		} catch (Exception e) {
			StartBrowser.childTest.fail("can not handle Window ");
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			StartBrowser.childTest.info(e);
			throw e;
			
		}
	}
	public void WindowHandles() {
		try {
			Set<String> wh=driver.getWindowHandles();
			StartBrowser.childTest.pass("Window handles :"
			
					+wh);
		
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			
		} catch (Exception e) {
			StartBrowser.childTest.fail("can not handle Window ");
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			StartBrowser.childTest.info(e);
			throw e;
			
		}
	}
	
	public void getSize() {
		try {
		Dimension winSize=driver.manage().window().getSize();
				StartBrowser.childTest.pass("***Full Size Values for Current Window***\n");
				StartBrowser.childTest.pass("Screen Width: " + winSize.getWidth() + "\n");
				StartBrowser.childTest.pass("Screen Height: " + winSize.getHeight() + "\n");
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			
		} catch (Exception e) {
			StartBrowser.childTest.fail("can not get Window Size");
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			StartBrowser.childTest.info(e);
			throw e;
			
		}
	}
	
	public void setSize(Dimension a) {
		try {
			driver.manage().window().setSize(a);
				StartBrowser.childTest.pass("Size set");
				
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			
		} catch (Exception e) {
			StartBrowser.childTest.fail("can not set Window Size ");
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			StartBrowser.childTest.info(e);
			throw e;
			
		}
	}
	public void getPosition() {
		try {
		Point winPos=driver.manage().window().getPosition();
				StartBrowser.childTest.pass("***Full Size Values for Current Window***\n");
				StartBrowser.childTest.pass("X cordinate: " + winPos.getX() + "\n");
				StartBrowser.childTest.pass("Y cordinate: " + winPos.getY() + "\n");
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			
		} catch (Exception e) {
			StartBrowser.childTest.fail("can not get Window Position ");
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			StartBrowser.childTest.info(e);
			throw e;
			
		}
	}
	
	public void setPosition(int x, int y ) {
		try {
			Point winPos=driver.manage().window().getPosition();
			Point NewWinPos=winPos.moveBy(x,y);
	        driver.manage().window().setPosition(NewWinPos);
				StartBrowser.childTest.pass("Position set");
				
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			
		} catch (Exception e) {
			StartBrowser.childTest.fail("can not set Window Position ");
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			StartBrowser.childTest.info(e);
			throw e;
			
		}
	}
	
	
	
	

	public String screenshot() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		
        //goto url
 
		
	}
	
	
	
	

}
