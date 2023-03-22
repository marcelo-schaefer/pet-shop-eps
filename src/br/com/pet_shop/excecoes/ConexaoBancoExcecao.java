package br.com.pet_shop.excecoes;

public class ConexaoBancoExcecao extends RuntimeException {

    public ConexaoBancoExcecao(Throwable throwable) {
        super(throwable);
    }

    public ConexaoBancoExcecao(String message, Throwable throwable) {
        super(message, throwable);
    }
}
