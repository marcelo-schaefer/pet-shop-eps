package br.com.pet_shop;

import br.com.pet_shop.banco.ConexaoBanco;
import br.com.pet_shop.tela.dados.JOptionPaneTela;
import br.com.pet_shop.tela.menu.MenuTela;

public class RunApp {

    public static final String CAMINHO_ARQUIVO_CRIACAO_BASE = "C:\\Users\\lucas\\intellij-projects\\pet-shop-eps\\src\\sql\\criar_banco.sql";

    public static void main(String[] args) {
        try {
            ConexaoBanco.criarBanco();

            MenuTela.menuPrincipal();
        } catch (Exception exception) {
            JOptionPaneTela.optionMensagemAlerta(
                "Ocorreu um erro",
                exception.getMessage()
            );

            throw exception;
        }
    }
}
