package br.com.pet_shop.excecoes;

public class ConverterTipoExcecao extends RuntimeException {

    public ConverterTipoExcecao(String message, Throwable throwable) {
        super(message, throwable);
    }
}
