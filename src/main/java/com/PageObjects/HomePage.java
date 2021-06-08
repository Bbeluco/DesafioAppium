package com.PageObjects;



public class HomePage extends BasePage {

    public static final String EMAILVALIDO = "bbeluco1@email.com";
    public static final String USERNAME = "Bruno";
    public static final String SENHA = "123456";

    public void clicarOpcao (String opcao) {
        clicarPorTexto(opcao);
    }

}
