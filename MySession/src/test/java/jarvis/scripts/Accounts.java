package jarvis.scripts;

import org.openqa.selenium.WebDriver;

import commands.Browser;
import commands.ElementsOp;
import configs.BrowserSetup;
import jarvis.objects.HomePage;
import utilities.ConfigurationSupport;

public class Accounts {
	public ConfigurationSupport cs = new ConfigurationSupport("config files//accounts.properties");
	public WebDriver driver;
	public ElementsOp edriver;
	public Browser bdriver;
	
	public Accounts() {
		driver=BrowserSetup.driver;
		edriver= new ElementsOp(driver);
		bdriver= new Browser(driver);
	}

	public void shoppingcart() throws Exception {
		BrowserSetup.childTest = BrowserSetup.parentTest.createNode("Shopping cart");
		  edriver.verifyeleclickable(HomePage.shoppingcart, "cart");
		  edriver.click(HomePage.shoppingcart, "Shopping cart");
		  bdriver.matchurl( cs.getProperty("shoppingcarturl"));
	  }
	public void cartHover() throws Exception {
		edriver.mouseover(HomePage.shoppingcart, "cart");
	}
}
