package com.lbg.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumDemoTest {

	private RemoteWebDriver driver;

	@BeforeEach // runs before EACH test
	void init() {
		// creates a new chrome window
		ChromeOptions opts = new ChromeOptions();
//		opts.addArguments("--headless=new");

		this.driver = new ChromeDriver(opts);
		// sets it to fullscreen
		this.driver.manage().window().maximize();
	}

//	@Test
//	void seleniumTest() {
//		// opens bing.com
//		this.driver.get("http://www.bing.com");
//	}

	@Test
	void textBoxTest() {
		this.driver.get("https://demoqa.com/text-box");

		WebElement consent = this.driver.findElement(By.cssSelector(
				"body > div.fc-consent-root > div.fc-dialog-container > div.fc-dialog.fc-choice-dialog > div.fc-footer-buttons-container > div.fc-footer-buttons > button.fc-button.fc-cta-consent.fc-primary-button"));
		consent.click();

		WebElement fullName = this.driver.findElement(By.id("userName"));

		this.driver.executeScript("arguments[0].scrollIntoView(true);", fullName);

		fullName.sendKeys("Barry");

		WebElement email = this.driver.findElement(By.id("userEmail"));

		this.driver.executeScript("arguments[0].scrollIntoView(true);", email);

		email.sendKeys("busybarry@gmail.com");

		WebElement address = this.driver.findElement(By.id("currentAddress"));

		this.driver.executeScript("arguments[0].scrollIntoView(true);", address);

		address.sendKeys("1 Barry Lane, Sad Times, B33 3MO");

		WebElement permAddress = this.driver.findElement(By.id("permanentAddress"));

		this.driver.executeScript("arguments[0].scrollIntoView(true);", permAddress);

		permAddress.sendKeys("1 Scary Lane, Bad Times, B33 3MO");

		WebElement submit = this.driver.findElement(By.id("submit"));

		this.driver.executeScript("arguments[0].scrollIntoView(true);", submit);

		submit.click();

		WebElement display = this.driver.findElement(By.id("name"));
		Assertions.assertEquals(true, display.getText().contains("Barry"));

		WebElement emailDisplay = this.driver.findElement(By.cssSelector("#email"));
		Assertions.assertEquals("Email:busybarry@gmail.com", emailDisplay.getText());

		WebElement currentAddressDisplay = this.driver.findElement(By.cssSelector("#output #currentAddress"));
		Assertions.assertEquals("Current Address :1 Barry Lane, Sad Times, B33 3MO", currentAddressDisplay.getText());

	}

//	@Test
//	void CheckBoxTest() {
//		this.driver.get("https://demoqa.com");
//
//		WebElement consent = this.driver.findElement(By.cssSelector(
//				"body > div.fc-consent-root > div.fc-dialog-container > div.fc-dialog.fc-choice-dialog > div.fc-footer-buttons-container > div.fc-footer-buttons > button.fc-button.fc-cta-consent.fc-primary-button > p"));
//		consent.click();
//
//		WebElement elements = this.driver.findElement(By.cssSelector(
//				"#app > div > div > div.home-body > div > div:nth-child(1) > div > div.avatar.mx-auto.white > svg"));
//
//		this.driver.executeScript("arguments[0].scrollIntoView(true);", elements);
//
//		elements.click();
//
//		WebElement checkBox = this.driver.findElement(By.id("item-1"));
//
//		this.driver.executeScript("arguments[0].scrollIntoView(true);", checkBox);
//
//		checkBox.click();
//
//		WebElement toggle1 = this.driver.findElement(By.cssSelector("#tree-node > ol > li > span > button > svg"));
//
//		this.driver.executeScript("arguments[0].scrollIntoView(true);", toggle1);
//
//		toggle1.click();
//
//		WebElement toggle2 = this.driver
//				.findElement(By.cssSelector("#tree-node > ol > li > ol > li:nth-child(2) > span > button > svg"));
//
//		this.driver.executeScript("arguments[0].scrollIntoView(true);", toggle2);
//
//		toggle2.click();
//
//		WebElement WorkspaceToggle = this.driver.findElement(By.cssSelector(
//				"#tree-node > ol > li > ol > li.rct-node.rct-node-parent.rct-node-expanded > ol > li:nth-child(1) > span > button > svg"));
//
//		this.driver.executeScript("arguments[0].scrollIntoView(true);", WorkspaceToggle);
//
//		WorkspaceToggle.click();
//
//		WebElement react = this.driver.findElement(By.cssSelector(
//				"#tree-node > ol > li > ol > li.rct-node.rct-node-parent.rct-node-expanded > ol > li.rct-node.rct-node-parent.rct-node-expanded > ol > li:nth-child(1) > span > label > span.rct-checkbox > svg"));
//
//		this.driver.executeScript("arguments[0].scrollIntoView(true);", react);
//
//		react.click();
//
//		WebElement output = this.driver.findElement(By.cssSelector("#result"));
//
//		Assertions.assertTrue(output.getText().contains("react"));
//
//	}

//
//	@AfterEach
//	void tearDown() {
////		this.driver.quit();
//	}
}
