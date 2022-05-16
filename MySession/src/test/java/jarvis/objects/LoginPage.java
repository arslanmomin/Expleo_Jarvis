package jarvis.objects;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commands.ElementsOp;
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
		ElementsOp.click(getDriver(), signinbtn,"signinbtn");
	}
	
	public void setEmail(String email) {
		ElementsOp.type( emailbox, email,"email text box");
	}

	public void setPassword(String password) {
		ElementsOp.type( passwordbox, password,"password text box");
	}
	
	public void clickonlogin() throws Exception {
		ElementsOp.click(getDriver(), loginbtn,"login button");
	}

}
