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

import org.openqa.selenium.WebDriver;

import configs.Base;
import utilities.ExtentManager;

public class FilesActions extends Base {

	

	public static void openFile(WebDriver driver,String FilePath) throws IOException {

		File file = new File(FilePath);

		//first check if Desktop is supported by Platform or not

		if(!Desktop.isDesktopSupported()){

			ExtentManager.childTest.info("Desktop is not supported");

			

		}

		Desktop desktop = Desktop.getDesktop();

		if(file.exists()) {
			desktop.open(file);

			ExtentManager.childTest.pass("File Opened Sucessfully \r") ;

	}}

	// Custom keyword for deleting file - provide file path as a parameter

	

	public static void deleteFile(WebDriver driver,String FilePath) {

		File file = new File(FilePath);

		try

		{

			Files.deleteIfExists(Paths.get(FilePath));

		}

		catch(NoSuchFileException e)

		{

			ExtentManager.childTest.info("No such File/Directory Exists");

		}

		catch(DirectoryNotEmptyException e)

		{

			ExtentManager.childTest.info("Directory is not Empty.");

		}

		catch(IOException e)

		{

			ExtentManager.childTest.info("Invalid Permissions.");

		}

		ExtentManager.childTest.pass("File Deletion is Successful.");

	}



	public static void createFile(WebDriver driver,String FilePath) {
		try {
			File myObj = new File(FilePath);
			if (myObj.createNewFile()) {
				ExtentManager.childTest.info("File created: " + myObj.getName());
			} else {
				ExtentManager.childTest.info("File already exists.");
			}
		} catch (IOException e) {
			ExtentManager.childTest.info("An error occurred.");
			e.printStackTrace();
		}


	}




	public void writeToFile(WebDriver driver,String text, String filepath)
	{
		// Input custom string


		// Path of the file where data is to be copied
		Path path = (Path)Paths.get(filepath);

		System.out.println("Path of target file: "+ path.toString());

		// Byte stream whose data is to be copied
		InputStream inp = new ByteArrayInputStream(text.getBytes());

		// Try block to check for exceptions
		try {

			// Printing number of copied bytes
			ExtentManager.childTest.info("Number of bytes copied: "+ Files.copy(inp, path,StandardCopyOption.REPLACE_EXISTING));
		}

		// Catch block to handle the exceptions
		catch (IOException e) {

			// Print the line number where exception occured
			e.printStackTrace();
		}
	}


	public void CopyFiles(WebDriver driver,String fipath , String fopath)
			throws IOException
	{

		// Creating two stream
		// one input and other output
		FileInputStream fis = null;
		FileOutputStream fos = null;

		// Try block to check for exceptions
		try {

			// Initializing both the streams with
			// respective file directory on local machine

			// Custom directory path on local machine
			fis = new FileInputStream(fipath);

			// Custom directory path on local machine
			fos = new FileOutputStream(fopath);

			int c;

			// Condition check
			// Reading the input file till there is input
			// present
			while ((c = fis.read()) != -1) {

				// Writing to output file of the specified
				// directory
				fos.write(c);
			}

			// By now writing to the file has ended, so

			// Display message on the console
			ExtentManager.childTest.info("copied the file successfully");
		}

		// Optional finally keyword but is good practice to
		// empty the occupied space is recommended whenever
		// closing files,connections,streams
		finally {

			// Closing the streams

			if (fis != null) {

				// Closing the fileInputStream
				fis.close();
			}
			if (fos != null) {

				// Closing the fileOutputStream
				fos.close();
			}
		}
	}

	
}
