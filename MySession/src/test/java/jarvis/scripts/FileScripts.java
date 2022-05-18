package jarvis.scripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import configs.Base;
import jarvis.pages.FileObj;
import utilities.ExtentManager;
@Listeners(utilities.Listener.class)


public class FileScripts extends Base{

	@Test
	public void fileScript() {
		
		FileObj fo=new FileObj();
	fo.fileCreate("C:\\Users\\momfr\\Downloads\\Hi.doc");
		//fo.fileDelete(path);
		
		
	}
	
}
