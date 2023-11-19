package basicAppium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class WhenDoCreateTest {
    AppiumDriver mobile;
    @BeforeEach
    public void openApp() throws MalformedURLException {
        DesiredCapabilities config = new DesiredCapabilities();
        config.setCapability("deviceName","EmuladorTS");
        config.setCapability("platformVersion","11.0");
        config.setCapability("appPackage","com.splendapps.splendo");
        config.setCapability("appActivity","com.splendapps.splendo.MainActivity");
        config.setCapability("platformName","Android");
        config.setCapability("automationName","uiautomator2");
        mobile = new AndroidDriver(new URL(" http://127.0.0.1:4723/wd/hub"),config);
        mobile.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
    @Test
    public void verifyCreateTaskTest() throws InterruptedException {

        String nameTask ="Task1";
        //click en agregar
        mobile.findElement(By.id("com.splendapps.splendo:id/fabAddTask")).click();
        // click en task
        mobile.findElement(By.id("com.splendapps.splendo:id/edtTaskName")).sendKeys(nameTask);
        // click en fecha
        mobile.findElement(By.id("com.splendapps.splendo:id/edtDueD")).click();
        // click en dia
        mobile.findElement(By.xpath("//android.view.View[@content-desc='20 November 2023']")).click();
        // click en ok
        mobile.findElement(By.id("android:id/button1")).click();
        // click en guardar
        mobile.findElement(By.id("com.splendapps.splendo:id/fabSaveTask")).click();

        Thread.sleep(5000);
        // verificar
        Assertions.assertTrue(mobile.findElements(By.xpath("//android.widget.TextView[@text='"+nameTask+"']")).size()==1,"Error> la tarea no fue creada");

    }

    @AfterEach
    public void closeApp(){
        mobile.quit();
    }

}
