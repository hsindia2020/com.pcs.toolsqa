package com.pcs.util;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.pcs.config.StartBrowser;

public class FailedTCScreen extends StartBrowser{

	public void failedtc() throws Exception {
		 
		File scrfile = ((TakesScreenshot)driver01).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrfile, new File("E:\\git\\TestNG-Frame\\screen\\testFail.jpg"));
	}
}
