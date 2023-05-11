package br.com.pet_shop.excecoes;

public class ConsultarEntidadeExcecao extends RuntimeException{

    public ConsultarEntidadeExcecao() {
    }

    public ConsultarEntidadeExcecao(String message) {
        super(message);
    }

    public ConsultarEntidadeExcecao(String message, Throwable cause) {
        super(message, cause);
    }
}
