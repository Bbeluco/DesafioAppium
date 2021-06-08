package com.Mobile;

import com.PageObjects.HomePage;
import com.PageObjects.Hooks;
import com.PageObjects.SeuBarrigaCadastroPage;
import com.PageObjects.SeuBarrigaLoginPage;
import org.junit.Assert;
import org.junit.Test;

public class SeuBarrigaCadastroTest extends Hooks {

    HomePage hp = new HomePage();


    SeuBarrigaCadastroPage seuBarrigaCadastroPage = new SeuBarrigaCadastroPage();

    @Test
    public void nao_deve_cadastrar_usuario_ja_existente() throws InterruptedException {
        hp.clicarOpcao("SeuBarriga Híbrido");
        seuBarrigaCadastroPage.clicaCadastrar();
        seuBarrigaCadastroPage.getCamposCadastro();
        seuBarrigaCadastroPage.cadastrar(
                "Bruno", "bbeluco1@email.com", HomePage.SENHA);

        Assert.assertTrue(seuBarrigaCadastroPage.getMensagem("Endereço de email já utilizado"));
    }

    @Test
    public void deve_cadastrar_usuario_com_email_novo() {
        hp.clicarOpcao("SeuBarriga Híbrido");
        seuBarrigaCadastroPage.clicaCadastrar();
        seuBarrigaCadastroPage.getCamposCadastro();
        seuBarrigaCadastroPage.cadastrar(
                HomePage.USERNAME, "bbeluco" + System.nanoTime() +"@email.com", HomePage.SENHA);

        Assert.assertTrue(seuBarrigaCadastroPage.getMensagem("Usuário inserido com sucesso"));
    }


}
