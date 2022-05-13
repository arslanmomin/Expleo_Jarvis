package commands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface ActionDriver {

	public void openUrl(WebDriver driver,String url) ;
	public void PreviousPage(WebDriver driver);
	public void forwardPage(WebDriver driver);
	public void navigateToUrl(WebDriver driver);
	public boolean matchUrl(WebDriver driver,String expected);
	public void refreshPage(WebDriver driver);
	public void pageLoadTimeOut(WebDriver driver, int timeOut);
	
	public String getCurrentTime();
	
	public boolean click(WebDriver driver, WebElement ele, String eleName);
	public  boolean JSclick(WebDriver driver, WebElement ele, String eleName);
	
	
	public boolean setText(WebElement ele,String testData, String eleName);
	
	
	public void mouseOver(WebDriver driver, WebElement ele, String eleName);
	public void moveToElement(WebDriver driver, WebElement ele, String eleName);
	
	
	
	public String getText(WebDriver driver, WebElement ele, String eleName);
	public boolean verifyEleClickable(WebElement ele, String eleName);
	public boolean isDisplayed(WebElement ele, String eleName);
	public boolean isSelected(WebElement ele, String eleName);
	public boolean isEnabled(WebElement ele, String eleName);
	public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele, String eleName);
	
	
	public void selectByIndex(WebElement ele, int index);
	public void selectByValue(WebElement ele, String value);
	public void selectByVisibleText(WebElement ele, String VisibleText);
	public boolean check(WebElement ele,String eleName);
	public boolean uncheck(WebElement ele,String eleName);
	
	
	
	public boolean acceptAlert(WebDriver driver);
	public boolean cancelAlert(WebDriver driver);
	public String getAlertText(WebDriver driver);
	public boolean setAlertText(WebDriver driver,String text);
	public boolean verifyAlertMsg(WebDriver driver);
	
	
	
	public boolean SwitchToChild(WebDriver driver);
	public boolean SwitchBack(WebDriver driver);
	
	
	public void WindowHandle(WebDriver driver);
	public void WindowHandles(WebDriver driver);
	
	
	public boolean SwitchToFrameByIndex(WebDriver driver,int index);
	public boolean SwitchToFrameByName(WebDriver driver,String name);
	public boolean SwitchToFrameById(WebDriver driver,String id);
	public void SwitchToDefaultContent(WebDriver driver);
	public void SwitchToParentFrame(WebDriver driver);

	public boolean verifySymbol(WebDriver driver,WebElement ele);
	public boolean verifyDownload(WebDriver driver , WebElement ele);
	public String replace(WebDriver driver);
	public int countOfWebElement(WebDriver driver);
	public String trim(WebDriver driver, String str);
	public boolean subString(WebDriver driver,String str1,String str2);




	public void implicitWait(WebDriver driver);
	public void explicitWait(WebDriver driver, WebDriverWait wait);
	public void fluentWait(WebDriver driver);


	public void cookiesHandling(WebDriver driver);
	public void cacheHandling(WebDriver driver);

}
