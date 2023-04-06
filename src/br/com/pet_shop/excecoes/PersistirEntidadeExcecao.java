package br.com.pet_shop.excecoes;

public class PersistirEntidadeExcecao extends RuntimeException{

    public PersistirEntidadeExcecao() {
    }

    public PersistirEntidadeExcecao(String message) {
        super(message);
    }

    public PersistirEntidadeExcecao(String message, Throwable cause) {
        super(message, cause);
    }
}
