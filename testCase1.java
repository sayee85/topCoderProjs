package seleniumProject1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class testCase1 {
	
	private static String cssButton;
	
		public String firstCol;
	    public String secondCol;
	    public String thirdCol;
	    public static String browser;
	    public static String url;
	    public static String searchs;
	    public static String toclick;
	    public int page_number;
	    public boolean found;


		public void readExcel(String filePath,String fileName,String sheetName) throws IOException {

	    //Create an object of File class to open xlsx file
	    File file = new File(filePath+"//"+fileName);
	    	//File file = new File("/Users/SayeeganeshS/eclipse-workspace/browerLaunch/SeleniumProj1.xlsx");
	    //Create an object of FileInputStream class to read excel file
	    FileInputStream inputStream = new FileInputStream(file);

	    Workbook myWorkbook = null;

	    //Find the file extension by splitting file name in substring  and getting only extension name
	    String fileExtensionName = fileName.substring(fileName.indexOf("."));

	    //Check condition if the file is xlsx file
	    if(fileExtensionName.equals(".xlsx")){

	    //If it is xlsx file then create object of XSSFWorkbook class
	    myWorkbook = new XSSFWorkbook(inputStream);

	    }

	    //Check condition if the file is xls file
	    else if(fileExtensionName.equals(".xls")){

	        //If it is xls file then create object of XSSFWorkbook class
	        myWorkbook = new HSSFWorkbook(inputStream);

	    }

	    //Read sheet inside the workbook by its name
	    Sheet mySheet = myWorkbook.getSheet(sheetName);

	    //Assign first column to a string variable
	    firstCol = mySheet.getRow(0).getCell(0).getStringCellValue();
	    
	    //parsing the values further down to determine browser and the URL to be launched
	    String[] sp1 = firstCol.split(":", 3);
	    browser = sp1[1];
	    url = sp1[2];

	    secondCol = mySheet.getRow(1).getCell(0).getStringCellValue();

	    String[] sp2 = secondCol.split(":", 2);
	    searchs = sp2[1];
	    
	    thirdCol = mySheet.getRow(2).getCell(0).getStringCellValue();
	    System.out.println(thirdCol);
	    String[] sp3 = thirdCol.split(":", 2);
	    toclick = sp3[1];
	    System.out.println("toclick text is:"+toclick);

	    }
		
	public void browserLaunch(String b,String u,String s, String c) {

		if (b.equals("Chrome") ) {
			//System.out.println("Inside if loop...");
			WebDriver driver = null;
			driver = new ChromeDriver();
		
			WebDriverWait wait = new WebDriverWait(driver, 10);
			//launching the google website
			driver.get(url);
		
			//finding the search element
			String cssInputField = "input[name='q']";
		
			WebElement InputField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssInputField)));
		
			//Key-in the search text
			InputField.sendKeys(searchs);
		
			//finding the button element		
			cssButton = "input[name='btnK']";
		
			WebElement googleSearch = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssButton)));
			googleSearch.click();
			
		    found = false;
            page_number = 1;
            
            List<WebElement> linkText = new ArrayList<WebElement>();
            ListIterator<WebElement> itr = null;
            
            WebElement toClick = null;
            
            while (!found) {
            	
            	linkText = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h3[@class='r']/a")));
			
            	itr = linkText.listIterator();
			while (itr.hasNext()){
				toClick = itr.next();
			   if(toClick.getAttribute("innerHTML").contains(toclick)) {  
			   toClick.click();
			    found = true;
			    break;
			   }
			}
            		if(!found) {
            			driver.findElement(By.xpath("//a[@id='pnnext']/span[1]")).click();
            			page_number++;
            			linkText.clear();
            	        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//td[@class='cur']"), page_number + ""));
            		}
            	}
            
            }
		
		else if (b.equals("Firefox") ) {
			//System.out.println("Inside if loop...");
			WebDriver driver = null;
			driver = new FirefoxDriver();
		
			WebDriverWait wait = new WebDriverWait(driver, 10);
			//launching the google website
			driver.get(url);
		
			//finding the search element
			String cssInputField = "input[name='q']";
		
			WebElement InputField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssInputField)));
		
			//Key-in the search text
			InputField.sendKeys(searchs);
		
			//finding the button element		
			cssButton = "input[name='btnK']";
		
			WebElement googleSearch = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssButton)));
			googleSearch.click();
			
		    found = false;
            page_number = 1;
            
            List<WebElement> linkText = new ArrayList<WebElement>();
            ListIterator<WebElement> itr = null;
            
            WebElement toClick = null;
            
            while (!found) {
            	
            	linkText = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h3[@class='r']/a")));
			
            	itr = linkText.listIterator();
			while (itr.hasNext()){
				toClick = itr.next();
			   if(toClick.getAttribute("innerHTML").contains(toclick)) {  
			   toClick.click();
			    found = true;
			    break;
			   }
			}
            		if(!found) {
            			driver.findElement(By.xpath("//a[@id='pnnext']/span[1]")).click();
            			page_number++;
            			linkText.clear();
            	        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//td[@class='cur']"), page_number + ""));
            		}
            	}
            
            }
		
		else if (b.equals("Safari") ) {
			//System.out.println("Inside if loop...");
			WebDriver driver = null;
			driver = new SafariDriver();
		
			WebDriverWait wait = new WebDriverWait(driver, 10);
			//launching the google website
			driver.get(url);
		
			//finding the search element
			String cssInputField = "input[name='q']";
		
			WebElement InputField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssInputField)));
		
			//Key-in the search text
			InputField.sendKeys(searchs);
		
			//finding the button element		
			cssButton = "input[name='btnK']";
		
			WebElement googleSearch = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssButton)));
			googleSearch.click();
			
		    found = false;
            page_number = 1;
            
            List<WebElement> linkText = new ArrayList<WebElement>();
            ListIterator<WebElement> itr = null;
            
            WebElement toClick = null;
            
            while (!found) {
            	
            	linkText = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h3[@class='r']/a")));
			
            	itr = linkText.listIterator();
			while (itr.hasNext()){
				toClick = itr.next();
			   if(toClick.getAttribute("innerHTML").contains(toclick)) {  
			   toClick.click();
			    found = true;
			    break;
			   }
			}
            		if(!found) {
            			driver.findElement(By.xpath("//a[@id='pnnext']/span[1]")).click();
            			page_number++;
            			linkText.clear();
            	        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//td[@class='cur']"), page_number + ""));
            		}
            	}
            
            }
		
		else if (b.equals("IE") ) {
			//System.out.println("Inside if loop...");
			WebDriver driver = null;
			driver = new InternetExplorerDriver();
		
			WebDriverWait wait = new WebDriverWait(driver, 10);
			//launching the google website
			driver.get(url);
		
			//finding the search element
			String cssInputField = "input[name='q']";
		
			WebElement InputField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssInputField)));
		
			//Key-in the search text
			InputField.sendKeys(searchs);
		
			//finding the button element		
			cssButton = "input[name='btnK']";
		
			WebElement googleSearch = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssButton)));
			googleSearch.click();
			
		    found = false;
            page_number = 1;
            
            List<WebElement> linkText = new ArrayList<WebElement>();
            ListIterator<WebElement> itr = null;
            
            WebElement toClick = null;
            
            while (!found) {
            	
            	linkText = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h3[@class='r']/a")));
			
            	itr = linkText.listIterator();
			while (itr.hasNext()){
				toClick = itr.next();
			   if(toClick.getAttribute("innerHTML").contains(toclick)) {  
			   toClick.click();
			    found = true;
			    break;
			   }
			}
            		if(!found) {
            			driver.findElement(By.xpath("//a[@id='pnnext']/span[1]")).click();
            			page_number++;
            			linkText.clear();
            	        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//td[@class='cur']"), page_number + ""));
            		}
            	}
            
            }


	}

	public static void main(String[] args) throws IOException {

	    //Create an object of testCase1 class
		testCase1 objExcelFile = new testCase1();
		testCase1 objBrowserLaunch = new testCase1();

	    //Prepare the path of excel file
	    String filePath = System.getProperty("user.dir");

	    //Call read file method of the class to read data
	    objExcelFile.readExcel(filePath,"SeleniumProj1.xlsx","Assignment");
	    System.out.println("Going to call browserLaunch....");
	    
	    //Call browser launch method of the class to launch a browser
	    objBrowserLaunch.browserLaunch(browser,url,searchs,toclick);

	}

}
