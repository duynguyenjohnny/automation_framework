package com.mediastep.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class appium_multiple_test
{
	WebDriver driver;

	@BeforeTest
	public void setUp() throws MalformedURLException {
		
		//Created object of DesiredCapabilities class
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		//The kind of mobile device or emulator to use - iPad Simulator, iPhone Retina 4-inch, Android Emulator, Galaxy S4 etc
		//Find your device name by running command 'adb devices' from command prompt
		capabilities.setCapability("deviceName", "SCL24");
	
		//Which mobile OS platform to use - iOS, Android, or FirefoxOS
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion","5.0.1");
		//Java package of the Android app you want to run- Ex: com.example.android.myApp
		//For Android calculator app, package name is 'com.android.calculator2'
		capabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");

		//Activity name for the Android activity you want to launch from your package
		//For Android calculator app, Activity name is 'com.android.calculator2.Calculator'
		capabilities.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
		
		// Initialize the driver object with the URL to Appium Server and pass capabilities
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void Sum() {

		System.out.println("Calculate sum of two numbers");
		//Locate elements using By.name() to enter data and click +/= buttons
		driver.findElement(By.name("1")).click();
		driver.findElement(By.name("+")).click();
		driver.findElement(By.name("2")).click();
		driver.findElement(By.name("=")).click();
		
		// Get the result text
		WebElement sumOfNumbersEle = driver.findElement(By.className("android.widget.EditText"));
		String sumOfNumbers = sumOfNumbersEle.getText();
		System.out.println(sumOfNumbers);
		//verify if result is 3
		Assert.assertTrue(sumOfNumbers.contains("=3"));
	}

	@AfterTest
	public void End() {
		driver.quit();
	}
}
