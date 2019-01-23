package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import com.etg.driver.Driver;



public class Commons_POM  extends Driver{
	
	public Commons_POM(){
		ElementLocatorFactory locatorWait = new AjaxElementLocatorFactory(driver, 20);
		PageFactory.initElements(locatorWait, this);
	}
		
	  @FindBy(xpath="//a[text()='Sign-In']")   
      private WebElement Signin;
      public WebElement getSignin() {
			return Signin;
      }
        
      @FindBy(id="mfs-login-em")
      private WebElement Login;
	  public WebElement getLogin() {
		return Login;
	  }
      @FindBy(id="mfs-login-pa")
      private WebElement password;
	  public WebElement getPassword() {
		return password;
	  }
      @FindBy(css="button[type='submit']")
      private WebElement Enter;
	  public WebElement getEnter() {
		return Enter;
	  }
	  
	  @FindBy(linkText="Sign-Out")
	  private WebElement Lnk_signOut;
	  public WebElement getLnk_signOut(){
		  return Lnk_signOut;
	  }
	 
	  private void Signout() throws Exception {	
		  Thread.sleep(2);
		  this.getLnk_signOut().click();
	  } 
	  
	  public void loginUser(String email,String pwd) throws Exception{
	    	
	    	this.getSignin().click();
	    	this.getLogin().sendKeys(email);
	    	this.getPassword().sendKeys(pwd);
	    	Thread.sleep(2);
	    	this.getEnter().click();
	  }

}
