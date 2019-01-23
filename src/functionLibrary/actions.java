package functionLibrary;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.etg.constants.utilConstants;
import com.etg.driver.InitializerClass;


public class actions extends InitializerClass{
	
	public actions(){
		    
	}
	
	// To enter the text value in any input field
	 public static void waitAndType(WebElement element, String value){
		 element.sendKeys(value);
	 }

	 // To click any button 
	 public static void waitAndClick(WebElement element){		   
		 waits.WaitForClickableElement(element);
		 element.click();
		    	   
	   }
	 // To select value from select drop down
	 public static void selectValue(WebElement element, String value){
		 Select select = new Select(element);
		 select.selectByValue(value);
	 }
	 
	 // To double click 
	 public void waitAndDoubleClick(WebElement element){
		 Actions a = new Actions(driver);
		 waits.WaitForClickableElement(element);
		 a.doubleClick(element).build().perform();
		 
	 }
	 
	 // for force click 
	 public static void javascriptClick(WebElement element) throws Exception{
			
		 Thread.sleep(1000);
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click();",element);
		
	}
	
	 // Verification point using asseration 
	public static void AssertVerify(String Expected,WebElement e){
		Assert.assertEquals(Expected, e.getText());
	}
	 
	

}