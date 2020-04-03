package com.pcs.config;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.pcs.util.ConfiguratorSupport;
import com.pcs.util.FailedTCScreen;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class StartBrowser {

	public static WebDriver driver01;
	ConfiguratorSupport cs = new ConfiguratorSupport("config.properties");
	ExtentHtmlReporter htmlreporter;
	public static ExtentReports ext;
	public static ExtentTest test01;

	@BeforeSuite()
	public void setup() {

		htmlreporter = new ExtentHtmlReporter("extentReportTestNG.html");
		ext = new ExtentReports();
		ext.attachReporter(htmlreporter);
		
	}
	
	@BeforeMethod
	public void beforeM() {
 		driver01.get(cs.getProperty("url"));

	}

	@BeforeClass
	public void beforeClass() {
		
		String browser01 = cs.getProperty("browser");
		System.out.println("Browser selected "+browser01);
		switch (browser01) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver01 = new ChromeDriver();
			driver01.manage().window().maximize();
			driver01.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver01 = new FirefoxDriver();
			driver01.manage().window().maximize();
			driver01.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			break;
		default:
			System.out.println("Please enter the current browser name");
			break;
		}

	}

	@AfterClass
	public void afterClass() {
		ext.flush();
		driver01.close();
		
	}

}
