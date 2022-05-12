package jarvis.scripts;


import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import configs.Base;
import jarvis.objects.HomePage;
import jarvis.objects.LoginPage;
import utilities.ConfigurationSupport;
import utilities.ExtentManager;
import utilities.Log;

public class LoginLogout extends Base {
	public ConfigurationSupport cs = new ConfigurationSupport("config files//accounts.properties");
	LoginPage lp;
	HomePage hp;
	
	
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
	public void logout() throws Exception {
		ExtentManager.childTest = ExtentManager.parentTest.createNode("logout from application");
		hp =new HomePage();
		hp.clickonlogout();
		
	}



}
