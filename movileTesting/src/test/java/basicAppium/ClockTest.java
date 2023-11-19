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

public class ClockTest {
    AppiumDriver mobile;
    @BeforeEach
    public void openApp() throws MalformedURLException {
        DesiredCapabilities config = new DesiredCapabilities();
        config.setCapability("deviceName","EmuladorTS");
        config.setCapability("platformVersion","11.0");
        config.setCapability("appPackage","com.google.android.deskclock");
        config.setCapability("appActivity","com.android.deskclock.DeskClock");
        config.setCapability("platformName","Android");
        config.setCapability("automationName","uiautomator2");
        mobile = new AndroidDriver(new URL(" http://127.0.0.1:4723/wd/hub"),config);
        // esperadores de tiempo
        // implicit tiempo limite de espera por cada boton, es una regla para los controladores
        // explicit es un tiempo especifico para un control, tiene tiempo de espera mas una condicion
        // fluent para aquellos botones que aparecen y desaparecen
        mobile.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }
    @Test
    public void verifySomething() throws InterruptedException {

        //Seleccionar alarma
        mobile.findElement(By.xpath("\t\n" +
                "//android.widget.TextView[@text=\"Alarm\"]")).click();

        // click en mas
        mobile.findElement(By.xpath("\t\n" +
                "//android.widget.ImageButton[@content-desc=\"Add alarm\"]")).click();

        // click seleccionar hora 6
        mobile.findElement(By.xpath("\t\n" +
                "\t\n" +
                "//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc=\"6\"]")).click();

        // click seleccionar minutos 45
        mobile.findElement(By.xpath("\t\n" +
                "//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc=\"45\"]")).click();

        // click seleccionar AM
        mobile.findElement(By.xpath("\t\n" +
                "//android.widget.RadioButton[@resource-id=\"android:id/am_label\"]")).click();

        // click en ok
        mobile.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click();
        // click seleccionar flechita subir
        mobile.findElement(By.xpath("\t\n" +
                "//android.widget.ImageButton[@content-desc=\"Collapse alarm\"]")).click();

        Thread.sleep(5000);
        // verificacion
        String expectedResult = "";
        String actualResult = mobile.findElement(By.xpath("//android.widget.TextView[@content-desc='6:45 AM']")).getText();
        Assertions.assertEquals(expectedResult,actualResult,"Error de alarma");


    }

    @AfterEach
    public void closeApp(){
        mobile.quit();
    }

}
