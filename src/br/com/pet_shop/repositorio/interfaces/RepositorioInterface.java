package br.com.pet_shop.repositorio.interfaces;

import java.util.List;
import java.util.Optional;

public interface RepositorioInterface<T> {

    Boolean criar(T entidade);

    Boolean atualizar(T entidade);

    Optional<T> buscarPorId(Integer id);

    List<T> buscar();

    Boolean deletar();

    Boolean deletarPorId(Integer id);
}
