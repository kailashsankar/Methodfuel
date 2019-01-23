package testScripts;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.etg.driver.InitializerClass;
import functionLibrary.Helper;
import functionLibrary.Waits;
import functionLibrary.actions;
import pageObjects.Commons_POM;
import pageObjects.EbooksPurchase_POM;
import pageObjects.RedownloadPurchasedEbooks_POM;

public class RedownloadPurchasedEbooks extends InitializerClass {


	public RedownloadPurchasedEbooks(WebDriver driver){
		Redownloads = new RedownloadPurchasedEbooks_POM();
		helper = new Helper();
		waits = new Waits();
		common = new Commons_POM();
		ebooks = new EbooksPurchase_POM();
		
		}
	public String RedownloadEbooks(){
		
		try{
		
			helper.Login();
			
			actions.waitAndClick(Redownloads.getLnk_Pricing());
					
			List<WebElement> purchasedBtn = Redownloads.getBtns_Purchased();
						
			int size = Redownloads.getBtn_Redownload().size();
						
			for(int i=1;i<size;i++){
				
				if(purchasedBtn.get(i).getText().equals("Purchased")){
					actions.javascriptClick(purchasedBtn.get(i));
					break;
				}
			}
					
			waits.hardWait(2);
			
			int redownloadbtns = Redownloads.getReDownload().size();
			
			for(int j=1;j<redownloadbtns;j++){
				
				if(purchasedBtn.get(j).getText().equals("Re-Download")){
					actions.javascriptClick(purchasedBtn.get(j));
					break;
				}
			}
						
			waits.hardWait(2);
	           
	        actions.javascriptClick(ebooks.getclose());
	        
	        actions.waitAndClick(common.getLnk_signOut());
			
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
