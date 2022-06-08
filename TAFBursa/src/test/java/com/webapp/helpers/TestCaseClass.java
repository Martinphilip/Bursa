package com.webapp.helpers;


import com.webapp.pages.*;
import com.automation.core.config.ProjectConfig;
import com.automation.core.utils.data.ExcelDataReader;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
//import junit.framework.Assert;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestCaseClass {

	public static void equityPriceSorting( WebDriver driver,String testCaseID, String dataSheet) {
		// TODO Auto-generated method stub
		LinkedHashMap<String, String> data = ExcelDataReader.readTCBinding(testCaseID,dataSheet);
		driver.navigate().to(ProjectConfig.getPropertyValue("Bursa_Malaysia_URL"));		
		Assert.assertTrue(SortEquityPrice.equityPageValidation());
	
	}
	
	public static void registrationValidation( WebDriver driver,String testCaseID, String dataSheet) {
		// TODO Auto-generated method stub
		LinkedHashMap<String, String> data = ExcelDataReader.readTCBinding(testCaseID,dataSheet);
		driver.navigate().to(ProjectConfig.getPropertyValue("Bursa_Marketplace_URL"));
		if(testCaseID.equalsIgnoreCase("TC002"))
		{
			Assert.assertTrue(RegistrationPage.loginValidation(data));
		}
	
	}
	
	public static void registrationValidation( WebDriver driver,String Name, String email,String pass) {
		// TODO Auto-generated method stub
		driver.navigate().to(ProjectConfig.getPropertyValue("Bursa_Marketplace_URL"));
		
		Assert.assertTrue(RegistrationPage.loginValidation(Name,email,pass));
	
	}
	
	public static void registrationValidationfb( WebDriver driver, String email,String pass) {
		// TODO Auto-generated method stub
		driver.navigate().to(ProjectConfig.getPropertyValue("Bursa_Marketplace_URL"));
		
		Assert.assertTrue(RegistrationPage.loginValidationFB(email,pass));
	
	}
	

}
