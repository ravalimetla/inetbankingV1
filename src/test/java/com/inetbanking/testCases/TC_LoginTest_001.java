package com.inetbanking.testCases;



import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
	@Test
	public void LoginTest() throws Throwable {
		
		logger.info("URL is opened");
		LoginPage lp=new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		lp.setUserName(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.clickSubmit();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("login test passed");
		}
		else {
			captureScreen(driver,"LoginTest");
			Assert.assertTrue(false);
			logger.info("login test failed");
		}
	}

}
