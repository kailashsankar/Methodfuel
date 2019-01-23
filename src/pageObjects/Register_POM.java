package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

public class Register_POM extends Commons_POM {
	
	
	public Register_POM(){
		ElementLocatorFactory locatorWait = new AjaxElementLocatorFactory(driver, 20);
		PageFactory.initElements(locatorWait, this);
	}


	
	@FindBy(xpath="//div[@class='nav-global']/div/ul/li[5]/a")
	private WebElement signup;
	public WebElement getSignup() {
		return signup;
	}
	
	@FindBy(css="input[name='first_name']")
	private WebElement firstName;
	public WebElement getFirstName() {
	   return firstName;
	}
	
	@FindBy(id="fm-reg-last")
	private WebElement lastName;
	public WebElement getLastName() {
		return lastName;
	}
	
	@FindBy(id="fm-reg-com")
	private WebElement CompanyName;
	public WebElement getCompanyName() {
		return CompanyName;
	}

	@FindBy(id="fm-reg-addr1")
	private WebElement Address1;
	public WebElement getAddress1() {
		return Address1;
	}
   
	@FindBy(id="fm-reg-addr2")
	private WebElement Address2;
	public WebElement getAddress2() {
		return Address2;
	}

	@FindBy(id="fm-reg-city")
	private WebElement City;
	public WebElement getCity() {
		return City;
	}
	
	@FindBy( id="fm-reg-country")
	private WebElement country;
	public WebElement getCountry() {
		return country;
	}
	
	@FindBy(id="fm-reg-state")
	private WebElement State;
	public WebElement getState() {
		return State;
	}
	
	@FindBy(id="fm-reg-zip")
	private WebElement ZipCode;
	public WebElement getZipCode() {
		return ZipCode;
	}
	
	@FindBy(id="fm-reg-phone")
	private WebElement Phone;	
	public WebElement getPhone() {
		return Phone;
	}


	@FindBy(id="fm-reg-email")
	private WebElement email;
	public WebElement getEmail() {
		return email;
	}
	
	@FindBy(id="fm-reg-pass")
	private WebElement Password;
	public WebElement getPassword() {
		return Password;
	}
	
	@FindBy(id="fm-reg-confirmpass")
	private WebElement ConfirmPassword;
	public WebElement getConfirmPassword() {
		return ConfirmPassword;
	}
	
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement Submit;
	public WebElement getSubmit() {
	return Submit;
	}
	@FindBy(css="div[class='form-block usrMsg has-success'] span")
	private WebElement Msg_Success;
	public WebElement getMsg_Success(){
		return Msg_Success;
	}
   
	
}

