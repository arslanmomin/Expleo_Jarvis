package jarvis.testscripts;
import org.testng.annotations.Test;

import common.reuse.*;
import configs.StartBrowser;
import common.reuse.*;
import utilities.ConfigurationSupport;
public class BrokenScript {
	
	public class BLinkTest extends StartBrowser {
		public ConfigurationSupport cs = new ConfigurationSupport("config.properties");
	  @Test
	  public void loginintoApplication() throws Exception {
		  BrokenLinks re= new BrokenLinks();
		  re.BrokenTest(cs.getProperty("url"));
	

	  }
	}
}