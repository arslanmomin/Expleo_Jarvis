package jarvis.tests;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commands.FilesOperation;
import configs.Base;
import jarvis.dataproviders.DataProvider;
import jarvis.scripts.FileScripts;
import jarvis.scripts.LoginLogout;
import utilities.ExtentManager;

@Listeners(utilities.Listener.class)
public class NewTest extends Base {

  @Test
  public void FileTest() throws Exception {
	  FileScripts fs= new FileScripts();
	fs.fileScript("C:\\Users\\momfr\\Downloads\\ThisFile.doc");
	  
		
  }
 
}
