package commands;

import java.awt.Desktop;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Iterator;
import java.util.List;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import configs.Base;
import utilities.ExtentManager;
import utilities.Log;

public class FilesActions extends Base {

	// first check if Desktop is supported by Platform or not


	public static void openFile(WebDriver driver,String FilePath) throws IOException {


		File file = new File(FilePath);
		if (!Desktop.isDesktopSupported()) {
			try {
				ExtentManager.childTest.info("Desktop is not supported");
			} catch (Exception e) {
				// TODOExtentManager.childTest.info("Desktop is not supported");Manager.childTest.pass("File Opened Sucessfully \r");
		}
	}

			ExtentManager.childTest.pass("File Opened Sucessfully \r") ;

	}

	// Custom keyword for deleting file - provide file path as a parameter

	



	// Custom method for deleting file - provide file path as a parameter


	public static void deleteFile(WebDriver driver, String FilePath) {

		try {
			Files.deleteIfExists(Paths.get(FilePath));
		}

		catch (NoSuchFileException e)

		{
			ExtentManager.childTest.info("No such File/Directory Exists");
		}

		catch (DirectoryNotEmptyException e)

		{
			ExtentManager.childTest.info("Directory is not Empty.");
		}

		catch (IOException e)

		{
			ExtentManager.childTest.info("Invalid Permissions.");
		}

		ExtentManager.childTest.pass("File Deletion is Successful.");

	}




	public static void createFile(WebDriver driver,String FilePath) {


		try {
			File myObj = new File(FilePath);
			if (myObj.createNewFile()) {
				ExtentManager.childTest.pass("File created: " + myObj.getName());
			} else {
				ExtentManager.childTest.info("File already exists.");
			}
		} catch (IOException e) {
			ExtentManager.childTest.info("An error occurred.");
			Log.exception("can't create file due to exception : ", e);
		}

	}

	// check


	public void writeToFile(WebDriver driver,String text, String filepath)
	{
		// Input custom string


		// Path of the file where data is to be copied
		Path path = (Path)Paths.get(filepath);

		System.out.println("Path of target file: "+ path.toString());

		// Byte stream whose data is to be copied

		System.out.println("Path of target file: " + path.toString());

		InputStream inp = new ByteArrayInputStream(text.getBytes());

		try {

			ExtentManager.childTest
					.info("Number of bytes copied: " + Files.copy(inp, path, StandardCopyOption.REPLACE_EXISTING));
		}

		catch (IOException e) {
			Log.exception("can't copy file due to exception : ", e);
		}
	}

	public void CopyFile(WebDriver driver, String fipath, String fopath) throws IOException {

		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {

			fis = new FileInputStream(fipath);
			fos = new FileOutputStream(fopath);

			int c;

			while ((c = fis.read()) != -1) {

				fos.write(c);
			}

			ExtentManager.childTest.info("copied the file successfully");
		}

		finally {

			if (fis != null) {

				fis.close();
			}
			if (fos != null) {

				fos.close();
			}
		}
	}
	
	//PDF Methods ahead
	
	public static void createPDF(String path) throws IOException {
		
		 PDDocument document = new PDDocument();    
	      
	      document.save(path);
	         
	      ExtentManager.childTest.pass("PDF created");  
	    
	      document.close();
      
	}
	
	
	
	
	public static void AddPageToPdf(String path,int numpage) throws IOException {
	       
	      
	      PDDocument document = new PDDocument();

	      for (int i=0; i<numpage; i++) {
	    
	         PDPage blankPage = new PDPage();

	         document.addPage( blankPage );
	      } 
	     
	      document.save(path);
	      ExtentManager.childTest.pass(" Page Added And PDF created");
	      
	  
	      document.close();

	   }  
	
	//Not Working 
	
	public static void removePages(String path,int pageno) throws IOException {

	      //Loading an existing document
	      File file = new File(path);
	      PDDocument document = Loader.loadPDF(file);
	       
	      //Listing the number of existing pages
	      int noOfPages= document.getNumberOfPages();
	      ExtentManager.childTest.pass("No Of Pages: "+noOfPages);
	       
	      //Removing the pages
	      document.removePage(pageno);
	      
	      ExtentManager.childTest.pass("page removed");

	      //Saving the document
	      document.save(path);

	      //Closing the document
	      document.close();

	   }
	
	 public static void writeToPdf (String path,String text) throws IOException {

	      //Loading an existing document
	      File file = new File(path);
	      PDDocument document = Loader.loadPDF(file);
	      
	      
	      PDPage page = document.getPage(1);
	      PDPageContentStream contentStream = new PDPageContentStream(document, page);
	      
	      
	      contentStream.beginText(); 
	       
	    //Here is The Issue
	  //  contentStream.setFont( PDType1Font.TIMES_ROMAN, 28 );

	      
	      contentStream.newLineAtOffset(25, 500);

	   

	 
	      contentStream.showText(text);      
	      
	      contentStream.endText();

	      ExtentManager.childTest.pass("Content added");

	      contentStream.close();

	      document.save(new File("user.dir") + "\\TestData\\ManagePDF\\New.pdf");

	      document.close();
	   }
	 
	 public static void readPDF(String path) throws IOException {

	    
	      File file = new File(path);
	      PDDocument document = Loader.loadPDF(file);

	 
	      PDFTextStripper pdfStripper = new PDFTextStripper();

	     int pagecount =document.getPages().getCount();
	     ExtentManager.childTest.info("The Number Of pages In This Documents is :"+pagecount);
	      String text = pdfStripper.getText(document);
	      ExtentManager.childTest.info(text);

	      
	      document.close();

	   }
	 public static void readAndAssert(String path,String textToFind) throws IOException {

		    
	      File file = new File(path);
	      PDDocument document = Loader.loadPDF(file);

	 
	      PDFTextStripper pdfStripper = new PDFTextStripper();

	     
	      String Pdftext = pdfStripper.getText(document);
	      
	      Assert.assertTrue(Pdftext.contains(textToFind),"Documents contains text specified"); 
	      
	      
	  
	      int pagecount =document.getPages().getCount();
		     ExtentManager.childTest.info("The Number Of pages In This Documents is :"+pagecount);
	     
	      ExtentManager.childTest.info(Pdftext);

	      
	      document.close();

	   }
	 
	 public static void splitPdf(String path) throws IOException {

	      File file = new File(path);
	      PDDocument document = Loader.loadPDF(file);

	      Splitter splitter = new Splitter();

	      List<PDDocument> Pages = splitter.split(document);

	      Iterator<PDDocument> iterator = Pages.listIterator();

	      int i = 1;
	      while(iterator.hasNext()) {
	         PDDocument pd = iterator.next();
	         pd.save(System.getProperty("user.dir") + "\\TestData\\ManagePDF\\Splitted"+ i++ +".pdf");
	      }
	      ExtentManager.childTest.pass("Multiple PDF’s created");
	      document.close();
	   }


	 
	 public static void merge2pdf(String path1,String path2) throws IOException {
	      File file1 = new File(path1);       
	      File file2 = new File(path2);    
			
	      PDFMergerUtility PDFmerger = new PDFMergerUtility();

	      PDFmerger.setDestinationFileName(System.getProperty("user.dir") + "\\TestData\\ManagePDF\\Merged.pdf");

	      PDFmerger.addSource(file1);
	      PDFmerger.addSource(file2);
			
	  
	      PDFmerger.mergeDocuments(null);
	      ExtentManager.childTest.pass("Documents merged");
	   }


}
