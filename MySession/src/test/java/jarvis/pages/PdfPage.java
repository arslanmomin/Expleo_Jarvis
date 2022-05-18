package jarvis.pages;


import java.io.IOException;

import org.openqa.selenium.support.PageFactory;

import commands.PDFActions;
import configs.Base;
import utilities.ExtentManager;

public class PdfPage extends Base{
	


	public PdfPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public void fileCreate(String path) throws IOException {
		ExtentManager.childTest = ExtentManager.parentTest.createNode("File Created");
		PDFActions.createPDF(path);
	}
	public void AddPage(String path, int num) throws IOException {
		ExtentManager.childTest = ExtentManager.parentTest.createNode("Page Added");
		PDFActions.AddPageToPdf(path, 5);

	}
	public void RemovePage(String path, int num) throws IOException {
		ExtentManager.childTest = ExtentManager.parentTest.createNode("Page Added");
		PDFActions.removePages(path, 5);

	}
	public void WriteToPdf(String path) throws IOException {
		ExtentManager.childTest = ExtentManager.parentTest.createNode("Page Added");
		PDFActions.writeToPdf(path);

	}
	public void ReadPdf(String path) throws IOException {
		ExtentManager.childTest = ExtentManager.parentTest.createNode("Page Added");
		PDFActions.readPDF(path);

	}
	public void SplitPdf(String path) throws IOException {
		ExtentManager.childTest = ExtentManager.parentTest.createNode("Page Added");
		PDFActions.splitPdf(path);
	}
	public void MergePdf(String path1,String path2) throws IOException {
		ExtentManager.childTest = ExtentManager.parentTest.createNode("Page Added");
		PDFActions.merge2pdf(path1, path2);;
	}
	
	public void ReadAssert(String path,String text) throws IOException {
		ExtentManager.childTest = ExtentManager.parentTest.createNode("Page Added");
		PDFActions.readAndAssert(path,text);

	}

}
