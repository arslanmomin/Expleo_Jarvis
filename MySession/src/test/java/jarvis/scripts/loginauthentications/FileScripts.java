package jarvis.scripts.loginauthentications;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import configs.Base;
import jarvis.pages.PdfPage;
import utilities.ExtentManager;
@Listeners(utilities.Listener.class)


public class FileScripts extends Base{

	@Test
	public void fileScript() throws IOException {
		
		
		PdfPage p=new PdfPage();
		//p.fileCreate("C:\\Users\\momfr\\Downloads\\Hi.pdf");
		//p.AddPage("C:\\Users\\momfr\\Downloads\\Hi.pdf",8);
		//p.RemovePage("C:\\Users\\momfr\\Downloads\\Hi.pdf",3);
		//p.WriteToPdf("C:\\Users\\momfr\\Downloads\\Hi.pdf");
		//p.ReadPdf("C:\\Users\\momfr\\Downloads\\Capgemini Offer Letter 20 june 2019.pdf");
	//	p.SplitPdf("C:\\Users\\momfr\\Downloads\\Capgemini Offer Letter 20 june 2019.pdf");
		
		//p.MergePdf("C:\\Users\\momfr\\Downloads\\Splitted17.pdf", "C:\\Users\\momfr\\Downloads\\Splitted18.pdf");
		
		p.ReadAssert("C:\\Users\\momfr\\Downloads\\Capgemini Offer Letter 20 june 2019.pdf","iudboiebo");
	}
	
}
