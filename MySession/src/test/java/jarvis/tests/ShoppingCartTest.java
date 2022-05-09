package jarvis.tests;

import org.testng.annotations.Test;

import configs.BrowserSetup;
import jarvis.scripts.Accounts;
import utilities.ConfigurationSupport;

public class ShoppingCartTest extends BrowserSetup{
	public ConfigurationSupport cs = new ConfigurationSupport("config files//accounts.properties");


	  @Test(priority=0,groups= {"accounts"})
	  public void shoppingcartTest() throws Exception { 
		  Accounts res = new Accounts();
		  res.shoppingcart();
		  res.cartHover();
	  }
	  
	  
}
