package br.com.pet_shop.repositorio;

import br.com.pet_shop.entidades.Especie;
import br.com.pet_shop.enums.TipoParametroEnum;
import br.com.pet_shop.utilitarios.constantes.sql.EspecieSqlConstante;
import br.com.pet_shop.utilitarios.conversores.EspecieConversor;
import br.com.pet_shop.utilitarios.dto.ParametroQuery;

import java.util.List;
import java.util.Optional;

public class EspecieRepositorio extends RepositorioAbstract<Especie> {

    public EspecieRepositorio() {
        super(new EspecieConversor());
    }

    @Override
    public Especie criar(Especie entidade) {
        var parametros = List.of(
            new ParametroQuery(
                TipoParametroEnum.STRING,
                entidade.getNome(),
                1
            )
        );

        return persistir(EspecieSqlConstante.CRIAR, parametros);
    }

    @Override
    public Especie atualizar(Especie entidade) {
        var parametros = List.of(
            new ParametroQuery(
                TipoParametroEnum.INTEGER,
                entidade.getId(),
                1
            ),
            new ParametroQuery(
                TipoParametroEnum.STRING,
                entidade.getNome(),
                2
            )
        );

        return persistir(EspecieSqlConstante.ATUALIZAR, parametros);
    }

    @Override
    public Optional<Especie> buscarPorId(Integer id) {
        var parametros = List.of(
            new ParametroQuery(
                TipoParametroEnum.INTEGER,
                id,
                1
            )
        );

        return consultar(EspecieSqlConstante.BUSCAR_POR_ID, parametros);
    }

    @Override
    public Optional<Especie> buscarUltimo() {
        return consultar(EspecieSqlConstante.BUSCAR_ULTIMO);
    }

    @Override
    public List<Especie> buscarTodos() {
        return consultarList(EspecieSqlConstante.BUSCAR_TUDO);
    }

    @Override
    public void deletarTodos() {
        deletar(EspecieSqlConstante.DELETAR_TUDO);
    }

    @Override
    public void deletarPorId(Integer id) {
        var parametros = List.of(
            new ParametroQuery(
                TipoParametroEnum.INTEGER,
                id,
                1
            )
        );

        deletar(EspecieSqlConstante.DELETAR_POR_ID, parametros);
    }
}
