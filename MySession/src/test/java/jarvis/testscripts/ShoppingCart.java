package jarvis.testscripts;

import org.testng.annotations.Test;

import configs.StartBrowser;
import jarvis.application.reuse.LoginLogout;
import utilities.ConfigurationSupport;

public class ShoppingCart extends StartBrowser{
	public ConfigurationSupport cs = new ConfigurationSupport("config files//accounts.properties");
	  @Test(priority=0,groups= {"accounts"})
	  public void shoppingcartTest() throws Exception { 
		  LoginLogout re = new LoginLogout();
		  re.logout();
		  re.loginwithExcelData(cs.getProperty("url"));
		  re.shoppingcart();
	  }
	  
}
