package functionLibrary;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import com.etg.constants.utilConstants;
import com.etg.driver.Driver;

public class Utilities extends Driver{
	
	// object declaration
	 private static XSSFWorkbook ExcelWBook;
	 private static XSSFSheet ExcelWSheet;
     private static XSSFCell Cell;
	
	
	public Utilities(){
	}
	
	
	/*Initialize WebDriver*/
	
	public static WebDriver InitializeDriver(String browser) throws Exception{
		taskKill();
		WebDriver driver;
		switch (browser) {
		
		case "chrome":
			System.setProperty("webdriver.chrome.driver",utilConstants.pathChromeDriver);
			driver = new ChromeDriver();
			break;
		
		case "firefox":
			System.setProperty("webdriver.gecko.driver", utilConstants.pathgeckoDriver);
			driver = new FirefoxDriver();
			break;
			
		case "ie":
			System.setProperty("webdriver.ie.driver","");
			driver = new InternetExplorerDriver();
			break;
	
		default:
			System.setProperty("webdriver.gecko.driver",utilConstants.pathgeckoDriver);
			driver = new FirefoxDriver();
			break;
		}
				
		return driver;
	}
	
	//To enter the applcation url in the browser
	public void loadURL() throws Exception{
		driver.manage().window().maximize();
		driver.get(utilConstants.applicationURL);
	}
	
	
	//set excel file 
	 public static void setExcelFile(String Path,int sheetNum) throws Exception {
	     
		 
         FileInputStream ExcelFile = new FileInputStream(Path);
         ExcelWBook = new XSSFWorkbook(ExcelFile);
         ExcelWSheet = ExcelWBook.getSheetAt(sheetNum);
         
	 }
	
	// Getting values from cell data ( row and column number )
	public static String getCellData(int RowNum, int ColNum) throws Exception{
        
		 Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
		 String CellData = Cell.getStringCellValue();
		 return CellData;

	}
	
	public void putCellData(String filePath,int sheetNo,int RowNum, int ColNum, String Value) throws Exception{
	    
		
	       ExcelWSheet = ExcelWBook.getSheetAt(sheetNo); 
	       Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
	       Cell.setCellValue(Value);
	       FileOutputStream out = new FileOutputStream(new File(filePath));     
	       ExcelWBook.write(out);
	       out.flush();
		   out.close();
	  
    }
	
	// To get row count 
	public static int getRowCount(int sheet){
        ExcelWSheet = ExcelWBook.getSheetAt(sheet);  
        int number=ExcelWSheet.getLastRowNum()+1;
        return number;
    }
	
	// generate email with current time stamp 
	public String getEmailId() throws Exception{
		
		String emailID = "test"+timeStampGenerator()+"@gmail.com";
		
		return emailID;
		
	}
	
	public static String timeStampGenerator()	{
		
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date1 = new Date();
		String timestamp = dateFormat.format(date1);
		return timestamp;
		
	}	
	
	// closes the existing chrome browsers 
	public static void taskKill() throws Exception{
		Runtime rt = Runtime.getRuntime();
		rt.exec("taskkill /F /IM chromedriver.exe /T");
		Thread.sleep(1000);
	}
	
	// user for register test case , to save all the registered emails in Regusers sheet 
	@SuppressWarnings("static-access")
	public void  ExcelWrite(String EmailId) throws Exception {
	
		    FileInputStream file = new FileInputStream(new File(utilConstants.pathRegUsers));
		    XSSFWorkbook workbook = new XSSFWorkbook(file);

		    XSSFSheet sheet = workbook.getSheetAt(0);
		    
		    int rowsNum = sheet.getPhysicalNumberOfRows();
		    int lastrow = rowsNum+1;
	
		    sheet.createRow(lastrow);
		    XSSFRow row = sheet.getRow(rowsNum+1);
		    
		  //Save MethodName 
		    Cell cell =  row.createCell(0);
		    if (cell.getCellType() ==  CellType.BLANK){
		    	   cell.setCellType(CellType.STRING);
		    	   cell.setCellValue(EmailId);
		    	} 
		    else
		    {
		    cell.setCellValue(EmailId);
		    }
		    file.close();
		    FileOutputStream outFile =new FileOutputStream(new File(utilConstants.pathRegUsers));
		    workbook.write(outFile);
		    outFile.close();
	       }
	public  void getScreenShot(String fileName) throws IOException{
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(utilConstants.pathScreenShots+"/"+fileName+".jpg"));
	}
	}

