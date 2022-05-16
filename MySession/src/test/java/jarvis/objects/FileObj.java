package jarvis.objects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commands.FilesOperation;
import configs.Base;
import utilities.ConfigurationSupport;

public class FileObj extends Base{

	public ConfigurationSupport cs = new ConfigurationSupport("config files//accounts.properties");
	

	public FileObj() {
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public void fileCreate(String path) {
		FilesOperation.Create_File( getDriver(), path);
	}
	public void fileDelete(String path) {
		FilesOperation.Delete_File( getDriver(), path);
	}

	

}
