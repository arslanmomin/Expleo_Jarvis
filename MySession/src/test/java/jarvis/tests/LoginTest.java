package jarvis.tests;
import org.testng.annotations.Test;

import configs.BrowserSetup;
import jarvis.scripts.LoginLogout;
import utilities.ConfigurationSupport;


public class LoginTest extends BrowserSetup {
	
	public ConfigurationSupport cs = new ConfigurationSupport("config files//accounts.properties");


  @Test(priority=0,groups= {"regression","login"})
  public void loginTest() throws Exception {
	  LoginLogout re = new LoginLogout();
	  re.login(cs.getProperty("url"),cs.getProperty("email") , cs.getProperty("password"));

  }
 
}
