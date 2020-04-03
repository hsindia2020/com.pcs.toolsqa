package com.pcs.toolsqa;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pcs.config.StartBrowser;

@Listeners(com.pcs.log4j2.log4jmaintain.class)

/**
 * WebDriver and browser selection comes from Startbrowser.class
 * through parameter define.
 * @author Harmeet
 *
 */
public class Interactions extends StartBrowser {

	@Test(groups="Regression", priority = 0)
	static void Sortable() throws InterruptedException {

		test01 = ext.createTest("Sortable selected ","Sortable on demo QA site");
		test01.info("Change the position of sortable");
		//		test01.log(Status.INFO, "Starting the Test");

		driver01.findElement(By.xpath("//a[contains(text(),'Sortable')]")).click();

		Actions action = new Actions(driver01);
		action.moveToElement(driver01.findElement(By.xpath("//li[contains(text(),'Item 2')]")))
		.clickAndHold().moveToElement(driver01.findElement(By.xpath("//li[contains(text(),'Item 5')]"))).release()
		.build().perform();

		test01.info("Test case completed");
//		Thread.sleep(3000);
	}

	@Test(groups="Regression", dependsOnMethods = {"Sortable"})
	static void Selectable() {

		test01 = ext.createTest("Selectable selected ","Selectable on demo QA site");
		test01.info("Change the position of seletable");

		driver01.findElement(By.xpath("//a[contains(text(),'Selectable')]")).click();

		Actions action = new Actions(driver01);
		action.moveToElement(driver01.findElement(By.xpath("//li[contains(text(),'Item 2')]"))).clickAndHold()
		.moveToElement(driver01.findElement(By.xpath("//li[contains(text(),'Item 5')]"))).release().build().perform();

		test01.info("Test case completed");

		/*try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	@Test(groups="Regression",priority=2)
	static void Droppable() {

		test01 = ext.createTest("Droppable selected ","Droppable on demo QA site");
		test01.info("Change the position of Droppable");

		driver01.findElement(By.xpath("//a[contains(text(),'Droppable')]")).click();

		Actions action = new Actions(driver01);
		action.clickAndHold(driver01.findElement(By.xpath("//div[@id='draggable']")))
		.moveToElement(driver01.findElement(By.xpath("//div[@id='droppable']"))).release(driver01.findElement(By.xpath("//div[@id='draggable']")))
		.build().perform();

		test01.info("Test case completed");

//		driver01.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	@Test(groups="Regression")
	static void Resizable()
	{
		test01 = ext.createTest("Resizable selected ","Resizable on demo QA site");
		test01.info("Change the position of Resizable");

		driver01.findElement(By.xpath("//a[contains(text(),'Resizable')]")).click();
		Actions action = new Actions(driver01);
		action.clickAndHold(driver01.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']")))
		.moveByOffset(70, 50).release(driver01.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']")))
		.build().perform();

		test01.info("Test case completed");

//		driver01.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	@Test(groups="Regression")
	static void Draggable() {
		test01 = ext.createTest("Draggable selected ","Draggable on demo QA site");
		test01.info("Change the position of Draggable");

		driver01.findElement(By.xpath("//a[contains(text(),'Draggable')]")).click();
		Actions action = new Actions(driver01);
		action.clickAndHold(driver01.findElement(By.xpath("//div[@id='draggable']")))
		.moveByOffset(80, 130).release(driver01.findElement(By.xpath("//div[@id='draggable']")))
		.build().perform();
		
		test01.info("TestCase executed and completed");
		
//		driver01.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
}
