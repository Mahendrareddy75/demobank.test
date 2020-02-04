package demobank.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import demobank.pageobjects.loginpage;

public class Tc_LoginTest_001 extends baseclass{
	@Test
	public void LoginTest() throws InterruptedException, IOException {
		logger.info("URL launched");
		loginpage lp=new loginpage(driver);
		lp.setUserName(username);
		logger.info(username);
        lp.setPassword(password);
        logger.info(password);
        lp.clicksubmit();
        Thread.sleep(3000);
        System.out.println(driver.getTitle());
        if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
        	Assert.assertTrue(true);
        }else {
        	capturescreenshot(driver,"LoginTest");
        	Assert.assertTrue(false);
        }
	}

}
