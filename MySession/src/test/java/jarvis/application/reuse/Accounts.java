package jarvis.application.reuse;

import org.openqa.selenium.WebDriver;

import configs.StartBrowser;
import jarvis.objectrepo.HomePage;
import utilities.ConfigurationSupport;
import wdcommands.Browser;
import wdcommands.ElementsOp;

public class Accounts {
	public ConfigurationSupport cs = new ConfigurationSupport("config files//accounts.properties");
	public WebDriver driver;
	public ElementsOp edriver;
	public Browser bdriver;
	
	public Accounts() {
		driver=StartBrowser.driver;
		edriver= new ElementsOp(driver);
		bdriver= new Browser(driver);
	}

	public void shoppingcart() throws Exception {
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Shopping cart");
		  edriver.verifyeleclickable(HomePage.shoppingcart, "cart");
		  edriver.click(HomePage.shoppingcart, "Shopping cart");
		  bdriver.matchurl( cs.getProperty("shoppingcarturl"));
	  }
}
