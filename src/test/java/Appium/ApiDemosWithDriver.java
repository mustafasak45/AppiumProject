package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class ApiDemosWithDriver extends BaseClass{

  //  DesiredCapabilities capabilities=new DesiredCapabilities();
/*@BeforeClass
public void beforeClass(){

    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"7.0");
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UIAutomator2");
    capabilities.setCapability("noReset","true");
    capabilities.setCapability("appPackage","com.touchboarder.android.api.demos"); // cmd ekranında adb , cihazda uygulamayı aç,sonra bunu yaz dumpsys window | grep -E "mCurrentFocus"
    capabilities.setCapability("appActivity","com.touchboarder.androidapidemos.MainActivity");
}*/

    @Test
    public void testLogin() throws MalformedURLException, InterruptedException  {
        AndroidDriver<MobileElement> driver=getAndroidDriver();//method ile BaseClass tan capabilitiesleri alıyoruz
   // AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver , 10);

    MobileElement apiDemos = driver.findElementByXPath("//android.widget.TextView[@text='API Demos']");
        wait.until(ExpectedConditions.elementToBeClickable(apiDemos)).click();

    MobileElement preference = driver.findElementByXPath("//android.widget.TextView[@text='Preference']");
        wait.until(ExpectedConditions.elementToBeClickable(preference)).click();

    MobileElement ucuncuPreferenceDependencies = driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']");
        wait.until(ExpectedConditions.elementToBeClickable(ucuncuPreferenceDependencies)).click();

        MobileElement wifiSettings = driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']");
        //wifi settings seçeneği seçeneğinin enable olup olmadığını kontrol etmek için önceden tanımladım

    if (wifiSettings.isEnabled()==false){
        MobileElement wifiCheckBox = driver.findElementById("android:id/checkbox");
        wait.until(ExpectedConditions.elementToBeClickable(wifiCheckBox)).click();
    }
        wait.until(ExpectedConditions.elementToBeClickable(wifiSettings)).click();

    MobileElement wifiSettingsTextBox = driver.findElementById("android:id/edit");
        wait.until(ExpectedConditions.elementToBeClickable(wifiSettingsTextBox)).click();
        wifiSettingsTextBox.sendKeys("TextAppium", Keys.ENTER);

    MobileElement tamamButton = driver.findElementById("android:id/button1");
        wait.until(ExpectedConditions.elementToBeClickable(tamamButton)).click();

        driver.closeApp();

}

}
