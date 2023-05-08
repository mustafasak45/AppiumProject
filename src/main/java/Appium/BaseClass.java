package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseClass {
    @Test
    public AndroidDriver getAndroidDriver() throws MalformedURLException {
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"7.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UIAutomator2");
        capabilities.setCapability("noReset","true");
        capabilities.setCapability("appPackage","com.touchboarder.android.api.demos"); // cmd ekranında adb , cihazda uygulamayı aç,sonra bunu yaz dumpsys window | grep -E "mCurrentFocus"
        capabilities.setCapability("appActivity","com.touchboarder.androidapidemos.MainActivity");

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        return driver;
    }
}
