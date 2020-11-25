package test;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class CalculatorTest {
	
	static  AppiumDriver<MobileElement> driver;
	
	public static void main(String[] args) {
		try {
			openCalculator();
		} catch (Exception e) {
			System.out.println("Cause is: "+e.getCause());
			System.out.println("Message is: "+e.getMessage());
			e.printStackTrace();
		}
	}

	public static void openCalculator() throws Exception {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "moto e5_play");
		caps.setCapability(MobileCapabilityType.APP, "E:\\apk\\calculadoraQA.apk");
		caps.setCapability(MobileCapabilityType.UDID, "ZY322ZF3Q5");
		
		 URL url = new URL("http://127.0.0.1:4723/wd/hub");
		 driver = new AppiumDriver<MobileElement>(url, caps);
		 
		 System.out.println("Application Started...");
		 
		 MobileElement two = driver.findElement(By.id("com.sample.foo.samplecalculator:id/buttonTwo"));
		 MobileElement point = driver.findElement(By.id("com.sample.foo.samplecalculator:id/buttonDot"));
		 MobileElement three = driver.findElement(By.id("com.sample.foo.samplecalculator:id/buttonThree"));
		 MobileElement equal = driver.findElement(By.id("com.sample.foo.samplecalculator:id/buttonEqual"));
		 MobileElement resul = driver.findElement(By.id("com.sample.foo.samplecalculator:id/infoTextView"));
		 
		 two.click();
		 point.click();
		 three.click();
		 equal.click();
		 String res = resul.getText();
		 
		 System.out.println("\n Result is :" + res);
		 System.out.println("Completed...");
		 
		 driver.quit();
	}
}
