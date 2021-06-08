package com.Mobile;

import com.PageObjects.HomePage;
import com.PageObjects.Hooks;
import com.PageObjects.SwipePage;
import org.junit.Assert;
import org.junit.Test;

public class SwipeTest extends Hooks {
    HomePage hp = new HomePage();
    SwipePage swipePage = new SwipePage();

    @Test
    public void verificar_mensagens_ao_passar_para_o_lado_esquerdo() throws InterruptedException {
        swipePage.arrastarAteAOpcao("Swipe");
        hp.clicarOpcao("Swipe");
        Thread.sleep(1000);
        swipePage.arrastarParaEsquerda();
        swipePage.arrastarParaEsquerda();

        Assert.assertTrue(swipePage.isMensagemDisplayed("Chegar até o fim!"));
    }
}
