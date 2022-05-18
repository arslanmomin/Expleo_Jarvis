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

}
