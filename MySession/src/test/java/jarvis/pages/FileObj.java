package jarvis.pages;


import org.openqa.selenium.support.PageFactory;

import commands.FilesActions;
import configs.Base;

public class FileObj extends Base{


	public FileObj() {
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public void fileCreate(String path) {
		FilesActions.Create_File( getDriver(), path);
	}
	public void fileDelete(String path) {
		FilesActions.Delete_File( getDriver(), path);
	}

	

}
