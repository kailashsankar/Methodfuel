package testScripts;

import org.openqa.selenium.WebDriver;
import com.etg.constants.utilConstants;
import com.etg.driver.InitializerClass;
import com.relevantcodes.extentreports.LogStatus;

import functionLibrary.Utilities;
import functionLibrary.actions;
import pageObjects.Register_POM;

public class Register extends InitializerClass {
	
	public Register(WebDriver driver){
		util = new Utilities();
		register = new Register_POM();
	}
	

	public String UserRegister() throws Exception{
		
		
		try{				
				actions.waitAndClick(register.getSignup());
				actions.waitAndClick(register.getSignup());
				extentTest.log(LogStatus.PASS, "Clicked on SignIn button");
			
				Utilities.setExcelFile(utilConstants.pathDataSheet, 1);
										
				actions.waitAndType(register.getFirstName(), Utilities.getCellData(0, 1));
				extentTest.log(LogStatus.PASS, "Text value : " +Utilities.getCellData(0, 1) +" Entered in First Name.");
				
				actions.waitAndType(register.getLastName(), Utilities.getCellData(1, 1));
				extentTest.log(LogStatus.PASS, "Text value : "+Utilities.getCellData(1, 1)+" Entered in Last Name.");
				
				actions.waitAndType(register.getCompanyName(), Utilities.getCellData(2, 1));
				
				actions.waitAndType(register.getAddress1(),Utilities.getCellData(3, 1));
				
				actions.waitAndType(register.getAddress2(), Utilities.getCellData(4, 1));
			
				actions.waitAndType(register.getCity(), Utilities.getCellData(5, 1));
				
				waits.hardWait(1);
				
				actions.selectValue(register.getCountry(), Utilities.getCellData(6, 1));
				
				waits.hardWait(2);
				
				actions.selectValue(register.getState(), Utilities.getCellData(7, 1));
				
				actions.waitAndType(register.getZipCode(), Utilities.getCellData(8, 1));
				
				actions.waitAndType(register.getPhone(), Utilities.getCellData(9, 1));
				
				String email = util.getEmailId();
				
				actions.waitAndType(register.getEmail(), email);
						
			    actions.waitAndType(register.getPassword(), "Test@123");  
				
				actions.waitAndType(register.getConfirmPassword(), "Test@123");
				
			    actions.waitAndClick(register.getSubmit());
			    
			    waits.hardWait(2);
			    
			    actions.AssertVerify("Thank you. Your registration is complete. Please Sign-in now to continue.", register.getMsg_Success());
				
			    util.ExcelWrite(email);
			    
			    return "Pass";
			    
			    
		}catch(Exception e){
			System.out.println(e);
			extentTest.log(LogStatus.FAIL, e);
			return "Fail";
					
		}catch(AssertionError e){
			System.out.println(e);
			extentTest.log(LogStatus.FAIL, e);
			return "Fail";
		}

	}

}
