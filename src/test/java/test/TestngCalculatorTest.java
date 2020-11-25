package test;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeClass;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TestngCalculatorTest {
  
	public AppiumDriver<MobileElement> driver;
	public MobileElement name,two,point,three,equal,resul, btnC;
	
  @BeforeClass
  public void beforeClass() {
	 try {
		
		DesiredCapabilities caps = new DesiredCapabilities();
			
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "moto e5_play");
		caps.setCapability(MobileCapabilityType.APP, "E:\\apk\\calculadoraQA.apk");
		caps.setCapability(MobileCapabilityType.UDID, "ZY322ZF3Q5");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, caps);
		
	} catch (Exception e) {
		System.out.println("Cause is: "+e.getCause());
		System.out.println("Message are: "+e.getMessage());
		e.printStackTrace();
	}
  }

  @Test
  public void testngCalculator() {
	  name = driver.findElement(By.className("android.widget.TextView"));
	  two = driver.findElement(By.id("com.sample.foo.samplecalculator:id/buttonTwo"));
	  point = driver.findElement(By.id("com.sample.foo.samplecalculator:id/buttonDot"));
	  three = driver.findElement(By.id("com.sample.foo.samplecalculator:id/buttonThree"));
	  equal = driver.findElement(By.id("com.sample.foo.samplecalculator:id/buttonEqual"));
	  resul = driver.findElement(By.id("com.sample.foo.samplecalculator:id/infoTextView"));
	  btnC = driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.sample.foo.samplecalculator:id/buttonClear']")); 
	
	  String myName = name.getText();
	  Assert.assertEquals(myName, "SampleCalculator");
	  System.out.println("\n App started with name :" + myName);
	  two.click();
	  point.click();
	  three.click();
	  equal.click();
	  String res = resul.getText();
		 
	  System.out.println("\n Result is :" + res);
	  System.out.println("Completed...");
	  
	  btnC.click();
	  btnC.click();
	  btnC.click();
	  
	  System.out.println("Clean...");
  }
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
