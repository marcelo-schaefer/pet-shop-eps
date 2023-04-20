package br.com.pet_shop.repositorio;

import br.com.pet_shop.entidades.Especie;
import br.com.pet_shop.utilitarios.constantes.sql.EspecieSqlConstante;

import java.util.List;
import java.util.Optional;

public class EspecieRepositorio extends RepositorioAbstract<Especie> {

    @Override
    public Especie criar(Especie entidade) {

        return null;
    }

    @Override
    public Especie atualizar(Especie entidade) {
        return null;
    }

    @Override
    public Optional<Especie> buscarPorId(Integer id) {
        return Optional.empty();
    }

    @Override
    public Especie buscarUltimo() {
        return null;
    }

    @Override
    public List<Especie> buscarTodos() {
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
