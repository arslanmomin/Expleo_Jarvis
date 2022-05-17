package jarvis.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commands.ElementActions;
import configs.Base;
import utilities.ConfigurationSupport;
import utilities.ExtentManager;

public class LoginPage extends Base {

	public ConfigurationSupport cs = new ConfigurationSupport("config files//accounts.properties");
	@FindBy(className = "ico-login")
	private WebElement signinbtn;

	@FindBy(id = "Email")
	private WebElement emailbox;

	@FindBy(id = "Password")
	private WebElement passwordbox;

	@FindBy(xpath = "//input[@value='Log in']")
	private WebElement loginbtn;

	@FindAll({ @FindBy(xpath = "//ul[@class='top-menu']/li") })
	private  List<WebElement> maintabs;

	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public boolean checkTabsVisibility(List<String> expected) {
		ExtentManager.childTest = ExtentManager.parentTest.createNode("check visibilty");
		boolean flag = false;
		for (WebElement ele : maintabs) {
			if (ElementActions.isDisplayed(ele, "main menu tab List element"))
				flag = true;
			if (!flag) {
				break;
			}
		}
		boolean mark = ElementActions.comapreLists(ElementActions.extractText(maintabs), expected);
		if (flag && mark)
			return true;
		else
			return false;

	}

	public void signin(String email,String password) throws Exception {
		ExtentManager.childTest = ExtentManager.parentTest.createNode("login to application");
		ElementActions.click(getDriver(), signinbtn, "signin btn");
		ElementActions.type(emailbox, email, "email text box");
		ElementActions.type(passwordbox, password, "password text box");
		ElementActions.click(getDriver(), loginbtn, "login button");
	}



}
