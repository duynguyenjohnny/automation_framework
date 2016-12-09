package com.mediastep.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.firefox.FirefoxDriver;		
import org.openqa.selenium.remote.DesiredCapabilities;
public class AutoIT_test {	
	//protected static WebDriver driver;
public static void main(String[] args) throws IOException {		
	
//	System.out.println(" Executing on FireFox");
//	System.setProperty("webdriver.gecko.driver", "webdrivers//geckodriver.exe");
//	driver = new FirefoxDriver();
	System.setProperty("webdriver.firefox.marionette", "webdrivers//geckodriver.exe");
	//DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	//capabilities.setCapability("marionette", true);
	//WebDriver driver = new FirefoxDriver(capabilities);
    WebDriver driver=new FirefoxDriver();			
    driver.navigate().to("http://www.upsieutoc.com/");		
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);			
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);			
	driver.manage().window().maximize();
    driver.findElement(By.xpath(".//*[@id='top-bar']/div/ul[2]/li[1]/span/span[2]")).click();			
    driver.findElement(By.xpath(".//*[@id='anywhere-upload']/div[1]/div/div[1]/div/div[1]/span")).click();							
    // below line execute the AutoIT script .
     Runtime.getRuntime().exec("E:\\fileupload.exe");		
    //driver.findElement(By.id("input_6")).sendKeys("AutoIT in Selenium");					
    driver.findElement(By.xpath(".//*[@id='anywhere-upload-submit']/div[1]/button[2]")).click();
    driver.close();
     }
}
