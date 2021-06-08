package com.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;



public class BasePage  {

    protected static AppiumDriver driver;


     public static AppiumDriver getDriver() {
         if(driver == null) {
             try {
                 criarDriverAppium();
             } catch (MalformedURLException e) {
                 e.printStackTrace();
             }
         }
         return driver;
     }

     public static void killDriver()
     {
         if(driver != null){
             driver.quit();
             driver = null;
         }

     }



    private static void criarDriverAppium() throws MalformedURLException {
        File apk = new File("C:\\Users\\Bruno\\Documents\\TestesMobile\\src\\main\\resources\\CTAppium_1_2.apk");
        DesiredCapabilities configuracoes = new DesiredCapabilities();
        configuracoes.setCapability(MobileCapabilityType.APP, apk.getAbsolutePath());
        configuracoes.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        configuracoes.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        configuracoes.setCapability(MobileCapabilityType.NO_RESET,true);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),configuracoes);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void clicarPorTexto (String texto){
         getDriver().findElement(By.xpath("//*[@text='"+texto+"']")).click();
    }
    public static String obterTexto(By by){
         return  getDriver().findElement(by).getText();
    }
    public static void clicarBotao(By by) {
        getDriver().findElement(by).click();
    }
}
