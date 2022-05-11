package jarvis.objects;


import org.openqa.selenium.WebElement;
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

	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void clickonsignin() throws Exception {
		ElementsOp.click(getDriver(), signinbtn,"signinbtn");
	}
	
	public void setEmail() {
		ElementsOp.type( emailbox, cs.getProperty("email"),"email text box");
	}

	public void setPassword() {
		ElementsOp.type( passwordbox, cs.getProperty("password"),"password text box");
	}
	
	public void clickonlogin() throws Exception {
		ElementsOp.click(getDriver(), loginbtn,"login button");
	}

}
