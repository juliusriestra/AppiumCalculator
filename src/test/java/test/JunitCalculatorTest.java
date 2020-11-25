package test;


import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;


public class JunitCalculatorTest {
	
	public AppiumDriver<MobileElement> driver;
	MobileElement two,point,three,equal,resul,btnC;
	
	@Before
	public void setup() {
		
		try {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "moto e5_play");
		caps.setCapability(MobileCapabilityType.APP, "E:\\apk\\calculadoraQA.apk");
		caps.setCapability(MobileCapabilityType.UDID, "ZY322ZF3Q5");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, caps);
		
		}
		catch (Exception e) {
		System.out.println("Cause is: "+e.getCause());
		System.out.println("Message is: "+e.getMessage());
		e.printStackTrace();
		}
	}
	
	@Test
	public void junitCalculator() {
		System.out.println("I am begin demo test");
		two = driver.findElement(By.id("com.sample.foo.samplecalculator:id/buttonTwo"));
		point = driver.findElement(By.id("com.sample.foo.samplecalculator:id/buttonDot"));
		three = driver.findElement(By.id("com.sample.foo.samplecalculator:id/buttonThree"));
		equal = driver.findElement(By.id("com.sample.foo.samplecalculator:id/buttonEqual"));
		resul = driver.findElement(By.id("com.sample.foo.samplecalculator:id/infoTextView"));
		btnC = driver.findElement(By.className("android.widget.Button"));
		//btnC = driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.sample.foo.samplecalculator:id/buttonClear']")); 
		
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
	
	@After
	public void teardown() {
		driver.quit();
	}

}
