package com.Mobile;

import com.PageObjects.HomePage;
import com.PageObjects.Hooks;
import com.PageObjects.SeuBarrigaHomePage;
import com.PageObjects.SeuBarrigaLoginPage;
import org.junit.Assert;
import org.junit.Test;

public class SeuBarrigaContasTest extends Hooks {

    HomePage hp = new HomePage();
    SeuBarrigaLoginPage seuBarrigaLoginPage = new SeuBarrigaLoginPage();
    SeuBarrigaHomePage seuBarrigaHomePage = new SeuBarrigaHomePage();

    @Test
    public void deve_criar_conta_nome_novo(){
        hp.clicarOpcao("SeuBarriga Híbrido");
        seuBarrigaLoginPage.getCampos();
        seuBarrigaLoginPage.login(HomePage.EMAILVALIDO, HomePage.SENHA);
        seuBarrigaHomePage.clicarContas();
        seuBarrigaHomePage.clicarAdicionarContas();
        seuBarrigaHomePage.cadastrarCampoConta("conta"+System.nanoTime());

        Assert.assertTrue(seuBarrigaHomePage.getMensagem("Conta adicionada com sucesso!"));

        seuBarrigaHomePage.sair();
    }

    @Test
    public void nao_deve_criar_conta_com_nome_repetido(){
        hp.clicarOpcao("SeuBarriga Híbrido");
        seuBarrigaLoginPage.getCampos();
        seuBarrigaLoginPage.login(HomePage.EMAILVALIDO, HomePage.SENHA);
        seuBarrigaHomePage.clicarContas();
        seuBarrigaHomePage.clicarAdicionarContas();
        seuBarrigaHomePage.cadastrarCampoConta("Conta de água");

        Assert.assertTrue(seuBarrigaHomePage.getMensagem("Já existe uma conta com esse nome!"));

        seuBarrigaHomePage.sair();
    }
}
