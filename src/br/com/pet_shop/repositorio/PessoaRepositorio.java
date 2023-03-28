package br.com.pet_shop.repositorio;

import br.com.pet_shop.entidades.Pessoa;
import br.com.pet_shop.repositorio.interfaces.PessoaRepositorioInterface;

import java.util.List;
import java.util.Optional;

public class PessoaRepositorio implements PessoaRepositorioInterface {

    @Override
    public Boolean criar(Pessoa entidade) {
        return null;
    }

    @Override
    public Boolean atualizar(Pessoa entidade) {
        return null;
    }

    @Override
    public Optional<Pessoa> buscarPorId(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Pessoa> buscar() {
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
