package jarvis.scripts;


import org.testng.annotations.Test;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import configs.Base;
import jarvis.dataproviders.DataProvider;
import jarvis.pages.HomePage;
import jarvis.pages.LoginPage;
import utilities.ConfigurationSupport;
import utilities.ExtentManager;
import utilities.Log;

public class LoginLogout extends Base {
	public ConfigurationSupport cs = new ConfigurationSupport("config files//accounts.properties");
	LoginPage lp;
	HomePage hp;
	
	@Test(priority=0,groups= {"regression","login"},dataProvider="credentials",dataProviderClass=DataProvider.class)
	public void login(String uname, String pwd) throws Exception {
		ExtentManager.childTest=ExtentManager.parentTest.createNode("login to application");
		lp=new LoginPage();
		lp.clickonsignin();
		Log.info("clicked on signin button");
		lp.setEmail(uname);
		lp.setPassword(pwd);
		lp.clickonlogin();
	
		
	}
	public void loginwithExcelData(String uname,String pw) throws Exception {
		Fillo f = new Fillo();
		Connection con = f.getConnection("Testdata/Data.xlsx");
		String query="select * from Login";
		Recordset rc= con.executeQuery(query);
		while(rc.next()) {
			login(uname,pw);
			
		}	
	}
	@Test
	public void logout() throws Exception {
		ExtentManager.childTest = ExtentManager.parentTest.createNode("logout from application");
		hp =new HomePage();
		hp.clickonlogout();
		
	}



}
