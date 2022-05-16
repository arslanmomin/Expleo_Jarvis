package jarvis.pages;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commands.ElementActions;
import configs.Base;
import utilities.ConfigurationSupport;

public class LoginPage extends Base{

	public ConfigurationSupport cs = new ConfigurationSupport("config files//accounts.properties");
	@FindBy(className="ico-login")
	private WebElement signinbtn;
	
	@FindBy(id="Email")
	private WebElement emailbox;
	
	@FindBy(id="Password")
	private WebElement passwordbox;
	
	@FindBy(xpath="//input[@value='Log in']")
	private WebElement loginbtn;
	
	//syntax for list
	@FindAll({@FindBy(xpath = "yourpath")})
	public List<WebElement> networks;
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void clickonsignin() throws Exception {
		ElementActions.click(getDriver(), signinbtn,"signinbtn");
	}
	
	public void setEmail(String email) {
		ElementActions.type( emailbox, email,"email text box");
	}

	public void setPassword(String password) {
		ElementActions.type( passwordbox, password,"password text box");
	}
	
	public void clickonlogin() throws Exception {
		ElementActions.click(getDriver(), loginbtn,"login button");
	}

}
