package br.com.pet_shop.repositorio;

import br.com.pet_shop.entidades.Cliente;
import br.com.pet_shop.repositorio.interfaces.ClienteRepositorioInterface;

import java.util.List;
import java.util.Optional;

public class ClienteRepositorio implements ClienteRepositorioInterface {

    @Override
    public Boolean criar(Cliente entidade) {
        return null;
    }

    @Override
    public Boolean atualizar(Cliente entidade) {
        return null;
    }

    @Override
    public Optional<Cliente> buscarPorId(Integer id) {
        return Optional.empty();
    }

    @Override
    public Optional<Cliente> buscarUltimo() {
        return Optional.empty();
    }

    @Override
    public List<Cliente> buscar() {
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
