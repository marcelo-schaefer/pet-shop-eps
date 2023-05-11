package br.com.pet_shop.repositorio;

import br.com.pet_shop.entidades.Funcionario;
import br.com.pet_shop.utilitarios.conversores.interfaces.ConversorEntidadeInterface;

import java.util.List;
import java.util.Optional;

public class FuncionarioRepositorio extends RepositorioAbstract<Funcionario> {

    public FuncionarioRepositorio(ConversorEntidadeInterface<Funcionario> conversorEntidadeInterface) {
        super(conversorEntidadeInterface);
    }

    @Override
    public Funcionario criar(Funcionario entidade) {
        return null;
    }

    @Override
    public Funcionario atualizar(Funcionario entidade) {
        return null;
    }

    @Override
    public Optional<Funcionario> buscarPorId(Integer id) {
        return Optional.empty();
    }

    @Override
    public Optional<Funcionario> buscarUltimo() {
        return null;
    }

    @Override
    public List<Funcionario> buscarTodos() {
        return null;
    }

    @Override
    public void deletarPorId(Integer id) {
        return null;
    }

    @Override
    public void deletarTodos() {
        return null;
    }

    
}
