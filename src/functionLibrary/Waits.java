package functionLibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.etg.driver.Driver;

public class Waits extends Driver{
	
	WebDriverWait wait;
	/* Constructors */
	 public Waits(){
		 wait = new WebDriverWait(driver,30);
    }

	
	/**
	  * Method waiting for a specified period unconditionally
	  */
	  public void hardWait(int seconds) throws InterruptedException {
		  Thread.sleep(seconds*1000);				  
	  }
	  
	public void WaitForClickableElement(WebElement e){
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.elementToBeClickable(e));
		
	}
}
