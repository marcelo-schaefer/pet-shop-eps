package br.com.pet_shop.repositorio;

import br.com.pet_shop.entidades.Animal;
import br.com.pet_shop.repositorio.interfaces.AnimalRepositorioInterface;

import java.util.List;
import java.util.Optional;

public class AnimalRepositorio implements AnimalRepositorioInterface {

    @Override
    public Boolean criar(Animal entidade) {
        return null;
    }

    @Override
    public Boolean atualizar(Animal entidade) {
        return null;
    }

    @Override
    public Optional<Animal> buscarPorId(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Animal> buscar() {
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
