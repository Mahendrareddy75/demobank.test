package demobank.testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import demobank.pageobjects.loginpage;
import demobank.utils.XLUtils;

public class TC_LoginDOT_002 extends baseclass {
	@Test(dataProvider="logindata")
	
	public void LogingDOT(String uname,String password) {
		loginpage ip=new loginpage(driver);
		ip.setUserName(uname);
		logger.info("entered usrname");
		ip.setPassword(password);
		logger.info("entered pwd");
		ip.clicksubmit();
		
		if(isAleartPresent()==true) {
			driver.switchTo().alert();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			
		}else {
			Assert.assertTrue(true);
			ip.clicklogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}
	public boolean isAleartPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	
	}
	@DataProvider(name="logindata")
	String [][] getData() throws IOException{
		String path=System.getProperty(("user.dir")+"/src/test/java/demobank/testDat/testData.xlsx");
	int rownum=XLUtils.getRowCount(path, "sheet1");
	int colcount=XLUtils.getCellCount(path, "sheet1", 1);
	String logindata[][]=new String[rownum][colcount];
	for(int i=1;i<rownum;i++) {
		for(int j=0;j<colcount;j++) {
			logindata[i-1][j]=XLUtils.getCellData(path, "sheet1", i, j);
		}
	}
	
	
return logindata;
}
}
