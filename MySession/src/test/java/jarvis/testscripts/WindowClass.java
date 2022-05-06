package jarvis.testscripts;

import configs.StartBrowser;
import utilities.ConfigurationSupport;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import jarvis.objectrepo.ToolsQA;
import wdcommands.*;


public class WindowClass extends StartBrowser {
	public ConfigurationSupport cs = new ConfigurationSupport("config.properties");
	public WebDriver driver;
	public ElementsOp edriver;
	public Browser bdriver;
	public void WindowClass()
	{
		driver=StartBrowser.driver;
		edriver= new ElementsOp();
		bdriver= new Browser();
		
	}
	@Test
	public void WindowTest() throws Exception{
		StartBrowser.childTest=StartBrowser.parentTest.createNode("login to application");
		Browser b=new Browser();
		edriver= new ElementsOp();
		WindowHandling wh=new WindowHandling();
		b.openurl("https://demoqa.com/browser-windows");
		edriver.click(ToolsQA.NewWindow, "WindowButton");
		wh.SwitchToChild();
		wh.maximizeWindow();
		
		wh.SwitchBack();
		
		
		
	}
	
}
