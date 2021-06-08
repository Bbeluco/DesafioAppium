package com.PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.time.Duration;

public class SwipePage extends BasePage{
    private MobileElement mensagem;

    public void arrastarAteAOpcao(String texto){
        ((AndroidDriver<MobileElement>) getDriver()).findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""+texto+"\").instance(0))");
    }

    public void arrastarParaEsquerda(){
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(650, 549))
                .moveTo(PointOption.point(20,549)).release().perform();
    }

    public boolean isMensagemDisplayed(String texto){
        mensagem = (MobileElement) getDriver().findElement(By.xpath("//*[@text='"+texto+"']"));
        return mensagem.isDisplayed();
    }
}
