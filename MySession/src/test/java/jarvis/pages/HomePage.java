package jarvis.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commands.ElementActions;
import configs.Base;

public class HomePage extends Base{

	@FindBy(xpath="//li[@id='topcartlink']/a/span[1]")
	private WebElement shoppingcart;
	
	@FindBy(className="ico-logout")
	private WebElement logout;
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void clickoncart() throws Exception {
		ElementActions.click(getDriver(),shoppingcart,"shoppingcart btn");
		
	}
	
	public void clickonlogout() throws Exception {
		ElementActions.click(getDriver(),logout,"logout button");
		
	}
	
	//public static By shoppingcart =By.xpath("//li[@id='topcartlink']/a/span[1]");
	//public static By logoutbtn = By.className("ico-logout");
	
}
