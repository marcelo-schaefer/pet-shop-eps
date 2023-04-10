package br.com.pet_shop.servicos.interfaces;

public interface ServicoInterface<T> {

    T criar();

    T atualizar();

    T buscarPorId();

    Boolean deletarPorId();
}
