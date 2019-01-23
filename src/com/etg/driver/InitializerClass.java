package com.etg.driver;


import functionLibrary.Helper;
import functionLibrary.Utilities;
import functionLibrary.Waits;
import pageObjects.Commons_POM;
import pageObjects.EbooksPurchase_POM;
import pageObjects.Libraries_POM;
import pageObjects.Pricing_POM;
import pageObjects.RedownloadPurchasedEbooks_POM;
import pageObjects.Register_POM;

// declaring objects for all the required classes 
public abstract class InitializerClass extends Driver{
	
	
	protected InitializerClass(){		
		util = new Utilities();
		waits = new Waits();
	}

	
	//Objects for POM classes
	public Register_POM register;
	public Commons_POM common;
	public Libraries_POM Library; 
	public Pricing_POM pricings;
	public EbooksPurchase_POM ebooks;
	public RedownloadPurchasedEbooks_POM Redownloads;
	
	//objects for functionLibs
	public Utilities util;
	public Helper helper;
	
	
}
