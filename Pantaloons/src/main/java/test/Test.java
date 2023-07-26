package test;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;



public class Test {
	public static void main(String[] args) throws Throwable {
		DesiredCapabilities caps = new DesiredCapabilities();
//		caps.setCapability("udid", "RZ8T60DLKYZ");
//		caps.setCapability("deviceName", "a13nnxx");
//		caps.setCapability("platformName", "Android");
//		caps.setCapability("platformVersion", "12");
		
		AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4725/wd/hub"),caps);
		driver.openNotifications();
		String text = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message_text']")).getText();
		System.out.println(text);
	}

}
