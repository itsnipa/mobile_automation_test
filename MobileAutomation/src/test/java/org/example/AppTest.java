package org.example;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        File f = new File("src/test/resources");
        File apk_general_store = new File(f, "General-Store.apk");

        var options = new BaseOptions()
                .amend("platformName", "android")
                .amend("appium:automationName", "UiAutomator2")
                .amend("appium:deviceName", "local")
                .amend("appium:udid", "emulator-5554")
                .amend("appium:app", apk_general_store.getAbsoluteFile())
                .amend("appium:appPackage", "com.androidsample.generalstore")
                .amend("appium:appActivity", "com.androidsample.generalstore.SplashActivity");


        URL remoteURL = new URL("http://127.0.0.1:4723");
        driver = new AndroidDriver(remoteURL, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void sampleTest() throws InterruptedException {
        var el1 = driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry"));
        el1.click();

        final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        var start = new Point(688, 2291);
        var end = new Point (769, 1398);
        var swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), start.getX(), start.getY()));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                PointerInput.Origin.viewport(), end.getX(), end.getY()));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipe));

        WebElement nepalOption = driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Nepal\"))"));
        nepalOption.click();
        //        var el2 = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Angola\"]"));
//        el2.click();
        var el3 = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField"));
        el3.sendKeys("Hello");
        var el4 = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale"));
        el4.click();
        var el5 = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop"));
        el5.click();
        Thread.sleep(5000);

    }


    @AfterMethod
    public void tearDown() {
        driver.removeApp("com.androidsample.generalstore");
//        driver.quit();
    }
}
