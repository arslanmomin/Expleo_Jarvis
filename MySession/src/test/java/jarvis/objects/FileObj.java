package jarvis.objects;


import org.openqa.selenium.support.PageFactory;

import commands.FilesOperation;
import configs.Base;

public class FileObj extends Base{


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
