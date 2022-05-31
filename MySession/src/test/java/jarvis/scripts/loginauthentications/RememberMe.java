package jarvis.scripts.loginauthentications;

import java.util.Set;

import org.openqa.selenium.Cookie;

import configs.Base;

public class RememberMe extends Base{

	Cookie cookie = new Cookie("userCrnList", "value");
	public void addCookie() {
		getDriver().manage().addCookie(cookie);
		
		Cookie cookieValue = getDriver().manage().getCookieNamed("userCrnList");
        System.out.println(cookieValue.getValue());
        
		Set<Cookie> cookieList = getDriver().manage().getCookies();
		for (Cookie newCookie : cookieList) {
			System.out.println(newCookie);
		}
		getDriver().manage().deleteCookieNamed("userCrnList");
		
	}
	
}
