package jarvis.scripts;

import configs.Base;
import jarvis.objects.FileObj;
import utilities.ExtentManager;

public class FileScripts extends Base{

	public void fileScript(String path) {
		ExtentManager.childTest=ExtentManager.parentTest.createNode("File operations");
		FileObj fo=new FileObj();
	//fo.fileCreate(path);
		fo.fileDelete(path);
		
		
	}
	
}
