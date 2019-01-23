package testScripts;

import org.openqa.selenium.WebDriver;
import com.etg.driver.InitializerClass;
import functionLibrary.Helper;
import functionLibrary.Waits;
import functionLibrary.actions;
import pageObjects.Pricing_POM;

public class Pricing extends InitializerClass{
	
	public Pricing(WebDriver driver){
		pricings = new Pricing_POM();
		helper = new Helper();
		waits = new Waits();
		
	}
	
	public String Pricings() throws Exception{
		
		try{
			
			helper.Login();
			
			actions.waitAndClick(pricings.getLnk_Pricing());
			
			actions.waitAndClick(pricings.getPurchase());
			
			waits.hardWait(2);
			actions.selectValue(pricings.getState(), "AL");
			waits.hardWait(2);
			
			actions.waitAndClick(pricings.getPaynow());
			
			waits.hardWait(2);
			
			actions.waitAndClick(pricings.getVisa());
			
			actions.waitAndType(pricings.getCard(), "4242424242424242");
			
			actions.selectValue(pricings.getExpiry(), "04");
			
			actions.selectValue(pricings.getExpiryyear(), "2020");
			
			actions.waitAndType(pricings.getCVN(), "123");
			
			actions.waitAndClick(pricings.getPay());
			
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

