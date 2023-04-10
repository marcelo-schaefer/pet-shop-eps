package br.com.pet_shop.repositorio;

import br.com.pet_shop.banco.ConexaoBanco;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public abstract class RepositorioAbstract<T> {

    abstract Boolean criar(T entidade);

    abstract Boolean atualizar(T entidade);

    abstract Optional<T> buscarPorId(Integer id);

    abstract T buscarUltimo();

    abstract List<T> buscarTodos();

    abstract Boolean deletarPorId(Integer id);

    abstract Boolean deletarTodos();

    abstract Boolean existePorID(Integer id);

    protected Connection conectarBanco() {
        return ConexaoBanco.pegarConexao();
    }
}
