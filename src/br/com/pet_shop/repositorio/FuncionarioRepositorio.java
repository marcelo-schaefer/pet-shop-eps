package br.com.pet_shop.repositorio;

import br.com.pet_shop.entidades.Funcionario;

import java.util.List;
import java.util.Optional;

public class FuncionarioRepositorio extends RepositorioAbstract<Funcionario> {

    @Override
    public Boolean criar(Funcionario entidade) {
        return null;
    }

    @Override
    public Boolean atualizar(Funcionario entidade) {
        return null;
    }

    @Override
    public Optional<Funcionario> buscarPorId(Integer id) {
        return Optional.empty();
    }

    @Override
    public Funcionario buscarUltimo() {
        return null;
    }

    @Override
    public List<Funcionario> buscarTodos() {
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
