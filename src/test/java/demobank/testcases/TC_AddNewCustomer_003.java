package demobank.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;


import demobank.pageobjects.AddcustomerPage;
import demobank.pageobjects.loginpage;
import net.bytebuddy.utility.RandomString;

public class TC_AddNewCustomer_003 extends baseclass {
	@Test
	public void addNewCustomer() throws IOException, InterruptedException {
		loginpage lp=new loginpage(driver);
		lp.setUserName(username);
		logger.info("username entered");
		lp.setPassword(password);
		logger.info("password entered");
		lp.clicksubmit();
		Thread.sleep(5000);
		driver.manage().window().maximize();
		AddcustomerPage addcust=new AddcustomerPage(driver);
		addcust.clickNewCustomer();
		addcust.testCustomerName("maithra");
		addcust.radioGender("female");
		addcust.custDob("01","01","96");
		addcust.custAdress("vijaynagar");
		addcust.custCity("bangalore");
		addcust.custState("karnataka");
		addcust.custPinno("560040");
		addcust.custPhoneno("9066058144");
		String email=randomestring()+"@gmail.com";
		addcust.custEmail(email);
		addcust.custPassword("1234");
		addcust.custSubmit();
		
		Thread.sleep(5000); 
		boolean custCreate=driver.getPageSource().contains("Customer Registered Successful!!!");
		
	/*	if(custCreate==true)
		{
			Assert.assertTrue(true);
			logger.info("customer created successful");
		}else {
			capturescreenshot(driver,"addNewCustomer");
			Assert.assertTrue(false);
			logger.info("customer creation failed");
		} */
				
		
	}
	
	public String randomestring() {
		String generatedstring=RandomString.make(8);
		return generatedstring;
		
	}


}