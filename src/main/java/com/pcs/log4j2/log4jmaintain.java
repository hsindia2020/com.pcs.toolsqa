package com.pcs.log4j2;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.pcs.config.StartBrowser;
import com.pcs.util.FailedTCScreen;


public class log4jmaintain extends StartBrowser implements ITestListener {
	
	public static Logger logger = LogManager.getLogger(log4jmaintain.class);

	FailedTCScreen screen = new FailedTCScreen();
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("****** Test Started "+result.getName());
		logger.info("Log for information massage Started");
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("****** Test Success "+result.getName());
		logger.info("Log for information massage Passed");
		test01.pass("Test case Passed with Execution");
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("****** Test Failed "+result.getName());
		logger.info("Log for information massage Failed");
		logger.error("This is Error message");
		logger.info(result);
		logger.debug("We are in debuger logger tag");
		logger.trace("Trace level message maintaining");
		test01.fail("Test case Failed with Execution");
	
		try {
			screen.failedtc();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("****** Test Skipped "+result.getName());
		logger.info("Log for information massage Skipped");
		logger.error("This is Skipped");
		logger.debug("We are in debuger logger tag");
		logger.error(result);
		logger.warn("Warning message");
		logger.fatal("Fatal message");
		test01.skip("Test case Skipped");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("###### Its in Failed result");
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub	
		logger.info("Test Started ");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("****** Test End "+context.getName());
		logger.info("Log for information massage Finished");
	}
}
