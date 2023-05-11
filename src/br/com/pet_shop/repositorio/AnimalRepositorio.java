package br.com.pet_shop.repositorio;

import br.com.pet_shop.entidades.Animal;

import java.util.List;
import java.util.Optional;

public class AnimalRepositorio extends RepositorioAbstract<Animal> {

    @Override
    public Animal criar(Animal entidade) {
        return null;
    }

    @Override
    public Animal atualizar(Animal entidade) {
        return null;
    }

    @Override
    public Optional<Animal> buscarPorId(Integer id) {
        return Optional.empty();
    }

    @Override
    public Optional<Animal> buscarUltimo() {
        return null;
    }

    @Override
    public List<Animal> buscarTodos() {
        return null;
    }

    @Override
    public Boolean deletarTodos() {
        return null;
    }

    @Override
    public Boolean deletarPorId(Integer id) {
        return null;
    }

    @Override
    public Boolean existePorID(Integer id) {
        return null;
    }
}
