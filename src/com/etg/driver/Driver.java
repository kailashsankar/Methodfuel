package com.etg.driver;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.openqa.selenium.WebDriver;
import com.etg.constants.utilConstants;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import functionLibrary.Utilities;
import functionLibrary.Waits;

public class Driver {

	public static WebDriver driver; 
	public static Utilities util;
	public static Waits waits;
	public static ExtentReports extentReport;
	public static ExtentTest extentTest;
	
	public static void main(String[] args) throws Exception {
			
		   //Extent Reports Generation 
		   extentReport = new ExtentReports(utilConstants.pathReports+"/Report "+ Utilities.timeStampGenerator()+".html",false);
		   extentTest = new ExtentTest("CIVM", "Test Automation");
		   
		   //To load confguration files Eg project name, logo etc.
		   extentReport.loadConfig(new File(utilConstants.pathExtentConfigFile));
		   extentTest = extentReport.startTest("Driver Class");
		   
		   //For logs 
		   System.out.println(" ***********Starting Tests************ ");
		   extentTest.log(LogStatus.INFO, "***************Initialize selenium***************");
		   extentTest.log(LogStatus.INFO, "******************Starting Tests*****************");
			
		   //Local variables 
			String browser=null;	
			String execute = null;
			String cName=null, mName=null;
					
		/****************************************************************************************************************/
		
								browser = "chrome";
		
		/***************************************************************************************************************/
		
				// Creating object for utilities class				
				Utilities ut = new Utilities();
				
				// Logs 
				extentTest.log(LogStatus.INFO, "**********Tests Running Browser: "+browser+"*********");
				System.out.println("*********** Launching "+browser+" Browser ***********");
				extentReport.endTest(extentTest);										
				
				// To set excel file for test cases
				Utilities.setExcelFile(utilConstants.pathTestCases, 0);
				//To get row count ( to get number of test cases)
				int rows = Utilities.getRowCount(0);
							
				
				for(int i=1;i<rows;i++){
					
					Utilities.setExcelFile(utilConstants.pathTestCases, 0);
					// To execute particular test case by YES/NO ion excel
					execute = Utilities.getCellData(i, 2);
										
					if(execute.equalsIgnoreCase("Y")){
						
						//Initializing driver 
						driver = Utilities.InitializeDriver(browser);
						// Load url through utilities resuable method 
						ut.loadURL();
						
						// Getting test case name (Class name ) from testcases excel 
						String className = Utilities.getCellData(i, 0).trim();
						
						// concating package name to test cases.
						cName = "testScripts."+className;
						// Getting method name from test case excel
						mName = Utilities.getCellData(i, 1).trim();
											
						extentTest = extentReport.startTest(className);  
						extentTest.log(LogStatus.INFO, "####################  Executing Test Case : "+className+" ####################");
			             
						System.out.println("*********** Executing TestCase : "+Utilities.getCellData(i, 0)+" ***********");
					  
						// java reflections ( it will take class and method name and creates object and executes the test case)
						 Class<?> thisClass = Class.forName(cName);
						 Constructor<?> constructor = thisClass.getConstructor(WebDriver.class);
						 Object iClass = (Object)constructor.newInstance(driver);
						 Method thisMethod = thisClass.getDeclaredMethod(mName);
						 Object obj = thisMethod.invoke(iClass);
						 String result = obj.toString();
						 
						 // Taking screen shot when the test case is failed 
						 if(result.equalsIgnoreCase("Fail")){
			            	  String ssName = className+"_"+Utilities.timeStampGenerator();
			            	  ut.getScreenShot(ssName);
			            	  extentTest.log(LogStatus.FAIL, "*************** Test case failed for : "+className+" ***************");
			            	  //Attaching screen shot to the report
			            	  extentTest.log(LogStatus.FAIL,  extentTest.addScreenCapture(utilConstants.pathScreenShots+"/"+ssName+".jpg"));            	 
			              }else{
			            	  extentTest.log(LogStatus.PASS, "*************** Test case passed for : "+className+" ***************");
			              }
			              extentReport.endTest(extentTest);
			              extentReport.flush();
						 
			             // displays test case results in excel file as pass/fail 
						 Utilities.setExcelFile(utilConstants.pathTestCases, 0);
						 ut.putCellData(utilConstants.pathTestCases, 0, 1, 3, result);
						 driver.close();
						 driver.quit();
						
					}else continue;						
					
					
				} 	
				
	}

}