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
	WebElement signinbtn;
	
	@FindBy(id="Email")
	WebElement emailbox;
	
	@FindBy(id="Password")
	WebElement passwordbox;
	
	@FindBy(xpath="//input[@value='Log in']")
	WebElement loginbtn;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickonsignin() throws Exception {
		ElementsOp.click(driver, signinbtn,"signinbtn");
	}
	
	public void setEmail() {
		ElementsOp.type(driver, emailbox, cs.getProperty("email"),"email text box");
	}

	public void setPassword() {
		ElementsOp.type(driver, passwordbox, cs.getProperty("password"),"password text box");
	}
	
	public void clickonlogin() throws Exception {
		ElementsOp.click(driver, loginbtn,"login button");
	}
}
