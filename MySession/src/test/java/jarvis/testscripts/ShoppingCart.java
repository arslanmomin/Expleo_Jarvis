package jarvis.testscripts;

import org.testng.annotations.Test;

import configs.StartBrowser;
import jarvis.application.reuse.LoginLogout;
import utilities.ConfigurationSupport;

public class ShoppingCart extends StartBrowser{
	public ConfigurationSupport cs = new ConfigurationSupport("config.properties");
	  @Test(priority=1)
	  public void shoppingcartTest() throws Exception { 
		  LoginLogout re = new LoginLogout();
		  re.logout();
		  re.loginwithExcelData(cs.getProperty("url"));
		  re.shoppingcart();
	  }
	  
}
