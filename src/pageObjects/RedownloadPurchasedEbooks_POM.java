package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;


public class RedownloadPurchasedEbooks_POM extends Commons_POM {

	  public RedownloadPurchasedEbooks_POM() {
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
		private List<WebElement> Btns_Purchased;
		public List<WebElement> getBtns_Purchased(){
			return Btns_Purchased;
		}
			
		@FindBy(xpath="//div[@class='TC-6']/a")
		private List<WebElement> ReDownload;
		public List<WebElement> getReDownload() {
			return ReDownload;
		}
		@FindBy(css="div[class='modal-content'] span")
		private WebElement close;
		public WebElement getclose(){
			return close;
		}
		@FindBy(xpath="//div[@class='tdata-conrow']//div[6]/a")
		private List<WebElement> Btn_Redownload;
		public List<WebElement> getBtn_Redownload(){
			return Btn_Redownload;
		}
}