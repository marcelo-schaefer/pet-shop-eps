package br.com.pet_shop.servicos.interfaces;

public interface ServicoInterface<T> {

    void criar();

    void atualizar();

    void buscarTudo();

    void buscarPorId();

    void deletarPorId();

    void exibir(T entidade);
}
