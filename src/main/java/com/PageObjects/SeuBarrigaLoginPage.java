package com.PageObjects;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeuBarrigaLoginPage extends BasePage{
    private MobileElement email;
    private MobileElement senha;
    private MobileElement mensagem;

    public void getCampos(){
        email = (MobileElement) getDriver().findElement(MobileBy.xpath("//android.widget.EditText[@index='1']"));
        senha = (MobileElement) getDriver().findElement(MobileBy.xpath("//android.widget.EditText[@index='3']"));
    }

    public void preencheCampos(String email, String senha){
        this.email.setValue(email);
        this.senha.setValue(senha);
    }

    public void login(String email, String senha){
        preencheCampos(email, senha);
        clicarPorTexto("Entrar");
    }

    public boolean getMensagem(String msg) {
        By condicao = By.xpath("//*[@text='"+msg+"']");

        WebDriverWait espera = new WebDriverWait(getDriver(), 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(condicao));
        mensagem = (MobileElement) getDriver().findElement(condicao);

        return mensagem.isDisplayed();
    }
}
