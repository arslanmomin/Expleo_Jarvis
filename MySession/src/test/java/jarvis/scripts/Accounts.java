package jarvis.scripts;

import configs.Base;
import utilities.ExtentManager;
import org.testng.TestNG;
import org.testng.annotations.Test;

public class Accounts {

	@Test
	public void shoppingcart() throws Exception {
		ExtentManager.childTest = ExtentManager.parentTest.createNode("Shopping cart");

	  }
	public void cartHover() throws Exception {
		
	}
}
