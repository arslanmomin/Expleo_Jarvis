package jarvis.tests;

import org.testng.annotations.Test;

import configs.Base;
import jarvis.scripts.Accounts;


public class ShoppingCartTest extends Base{

	  @Test(priority=0,groups= {"accounts"})
	  public void shoppingcartTest() throws Exception { 
		  Accounts res = new Accounts();
		  res.shoppingcart();
		  res.cartHover();
	  }
	  
	  
}
