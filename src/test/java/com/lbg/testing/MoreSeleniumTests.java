package com.lbg.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MoreSeleniumTests {

	private RemoteWebDriver driver;

	@BeforeEach // runs before EACH test
	void init() {
		// creates a new chrome window
		ChromeOptions opts = new ChromeOptions();
//			opts.addArguments("--headless=new");

		this.driver = new ChromeDriver(opts);
		// sets it to fullscreen
		this.driver.manage().window().maximize();
	}

//		@Test
	void seleniumTest() {
		// opens bing.com
		this.driver.get("http://www.bing.com");
	}

	@Test
	void textBoxTest() {
		this.driver.get("https://demoqa.com/text-box");

		WebElement consent = this.driver.findElement(By.cssSelector(
				"body > div.fc-consent-root > div.fc-dialog-container > div.fc-dialog.fc-choice-dialog > div.fc-footer-buttons-container > div.fc-footer-buttons > button.fc-button.fc-cta-consent.fc-primary-button"));
		consent.click();

		WebElement fullName = this.driver.findElement(By.id("userName"));
		fullName.sendKeys("Barry");

		WebElement email = this.driver.findElement(By.cssSelector("#userEmail"));
		email.sendKeys("J@H.com");

		WebElement currentAddress = this.driver.findElement(By.cssSelector("#currentAddress"));
		currentAddress.sendKeys("123 fake street");

		WebElement permanentAddress = this.driver.findElement(By.cssSelector("#permanentAddress"));
		permanentAddress.sendKeys("123 fake street");

		WebElement submit = this.driver.findElement(By.id("submit"));
//			this.driver.executeScript("arguments[0].scrollIntoView(true);", submit);
		submit.click();

		WebElement display = this.driver.findElement(By.id("name"));

		assertEquals(true, display.getText().contains("Barry"));

		WebElement emailDisplay = this.driver.findElement(By.cssSelector("#email"));
		assertEquals("Email:J@H.com", emailDisplay.getText());

		WebElement currentAddressDisplay = this.driver.findElement(By.cssSelector("#output #currentAddress"));
		assertEquals("Current Address :123 fake street", currentAddressDisplay.getText());

		WebElement permanentAddressDisplay = this.driver.findElement(By.cssSelector("#output #permanentAddress"));
		assertEquals("Permananet Address :123 fake street", permanentAddressDisplay.getText());

	}

	@Test
	void testCheckBox() {
		this.driver.get("https://demoqa.com/checkbox");

		WebElement consent = this.driver.findElement(By.cssSelector(
				"body > div.fc-consent-root > div.fc-dialog-container > div.fc-dialog.fc-choice-dialog > div.fc-footer-buttons-container > div.fc-footer-buttons > button.fc-button.fc-cta-consent.fc-primary-button"));
		consent.click();

		WebElement homeArrow = this.driver.findElement(By.cssSelector("#tree-node > ol > li > span > button > svg"));
		homeArrow.click();

		WebElement docsArrow = this.driver
				.findElement(By.cssSelector("#tree-node > ol > li > ol > li:nth-child(2) > span > button > svg"));
		docsArrow.click();

		WebElement workArrow = this.driver.findElement(By.cssSelector(
				"#tree-node > ol > li > ol > li.rct-node.rct-node-parent.rct-node-expanded > ol > li:nth-child(1) > span > button > svg"));
		workArrow.click();

		WebElement react = this.driver.findElement(By.cssSelector(
				"#tree-node > ol > li > ol > li.rct-node.rct-node-parent.rct-node-expanded > ol > li.rct-node.rct-node-parent.rct-node-expanded > ol > li:nth-child(1) > span > label > span.rct-checkbox > svg"));
		react.click();

		WebElement output = this.driver.findElement(By.cssSelector("#result"));

		assertTrue(output.getText().contains("react"));

		WebElement checked = this.driver.findElement(By.cssSelector(
				"#tree-node > ol > li > ol > li.rct-node.rct-node-parent.rct-node-expanded > ol > li.rct-node.rct-node-parent.rct-node-expanded > ol > li:nth-child(1) > span > label > span.rct-checkbox > svg"));

		// check that the svg does NOT have the 'uncheck' class
		assertFalse(checked.getAttribute("class").contains("uncheck"));
	}

//	@AfterEach
//	void tearDown() {
//		this.driver.quit();
//	}
}
