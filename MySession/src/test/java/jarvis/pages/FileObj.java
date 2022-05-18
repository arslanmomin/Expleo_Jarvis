package jarvis.pages;


import org.openqa.selenium.support.PageFactory;

import commands.FilesActions;
import configs.Base;
import utilities.ExtentManager;

public class FileObj extends Base{
	


	public FileObj() {
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public void fileCreate(String path) {
		ExtentManager.childTest = ExtentManager.parentTest.createNode("File Created");
		FilesActions.Create_File( getDriver(), path);
	}
	public void fileDelete(String path) {
		ExtentManager.childTest = ExtentManager.parentTest.createNode("File Deleted");

		FilesActions.Delete_File( getDriver(), path);
	}

	

}
