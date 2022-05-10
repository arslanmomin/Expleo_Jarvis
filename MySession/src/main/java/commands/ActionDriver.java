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
	
}
