package jarvis.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commands.ElementsOp;
import configs.Base;

public class HomePage extends Base{

	@FindBy(xpath="//li[@id='topcartlink']/a/span[1]")
	WebElement shoppingcart;
	
	@FindBy(className="ico-logout")
	WebElement logout;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickoncart() throws Exception {
		ElementsOp.click(driver,shoppingcart);
		
	}
	
	public void clickonlogout() throws Exception {
		ElementsOp.click(driver,logout);
		
	}
	
	//public static By shoppingcart =By.xpath("//li[@id='topcartlink']/a/span[1]");
	//public static By logoutbtn = By.className("ico-logout");
	
}
