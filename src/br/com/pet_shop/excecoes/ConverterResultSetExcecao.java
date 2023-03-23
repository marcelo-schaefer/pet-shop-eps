package br.com.pet_shop.excecoes;

public class ConverterResultSetExcecao extends RuntimeException {

    public ConverterResultSetExcecao(String message, Throwable throwable) {
        super(message, throwable);
    }
}
