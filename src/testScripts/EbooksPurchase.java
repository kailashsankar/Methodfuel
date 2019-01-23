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

public class EbooksPurchase extends InitializerClass{
	
	public EbooksPurchase(WebDriver driver){
		ebooks = new EbooksPurchase_POM();
		helper = new Helper();
		waits = new Waits();
		common = new Commons_POM();
		
	}
	
	public String test(){
		
		try{
		
			helper.Login();
			
			actions.waitAndClick(ebooks.getLnk_Pricing());
					
			List<WebElement> purchaseBtn = ebooks.getBtns_Purchase();
						
			int size = ebooks.getBtns_Purchase().size();
						
			for(int i=1;i<size;i++){
				
				if(purchaseBtn.get(i).getText().equals("Purchase")){
					actions.javascriptClick(purchaseBtn.get(i));
					break;
				}
			}
					
			waits.hardWait(2);
			actions.selectValue(ebooks.getState(), "AL");
			waits.hardWait(2);
			
			actions.waitAndClick(ebooks.getPaynow());
			
			waits.hardWait(2);
			
			actions.waitAndClick(ebooks.getVisa());
			
			actions.waitAndType(ebooks.getCard(), "4242424242424242");
			
			actions.selectValue(ebooks.getExpiry(), "04");
			
			actions.selectValue(ebooks.getExpiryyear(), "2020");
			
			actions.waitAndType(ebooks.getCVN(), "123");
			
			actions.waitAndClick(ebooks.getPay());
			
			actions.waitAndClick(ebooks.getDownload());
			
			Robot robot = new Robot(); 
	           Thread.sleep(2000);
	           robot.keyPress(KeyEvent.VK_DOWN);  	
	           Thread.sleep(2000);  
	           robot.keyPress(KeyEvent.VK_TAB);	
	           Thread.sleep(2000);	
	           robot.keyPress(KeyEvent.VK_TAB);	
	           Thread.sleep(2000);	
	           robot.keyPress(KeyEvent.VK_TAB);	
	           Thread.sleep(2000);	
	           robot.keyPress(KeyEvent.VK_ENTER);
	           
	        actions.waitAndClick(ebooks.getclose());
	        
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
