package commands;


import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.text.PDFTextStripper;
import org.testng.Assert;

import configs.Base;

public class PDFActions extends Base {


	public static void createPDF(String path) throws IOException {
		
		 PDDocument document = new PDDocument();    
	      
	      document.save(path);
	         
	      System.out.println("PDF created");  
	    
	      document.close();
       
	}
	
	
	
	
	public static void AddPageToPdf(String path,int numpage) throws IOException {
	       
	      
	      PDDocument document = new PDDocument();

	      for (int i=0; i<numpage; i++) {
	    
	         PDPage blankPage = new PDPage();

	         document.addPage( blankPage );
	      } 
	     
	      document.save(path);
	      System.out.println("PDF created");
	      
	  
	      document.close();

	   }  
	
	
	public static void removePages(String path,int pageno) throws IOException {

	      //Loading an existing document
	      File file = new File(path);
	      PDDocument document = Loader.loadPDF(file);
	       
	      //Listing the number of existing pages
	      int noOfPages= document.getNumberOfPages();
	      System.out.print(noOfPages);
	       
	      //Removing the pages
	      document.removePage(pageno);
	      
	      System.out.println("page removed");

	      //Saving the document
	      document.save(path);

	      //Closing the document
	      document.close();

	   }
	
	 public static void writeToPdf (String path) throws IOException {

	      //Loading an existing document
	      File file = new File(path);
	      PDDocument document = Loader.loadPDF(file);
	      
	      
	      PDPage page = document.getPage(1);
	      PDPageContentStream contentStream = new PDPageContentStream(document, page);
	      
	      
	      contentStream.beginText(); 
	       
	    
	     // contentStream.setFont( "", 28 );

	      //Setting the position for the line 
	      contentStream.newLineAtOffset(25, 500);

	      String text = "This is the sample document and we are adding content to it.";

	      //Adding text in the form of string 
	      contentStream.showText(text);      

	      //Ending the content stream
	      contentStream.endText();

	      System.out.println("Content added");

	      //Closing the content stream
	      contentStream.close();

	      //Saving the document
	      document.save(new File("C:/PdfBox_Examples/new.pdf"));

	      //Closing the document
	      document.close();
	   }
	 
	 public static void readPDF(String path) throws IOException {

	    
	      File file = new File(path);
	      PDDocument document = Loader.loadPDF(file);

	 
	      PDFTextStripper pdfStripper = new PDFTextStripper();

	     
	      String text = pdfStripper.getText(document);
	      System.out.println(text);

	      
	      document.close();

	   }
	 public static void readAndAssert(String path,String textToFind) throws IOException {

		    
	      File file = new File(path);
	      PDDocument document = Loader.loadPDF(file);

	 
	      PDFTextStripper pdfStripper = new PDFTextStripper();

	     
	      String Pdftext = pdfStripper.getText(document);
	      
	      Assert.assertTrue(Pdftext.contains(textToFind));
	     
	      System.out.println(Pdftext);

	      
	      document.close();

	   }
	 
	 public static void splitPdf(String path) throws IOException {

	      //Loading an existing PDF document
	      File file = new File(path);
	      PDDocument document = Loader.loadPDF(file);

	      //Instantiating Splitter class
	      Splitter splitter = new Splitter();

	      //splitting the pages of a PDF document
	      List<PDDocument> Pages = splitter.split(document);

	      //Creating an iterator 
	      Iterator<PDDocument> iterator = Pages.listIterator();

	      //Saving each page as an individual document
	      int i = 1;
	      while(iterator.hasNext()) {
	         PDDocument pd = iterator.next();
	         pd.save(System.getProperty("user.dir") + "\\TestData\\ManagePDF\\Splitted"+ i++ +".pdf");
	      }
	      System.out.println("Multiple PDF’s created");
	      document.close();
	   }


	 
	 public static void merge2pdf(String path1,String path2) throws IOException {
	      File file1 = new File(path1);       
	      File file2 = new File(path2);    
			
	      //Instantiating PDFMergerUtility class
	      PDFMergerUtility PDFmerger = new PDFMergerUtility();
			
	      //Setting the destination file
	      PDFmerger.setDestinationFileName(System.getProperty("user.dir") + "\\TestData\\ManagePDF\\Merged.pdf");
			
	      //adding the source files
	      PDFmerger.addSource(file1);
	      PDFmerger.addSource(file2);
			
	      //Merging the two documents
	      PDFmerger.mergeDocuments(null);
	      System.out.println("Documents merged");
	   }

	 
}
