package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

public class Libraries_POM extends Commons_POM {
	
	public Libraries_POM() {
		ElementLocatorFactory locatorWait = new AjaxElementLocatorFactory(driver, 20);
		PageFactory.initElements(locatorWait, this);
	}
	
	@FindBy(id="p7MGMa1_2")  
	private WebElement Libraires;
	public WebElement getLibraires() {
	return Libraires;
	}
	
	@FindBy(linkText= "Connect")
	private WebElement Connect;
	public WebElement getConnect() {
	return Connect;
	}
	
	@FindBy(css="#myBtn")
	private WebElement ExitLibrary;
	public WebElement getExitLibrary() {
	return ExitLibrary;
	}

	@FindBys( {@FindBy(xpath="//div[@id='myModal']"), @FindBy(name="stop")} )
	private WebElement Exit;
	public WebElement getExit() {
		return Exit;
	}
	
	
}
