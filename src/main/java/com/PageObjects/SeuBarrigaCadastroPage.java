package com.PageObjects;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SeuBarrigaCadastroPage extends BasePage{
    private MobileElement nome;
    private MobileElement email;
    private MobileElement senha;
    private MobileElement mensagem;

    public void clicaCadastrar() {
        getDriver().findElement(By.xpath("//*[@text='Novo usuário?']")).click();
    }

    public void getCamposCadastro(){
        nome = (MobileElement) getDriver().findElement(MobileBy.xpath("//android.widget.EditText[@index='1']"));
        email = (MobileElement) getDriver().findElement(MobileBy.xpath("//android.widget.EditText[@index='3']"));
        senha = (MobileElement) getDriver().findElement(MobileBy.xpath("//android.widget.EditText[@index='5']"));
    }

    private void preencherCamposCadastro(String nome, String email, String senha) {
        this.nome.setValue(nome);
        this.email.setValue(email);
        this.senha.setValue(senha);
    }

    public void cadastrar(String nome, String email, String senha) {
        preencherCamposCadastro(nome, email, senha);
        clicarPorTexto("Cadastrar");
    }

    public boolean getMensagem(String msg) {
        By condicao = By.xpath("//*[@text='"+msg+"']");

        WebDriverWait espera = new WebDriverWait(getDriver(), 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(condicao));
        mensagem = (MobileElement) getDriver().findElement(condicao);

        return mensagem.isDisplayed();
    }

}
