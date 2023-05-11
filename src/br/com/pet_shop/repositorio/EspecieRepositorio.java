package br.com.pet_shop.repositorio;

import br.com.pet_shop.entidades.Especie;
import br.com.pet_shop.enums.TipoParametroEnum;
import br.com.pet_shop.excecoes.ConsultarEntidadeExcecao;
import br.com.pet_shop.utilitarios.constantes.sql.EspecieSqlConstante;
import br.com.pet_shop.utilitarios.conversores.ConversorEntidade;
import br.com.pet_shop.utilitarios.conversores.ConversorEspecie;
import br.com.pet_shop.utilitarios.dto.ParametroQuery;

import java.util.List;
import java.util.Optional;

public class EspecieRepositorio extends RepositorioAbstract<Especie> {

    public EspecieRepositorio() {
        super(new ConversorEspecie());
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
        try (var resultSet = consultar(EspecieSqlConstante.BUSCAR_ULTIMO)) {
            if (resultSet.next()) {
                var especie = ConversorEntidade.resultSetParaEspecie(resultSet);

                return Optional.of(especie);
            }

            return Optional.empty();
        } catch (Exception exception) {
            throw new ConsultarEntidadeExcecao(
                "Erro ao buscar última Espécie",
                exception
            );
        }
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
