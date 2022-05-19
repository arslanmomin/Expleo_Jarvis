package jarvis.pages;


import java.io.IOException;

import org.openqa.selenium.support.PageFactory;

import commands.FileActions;
import configs.Base;
import utilities.ExtentManager;

public class PdfPage extends Base{
	


	public PdfPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public void fileCreate(String path) throws IOException {
		ExtentManager.childTest = ExtentManager.parentTest.createNode("File Created");
		FileActions.createPDF(path);
	}
	public void AddPage(String path, int num) throws IOException {
		ExtentManager.childTest = ExtentManager.parentTest.createNode("Page Added");
		FileActions.AddPageToPdf(path, 5);

	}
	public void RemovePage(String path, int num) throws IOException {
		ExtentManager.childTest = ExtentManager.parentTest.createNode("Page Removed");
		FileActions.removePages(path, 5);

	}
	public void WriteToPdf(String path,String text) throws IOException {
		ExtentManager.childTest = ExtentManager.parentTest.createNode("write ");
		FileActions.writeToPdf(path,text);

	}
	public void ReadPdf(String path) throws IOException {
		ExtentManager.childTest = ExtentManager.parentTest.createNode("Page Added");
		FileActions.readPDF(path);

	}
	public void SplitPdf(String path) throws IOException {
		ExtentManager.childTest = ExtentManager.parentTest.createNode("Page Added");
		FileActions.splitPdf(path);
	}
	public void MergePdf(String path1,String path2) throws IOException {
		ExtentManager.childTest = ExtentManager.parentTest.createNode("Page Added");
		FileActions.merge2pdf(path1, path2);;
	}
	
	public void ReadAssert(String path,String text) throws IOException {
		ExtentManager.childTest = ExtentManager.parentTest.createNode("Page Added");
		FileActions.readAndAssert(path,text);

	}

}
