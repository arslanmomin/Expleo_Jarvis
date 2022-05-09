package jarvis.testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import configs.StartBrowser;
import jarvis.application.reuse.Accounts;
import jarvis.application.reuse.LoginLogout;
import jarvis.objectrepo.HomePage;
import utilities.ConfigurationSupport;
import wdcommands.Browser;
import wdcommands.ElementsOp;

public class ShoppingCart extends StartBrowser{
	public ConfigurationSupport cs = new ConfigurationSupport("config files//accounts.properties");
	public WebDriver driver;
	public ElementsOp edriver;
	public Browser bdriver;
	
	public ShoppingCart() {
		this.driver=StartBrowser.driver;
		this.edriver= new ElementsOp(driver);
		this.bdriver= new Browser(driver);
	}
	  @Test(priority=0,groups= {"accounts"})
	  public void shoppingcartTest() throws Exception { 
		  LoginLogout re = new LoginLogout();
		  Accounts res = new Accounts();
		  re.logout();
		  re.loginwithExcelData(cs.getProperty("url"));
		  res.shoppingcart();
	  }
	  
	  @Test(priority=1,groups= {"accounts"})
	  public void cartHover() throws Exception{
		  edriver.mouseover(HomePage.shoppingcart, "shopping cart");
		  
	  }
	  
}
