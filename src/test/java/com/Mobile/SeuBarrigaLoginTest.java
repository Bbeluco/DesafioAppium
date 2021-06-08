package com.Mobile;

import com.PageObjects.HomePage;
import com.PageObjects.Hooks;
import com.PageObjects.SeuBarrigaHomePage;
import com.PageObjects.SeuBarrigaLoginPage;
import org.junit.Assert;
import org.junit.Test;

public class SeuBarrigaLoginTest extends Hooks {
    SeuBarrigaLoginPage seuBarrigaLoginPage = new SeuBarrigaLoginPage();
    SeuBarrigaHomePage seuBarrigaHomePage = new SeuBarrigaHomePage();

    HomePage hp = new HomePage();
    @Test
    public void nao_deve_logar_usuario_invalido(){
        hp.clicarOpcao("SeuBarriga Híbrido");
        seuBarrigaLoginPage.getCampos();
        seuBarrigaLoginPage.login("bbeluco1@email.com", "12345688");

        Assert.assertTrue(seuBarrigaLoginPage.getMensagem("Problemas com o login do usuário"));
    }

    @Test
    public void deve_logar_usuario_valido(){
        hp.clicarOpcao("SeuBarriga Híbrido");
        seuBarrigaLoginPage.getCampos();
        seuBarrigaLoginPage.login(HomePage.EMAILVALIDO, HomePage.SENHA);

        Assert.assertTrue(seuBarrigaLoginPage.getMensagem("Bem vindo, "+HomePage.USERNAME+"!"));

        seuBarrigaHomePage.sair();
    }
}
