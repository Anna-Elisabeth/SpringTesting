package com.lbg.testing2;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWaitTest {

	private RemoteWebDriver driver;
	private WebDriverWait wait;

	@BeforeEach
	void init() {
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();

//		// Implicit Wait does not work here because the element <p> is there but it does not know to wait for the text that will appear later
//		ie - always will expect an empty p tag

		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5_000));

	}

	@Test
	void test() {
		this.driver.get("http://127.0.0.1:5500/arrays/testing/test.html");

		WebElement title = this.driver.findElement(By.tagName("h1"));
		Assertions.assertEquals("The Delay Method", title.getText());

		WebElement subTitle = this.driver.findElement(By.id("yummy"));
		Assertions.assertEquals("Lots of lovely cheese", subTitle.getText());

		WebElement cheeseTypes = this.driver.findElement(By.cssSelector("#cheesy"));
		new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.textToBePresentInElement(cheeseTypes, "Cheese types: edamandwensleydale"));

		Assertions.assertEquals("Cheese types: edamandwensleydale", cheeseTypes.getText());

	}

}
