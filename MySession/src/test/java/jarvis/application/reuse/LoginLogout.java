package jarvis.application.reuse;


import org.openqa.selenium.WebDriver;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import configs.StartBrowser;
import jarvis.objectrepo.HomePage;
import jarvis.objectrepo.LoginPage;
import utilities.ConfigurationSupport;
import wdcommands.Browser;
import wdcommands.ElementsOp;
import wdcommands.WindowHandling;

public class LoginLogout {
	public ConfigurationSupport cs = new ConfigurationSupport("config.properties");
	public WebDriver driver;
	public ElementsOp edriver;
	public Browser bdriver;
	public WindowHandling wdriver;
	
	public LoginLogout() {
		driver=StartBrowser.driver;
		edriver= new ElementsOp();
		bdriver= new Browser();
		edriver= new ElementsOp();
		wdriver= new WindowHandling();
		
	}
	
	public void login(String url,String email, String password) throws Exception {
		StartBrowser.childTest=StartBrowser.parentTest.createNode("login to application");
		bdriver.openurl(url);
		edriver.click(LoginPage.loginlink, "login link");
		edriver.type(LoginPage.Emailtextbox, email, "username");
		edriver.type(LoginPage.passwordtextbox, password, "password");
		edriver.click(LoginPage.LoginButton, "LoginButton");
		wdriver.maximizeWindow();
		wdriver.WindowSize();
		
		
	}
	public void loginwithExcelData(String url) throws Exception {
		Fillo f = new Fillo();
		Connection con = f.getConnection("Testdata/Data.xlsx");
		String query="select * from Login";
		Recordset rc= con.executeQuery(query);
		while(rc.next()) {
			login(url,rc.getField("Email"),rc.getField("password"));
			
		}	
	}
	public void logout() throws Exception {
		StartBrowser.childTest = StartBrowser.parentTest.createNode("logout from application");
		edriver.click(HomePage.logoutbtn, "logout button");
	}
	public void shoppingcart() throws Exception {
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Shopping cart");
		  edriver.verifyeleclickable(HomePage.shoppingcart, "cart");
		  edriver.click(HomePage.shoppingcart, "Shopping cart");
		  bdriver.matchurl( cs.getProperty("shoppingcarturl"));
	  }


}
