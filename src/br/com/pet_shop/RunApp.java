package br.com.pet_shop;

import br.com.pet_shop.tela.ClienteTela;

public class RunApp {

    public static void main(String[] args) {
        var cliente = ClienteTela.criar();

		System.err.println(cliente);
    }
}
