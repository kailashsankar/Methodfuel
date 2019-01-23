package testScripts;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import com.etg.driver.InitializerClass;
import functionLibrary.Helper;
import functionLibrary.Waits;
import functionLibrary.actions;
import pageObjects.Libraries_POM;

public class Libraries extends InitializerClass{
	
	public Libraries(WebDriver driver){ 
		Library = new Libraries_POM();
		helper = new Helper();
		waits = new Waits();
		
	}
	
	
	public String Library() throws Exception{
		
		try{
					helper.Login();
				
					actions.waitAndClick(Library.getLibraires());
						
					actions.waitAndClick(Library.getConnect());
					
					waits.hardWait(5);
					
					String parentWindow = driver.getWindowHandle();
			
					Set <String> handles =driver.getWindowHandles();
				    Iterator<String> it = handles.iterator();
			
				    String parent = it.next();
				    String child = it.next();
				    
				    waits.hardWait(2);
				    
				    driver.switchTo().window(child);
							
					actions.waitAndClick(Library.getExitLibrary());
					
					waits.hardWait(2);
					
					actions.waitAndClick(Library.getExit());
					
					waits.hardWait(2);
					
					driver.switchTo().window(parent);
					
					
		
			  return "Pass";
			    
			}catch(Exception e){
				System.out.println(e);
				return "Fail";
				
			}catch(AssertionError e){
				System.out.println(e);
				return "Fail";
			}

	}

}
