package jarvis.scripts;


import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.testng.annotations.Listeners;
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
@Listeners(utilities.Listener.class)

public class LoginLogout extends Base {
	public ConfigurationSupport cs = new ConfigurationSupport("config files//accounts.properties");
	String uname=cs.getProperty("email");
	String pwd=cs.getProperty("password");
	LoginPage lp;
	HomePage hp;

	@Test
	public void login() throws Exception {
		
		lp=new LoginPage();
		Assert.assertTrue(lp.checkTabsVisibility(List.of("APPAREL & SHOES","BOOKS","COMPUTERS","DIGITAL DOWNLOADS","ELECTRONICS","GIFT CARDS","JEWELRY")));
		lp.signin(uname,pwd);
		Log.info("signin done");

	
		
	}
	public void loginwithExcelData() throws Exception {
		Fillo f = new Fillo();
		Connection con = f.getConnection("Testdata/Data.xlsx");
		String query="select * from Login";
		Recordset rc= con.executeQuery(query);
		while(rc.next()) {
			login();
			
		}	
	}
	
	public void logout() throws Exception {
		ExtentManager.childTest = ExtentManager.parentTest.createNode("logout from application");
		hp =new HomePage();
		hp.clickonlogout();
		
	}



}
