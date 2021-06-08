package com.PageObjects;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeuBarrigaHomePage extends BasePage{
    private MobileElement contasBotao;
    private MobileElement campoConta;
    private MobileElement mensagem;
    private MobileElement botaoSair;

    public void clicarContas() {
        contasBotao = (MobileElement) getDriver().findElement(MobileBy.xpath("//android.widget.Spinner[@index='0']"));
        contasBotao.click();
    }

    public void clicarAdicionarContas(){
        clicarPorTexto("Adicionar");
    }

    private void getCampoConta(){
        campoConta = (MobileElement) getDriver().findElement(MobileBy.xpath("//android.widget.EditText[@index='1']"));
    }

    public void cadastrarCampoConta(String nomeConta){
        getCampoConta();
        campoConta.setValue(nomeConta);
        clicarBotao();
    }

    public void clicarBotao(){
        clicarPorTexto("Salvar");
    }

    public boolean getMensagem(String msg){
        By condicao = By.xpath("//*[@text='"+msg+"']");

        WebDriverWait espera = new WebDriverWait(getDriver(), 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(condicao));
        mensagem = (MobileElement) getDriver().findElement(condicao);

        return mensagem.isDisplayed();
    }

    public void sair(){
        botaoSair = (MobileElement) getDriver().findElement(MobileBy.xpath("//android.widget.TextView[@index='0']"));
    }
}
