package br.com.pet_shop;

import br.com.pet_shop.tela.dados.JOptionPaneTela;
import br.com.pet_shop.tela.menu.MenuTela;

public class RunApp {

    public static void main(String[] args) {
        try {
            MenuTela.menuPrincipal();
        } catch (Exception exception) {
            JOptionPaneTela.optionMensagemAlerta(
                "Ocorreu um erro",
                exception.getMessage()
            );
        }
    }
}