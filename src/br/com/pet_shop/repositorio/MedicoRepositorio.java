package br.com.pet_shop.repositorio;

import br.com.pet_shop.entidades.Medico;

import java.util.List;
import java.util.Optional;

public class MedicoRepositorio extends RepositorioAbstract<Medico> {

    @Override
    public Boolean criar(Medico entidade) {
        return null;
    }

    @Override
    public Boolean atualizar(Medico entidade) {
        return null;
    }

    @Override
    public Optional<Medico> buscarPorId(Integer id) {
        return Optional.empty();
    }

    @Override
    public Medico buscarUltimo() {
        return null;
    }

    @Override
    public List<Medico> buscarTodos() {
        return null;
    }

    @Override
    public Boolean deletarPorId(Integer id) {
        return null;
    }

    @Override
    public Boolean deletarTodos() {
        return null;
    }

    @Override
    public Boolean existePorID(Integer id) {
        return null;
    }
}
