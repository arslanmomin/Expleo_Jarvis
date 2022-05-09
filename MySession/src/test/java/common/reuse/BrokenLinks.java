package common.reuse;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import configs.StartBrowser;
import wdcommands.Browser;
import wdcommands.ElementsOp;

public class BrokenLinks extends StartBrowser {

	public WebDriver driver;
	public ElementsOp edriver;
	public Browser bdriver;

	public BrokenLinks() {
		driver = StartBrowser.driver;
		edriver = new ElementsOp(driver);
		bdriver = new Browser(driver);

	}

	public void BrokenTest(String WebUrl) throws InterruptedException {

		StartBrowser.childTest = StartBrowser.parentTest.createNode("Broken links");
		bdriver.openurl(WebUrl);

		List<WebElement> links = driver.findElements(By.tagName("a"));

		System.out.println("Total links are " + links.size());

		for (int i = 0; i < links.size(); i++) {
			WebElement element = links.get(i);
			String url = element.getAttribute("href");
			verifyLink(url);
		}
	}

	public static void verifyLink(String urlLink) {
       
        try {

URL link = new URL(urlLink);

HttpURLConnection httpConn =(HttpURLConnection)link.openConnection();

httpConn.setConnectTimeout(2000);

httpConn.connect();
if(httpConn.getResponseCode()== 200) {
System.out.println(urlLink+" - "+httpConn.getResponseMessage());
}
if(httpConn.getResponseCode()== 404) {
System.out.println(urlLink+" - "+httpConn.getResponseMessage());
}
}

catch (Exception e) {

}
    }
}