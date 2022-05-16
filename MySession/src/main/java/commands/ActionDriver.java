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
	public String getWindowTitle(WebDriver driver);
	public String getUrl(WebDriver driver);
	public String closeBrowser(WebDriver driver);
	public String quitBrowser(WebDriver driver);
	
	public String getCurrentTime();
	
	public void click(WebDriver driver, WebElement ele, String eleName);
	public  void JSclick(WebDriver driver, WebElement ele, String eleName);
	
	
	public void setText(WebElement ele,String testData, String eleName);
	public boolean verifyElementText(WebElement ele,String testData);
	public String getText(WebDriver driver, WebElement ele, String eleName);
	
	public void mouseOver(WebDriver driver, WebElement ele, String eleName);
	public void moveToElement(WebDriver driver, WebElement ele, String eleName);
	public int elementsCount(WebDriver driver, WebElement ele);
	public String getAttribute(WebDriver driver, WebElement ele,String Attributename, String eleName);
	public int columnsCount(WebElement ele);
	public void uploadFile(WebDriver driver, WebElement ele,String FilePath, String eleName);//
	
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
	
	public void acceptAlert(WebDriver driver);
	public void cancelAlert(WebDriver driver);
	public String getAlertText(WebDriver driver);
	public void setAlertText(WebDriver driver,String text);
	public boolean verifyAlertMsg(WebDriver driver);
	
	public void SwitchToChild(WebDriver driver);
	public void SwitchBack(WebDriver driver);
	
	public void WindowHandle(WebDriver driver);
	public void WindowHandles(WebDriver driver);
	
	public void SwitchToFrameByIndex(WebDriver driver,int index);
	public void SwitchToFrameByName(WebDriver driver,String name);
	public void SwitchToFrameById(WebDriver driver,String id);
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

}
