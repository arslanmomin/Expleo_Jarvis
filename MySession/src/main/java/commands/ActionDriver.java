package commands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface ActionDriver {

	public void openurl(WebDriver driver,String URL) ;
	public void back(WebDriver driver);
	public void forward(WebDriver driver);
	public void navigate(WebDriver driver);
	public void matchurl(WebDriver driver,String expected);
	public void refresh(WebDriver driver);
	
	
	public void click(WebDriver driver, WebElement ele, String eleName);
	public  void JSclick(WebDriver driver, WebElement ele, String eleName);
	
	
	public void type(WebElement ele,String testData, String eleName);
	
	
	public void mouseover(WebDriver driver, WebElement ele, String eleName);
	public void moveToElement(WebDriver driver, WebElement ele, String eleName);
	
	
	
	public void getText(WebDriver driver, WebElement ele, String eleName);
	public void verifyeleclickable(WebElement ele, String eleName);
	public void isDisplayed(WebElement ele, String eleName);
	public void isSelected(WebElement ele, String eleName);
	public void isEnabled(WebElement ele, String eleName);
	public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele, String eleName);
	
	
	public void selectByIndex(WebElement ele, int index);
	public void selectByValue(WebElement ele, String value);
	public void selectByVisibleText(WebElement ele, String VisibleText);
	public void check(WebElement ele,String eleName);
	public void uncheck(WebElement ele,String eleName);
	
	
	
	public void acceptAlert(WebDriver driver);
	public void cancelAlert(WebDriver driver);
	public void getAlertText(WebDriver driver);
	public void setAlertText(WebDriver driver,String text);
	public void verifyAlertMsg(WebDriver driver);
	
	
	
	public void SwitchToChild(WebDriver driver);
	public void SwitchBack(WebDriver driver);
	
	
	public void WindowHandle(WebDriver driver);
	public void WindowHandles(WebDriver driver);
	
	
	public void SwitchToFrameByIndex(WebDriver driver,int index);
	public void SwitchToFrameByName(WebDriver driver,String name);
	public void SwitchToFrameById(WebDriver driver,String id);
	public void SwitchToDefaultContent(WebDriver driver);
	public void SwitchToParentFrame(WebDriver driver);

}
