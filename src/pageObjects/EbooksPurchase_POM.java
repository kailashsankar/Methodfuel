package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;


public class EbooksPurchase_POM extends Commons_POM{
	
	 public EbooksPurchase_POM() {
		 ElementLocatorFactory locatorwait = new AjaxElementLocatorFactory(driver, 20);
		 PageFactory.initElements(locatorwait, this);
	 }
	 
	@FindBy(linkText="Pricing")
	private WebElement Lnk_Pricing;
	public WebElement getLnk_Pricing(){
		return Lnk_Pricing;
	}
	
	@FindBy(xpath="//div[@class='tdata-grid']//ul")
	private List<WebElement> table;
	public List<WebElement> gettable(){
		return table;
	}
	
	@FindBy(xpath="//div[@class='tdata-conrow']//div[6]/a")
	private List<WebElement> Btns_Purchase;
	public List<WebElement> getBtns_Purchase(){
		return Btns_Purchase;
	}
	
    @FindBy(id="fm-state")
    private WebElement State;
    public WebElement getState() {
	return State;
    }
    
    @FindBy(xpath="//button[@id='checkoutBtn']")
	private WebElement Paynow;
	public WebElement getPaynow() {
		return Paynow;
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
	
	@FindBy(id="downld")
	private WebElement Download;
	public WebElement getDownload() {
		return Download;
	}
	@FindBy(css="div[class='modal-content'] span")
	private WebElement close;
	public WebElement getclose(){
		return close;
	}
	
    }