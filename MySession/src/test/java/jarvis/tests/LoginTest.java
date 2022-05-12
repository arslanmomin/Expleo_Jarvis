package jarvis.tests;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import configs.Base;
import jarvis.dataproviders.DataProvider;
import jarvis.scripts.LoginLogout;

@Listeners(utilities.Listener.class)
public class LoginTest extends Base {

  @Test(priority=0,groups= {"regression","login"},dataProvider="credentials",dataProviderClass=DataProvider.class)
  public void loginTest(String name, String pw) throws Exception {
	  LoginLogout re = new LoginLogout();
	  re.login(name,pw);

  }
 
}
