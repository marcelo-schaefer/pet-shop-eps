package br.com.pet_shop.repositorio;

import br.com.pet_shop.entidades.Especie;
import br.com.pet_shop.repositorio.interfaces.EspecieRepositorioInterface;

import java.util.List;
import java.util.Optional;

public class EspecieRepositorio implements EspecieRepositorioInterface {

    @Override
    public Boolean criar(Especie entidade) {
        return null;
    }

    @Override
    public Boolean atualizar(Especie entidade) {
        return null;
    }

    @Override
    public Optional<Especie> buscarPorId(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Especie> buscar() {
        return null;
    }

    @Override
    public Boolean deletar() {
        return null;
    }

    @Override
    public Boolean deletarPorId(Integer id) {
        return null;
    }
}
