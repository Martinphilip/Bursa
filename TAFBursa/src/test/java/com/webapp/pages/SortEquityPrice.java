package com.webapp.pages;

import com.webapp.commonDef.CommonDef;
import com.automation.core.testng.reporter.CustomReporter;
import com.automation.core.utils.reporter.Report;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class SortEquityPrice {

	public SortEquityPrice() {}
	static By codeBy= By.xpath("//*[@id='pills-active']/table/tbody/tr[XXXX]/td[1]");
	static By nameBy= By.xpath("//*[@id='pills-active']/table/tbody/tr[XXXX]/th/div/a");
	static By changeBy=	By.xpath("//*[@id='pills-active']/table/tbody/tr[XXXX]/td[3]");
	static By volBy= By.xpath("//*[@id='pills-active']/table/tbody/tr[XXXX]/td[4]");
	static By closeBy= By.xpath("//a[text()='Close']");
	static By mostActiveBy= By.xpath("(//a[@class='nav-link btn btn-effect btn-white active' and @id='pills-active-tab'])[1]");
	// Method to enter the user Data
	public static boolean equityPageValidation() {
		String [][] table=new String[10][4];
		double []change=new double[table.length];
		List<String> codeList=new ArrayList<String>();
		
		try {
			
			CommonDef.click(closeBy);
			CommonDef.moveToElement(mostActiveBy);
			//CommonDef.click(mostActiveBy);
			for(int i=0;i<=table.length-1;i++) {

				table[i][0]=CommonDef.getCurrentDriver().findElement(CommonDef.replaceXXXXFromString(codeBy,String.valueOf(i+1))).getText();
				table[i][1]=CommonDef.getCurrentDriver().findElement(CommonDef.replaceXXXXFromString(nameBy,String.valueOf(i+1))).getText();
				if(!(CommonDef.getCurrentDriver().findElement(CommonDef.replaceXXXXFromString(changeBy,String.valueOf(i+1))).getText().equals("-"))) {
					change[i]=Double.parseDouble(CommonDef.getCurrentDriver().findElement(CommonDef.replaceXXXXFromString(changeBy,String.valueOf(i+1))).getText());
					table[i][2]=CommonDef.getCurrentDriver().findElement(CommonDef.replaceXXXXFromString(changeBy,String.valueOf(i+1))).getText();
				}
				else
				{
					table[i][2]="0.000";
				}
				table[i][3]=CommonDef.getCurrentDriver().findElement(CommonDef.replaceXXXXFromString(volBy,String.valueOf(i+1))).getText();

			}
			Arrays.sort(change);	
			System.out.println("Code      |Name      |Change     |Vol         ");
			for(int j=change.length-1;j>=0;j--) {
				for(int i=0;i<=table.length-1;i++) {
					if(change[j]==Double.parseDouble((table[i][2]))&&!(codeList.contains(table[i][1])))
					{
						codeList.add(table[i][1]);
						System.out.println(CommonDef.rightPadding(table[i][0])+"|"+CommonDef.rightPadding(table[i][1])+"|"+CommonDef.rightPadding(table[i][2])+" |"+CommonDef.rightPadding(table[i][3]));
						CommonDef.logs(Arrays.toString(table[i]));
						break;
					}
				}
			}
			return true;

		} catch (Exception e) {
			CommonDef.logs(e.getMessage());
			return false;
		}
		
	}
	


}
