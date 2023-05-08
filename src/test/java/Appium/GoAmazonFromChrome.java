package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GoAmazonFromChrome {
    DesiredCapabilities capabilities=new DesiredCapabilities();
    @BeforeClass
    public void beforeClass() {
        /*   Bu 3 satırdaki kodda ayı işi yapıyor...

        capabilities.setCapability("platformName","Android");
        capabilities.setCapability(CapabilityType.PLATFORM_NAME,"Android");*/
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"7.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UIAutomator2");
        capabilities.setCapability("noReset","true");
        capabilities.setCapability("appPackage","com.android.chrome"); // cmd ekranında adb , cihazda uygulamayı aç,sonra bunu yaz dumpsys window | grep -E "mCurrentFocus"
        capabilities.setCapability("appActivity","com.google.android.apps.chrome.Main");

    }

    @Test
    public void test01() throws MalformedURLException, InterruptedException {
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        MobileElement searchBoxofGoogle =driver.findElementById("com.android.chrome:id/search_box_text");

        Actions actions= new Actions(driver);
        searchBoxofGoogle.sendKeys("amazon");
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(5000);
        MobileElement amazonLink =driver.findElementByXPath("//android.view.View[@text='Amazon.com.tr Türkiye’de - Uygun fiyatlar ve hızlı kargo']");

        amazonLink.click();

    }
}
