package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;



public class Pricing_POM extends Commons_POM {
	
	public Pricing_POM(){
	ElementLocatorFactory locatorwait = new AjaxElementLocatorFactory(driver, 20);
			PageFactory.initElements(locatorwait, this);
	}
	
	@FindBy(linkText="Pricing")
	private WebElement Lnk_Pricing;
	public WebElement getLnk_Pricing(){
		return Lnk_Pricing;
	}
	
	@FindBy(linkText="Purchase")
	private WebElement Purchase;
	public WebElement getPurchase() {
		return Purchase;
	}
	
	@FindBy(xpath="//button[@id='checkoutBtn']")
	private WebElement Paynow;
	public WebElement getPaynow() {
		return Paynow;
	}
	
	@FindBy(id="fm-state")
	private WebElement State;
	public WebElement getState() {
		return State;
	}
	
	@FindBy(id="card_type_001")
	private WebElement visa;
	public WebElement getVisa() {
		return visa;
	}
	
	@FindBy(id="card_number")
	private WebElement Card;
	public WebElement getCard() {
		return Card;
	}
	
	@FindBy(id="card_expiry_month")
	private WebElement Expiry;
	public WebElement getExpiry() {
		return Expiry;
	}
	
	@FindBy (id="card_expiry_year")
	private WebElement Expiryyear;
	public WebElement getExpiryyear() {
		return Expiryyear;
	}
	
	@FindBy(id="card_cvn")
	private WebElement CVN;
	public WebElement getCVN() {
		return CVN;
	}
	
	@FindBy(xpath="//input[@name='commit']")
	private WebElement Pay;
	public WebElement getPay() {
		return Pay;
	}
	
	
}
