package functionLibrary;

import com.etg.constants.utilConstants;
import com.etg.driver.InitializerClass;

import pageObjects.Commons_POM;

public class Helper extends InitializerClass {

	
	public Helper(){
		util = new Utilities();
		common = new Commons_POM();
	}
	//To login the applciation	
	public void Login() throws Exception{
				
			Utilities.setExcelFile(utilConstants.pathDataSheet, 2);
			common.loginUser(Utilities.getCellData(0, 1), Utilities.getCellData(1, 1));		
		}	
	}


