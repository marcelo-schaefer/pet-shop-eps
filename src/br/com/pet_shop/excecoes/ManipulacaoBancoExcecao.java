package br.com.pet_shop.excecoes;

public class ManipulacaoBancoExcecao extends RuntimeException {

    public ManipulacaoBancoExcecao(String message) {
        super(message);
    }

    public ManipulacaoBancoExcecao(Throwable throwable) {
        super(throwable);
    }

    public ManipulacaoBancoExcecao(String message, Throwable throwable) {
        super(message, throwable);
    }
}