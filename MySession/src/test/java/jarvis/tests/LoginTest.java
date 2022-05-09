package jarvis.tests;
import org.testng.annotations.Test;

import configs.Base;
import jarvis.scripts.LoginLogout;


public class LoginTest extends Base {
	



  @Test(priority=0,groups= {"regression","login"})
  public void loginTest() throws Exception {
	  LoginLogout re = new LoginLogout();
	  re.login();

  }
 
}
