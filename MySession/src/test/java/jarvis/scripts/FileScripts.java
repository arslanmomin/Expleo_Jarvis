package jarvis.scripts;

import org.testng.annotations.Test;

import configs.Base;
import jarvis.pages.FileObj;
import utilities.ExtentManager;

public class FileScripts extends Base{

	@Test
	public void fileScript(String path) {
		ExtentManager.childTest=ExtentManager.parentTest.createNode("File operations");
		FileObj fo=new FileObj();
	//fo.fileCreate(path);
		fo.fileDelete(path);
		
		
	}
	
}
