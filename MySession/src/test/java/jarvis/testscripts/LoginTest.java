package jarvis.testscripts;
import org.testng.annotations.Test;

import configs.StartBrowser;
import jarvis.application.reuse.LoginLogout;
import utilities.ConfigurationSupport;

public class LoginTest extends StartBrowser {
	public ConfigurationSupport cs = new ConfigurationSupport("config.properties");
  @Test
  public void loginintoApplication() throws Exception {
	  LoginLogout re= new LoginLogout();
	  re.login(cs.getProperty("url"),cs.getProperty("email") , cs.getProperty("password"));
	  //re.loginwithExcelData(cs.getProperty("url"));

  }
  
 
}
