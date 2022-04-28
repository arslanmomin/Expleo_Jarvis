package common.reuse;

import org.openqa.selenium.WebDriver;

import configs.StartBrowser;
import wdcommands.Browser;
import wdcommands.ElementsOp;



public class Reusables {
	
	public WebDriver driver;
	public ElementsOp edriver;
	public Browser bdriver;
	
	public Reusables() {
		driver=StartBrowser.driver;
		edriver= new ElementsOp();
		bdriver= new Browser();
		
	}
	

}
