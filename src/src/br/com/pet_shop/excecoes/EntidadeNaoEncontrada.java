package br.com.pet_shop.excecoes;

public class EntidadeNaoEncontrada extends RuntimeException {

    public EntidadeNaoEncontrada(String message) {
        super(message);
    }

    public EntidadeNaoEncontrada(String message, Throwable cause) {
        super(message, cause);
    }
}
