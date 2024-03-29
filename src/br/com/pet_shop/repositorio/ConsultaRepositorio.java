package br.com.pet_shop.repositorio;

import br.com.pet_shop.banco.sql.ClienteSqlConstante;
import br.com.pet_shop.entidades.Consulta;
import br.com.pet_shop.enums.TipoParametroEnum;
import br.com.pet_shop.banco.sql.ConsultaSqlConstante;
import br.com.pet_shop.utilitarios.conversores.ConsultaConversor;
import br.com.pet_shop.utilitarios.dto.ParametroQuery;

import java.util.List;
import java.util.Optional;

public class ConsultaRepositorio extends RepositorioAbstract<Consulta> {

    public ConsultaRepositorio() {
        super(new ConsultaConversor());
    }

    @Override
    public Consulta criar(Consulta entidade) {
        var parametros = List.of(
            new ParametroQuery(
                TipoParametroEnum.STRING,
                entidade.getNome(),
                1
            ),
            new ParametroQuery(
                TipoParametroEnum.STRING,
                entidade.getObservacao(),
                2
            ),
            new ParametroQuery(
                TipoParametroEnum.LOCAL_TIME,
                entidade.getHorario(),
                3
            ),
            new ParametroQuery(
                TipoParametroEnum.DOUBLE,
                entidade.getValor(),
                4
            ),
            new ParametroQuery(
                TipoParametroEnum.INTEGER,
                entidade.getAnimal().getId(),
                5
            ),
            new ParametroQuery(
                TipoParametroEnum.INTEGER,
                entidade.getFuncionario().getId(),
                6
            )
        );

        return persistir(ConsultaSqlConstante.CRIAR, parametros);
    }

    @Override
    public Consulta atualizar(Consulta entidade) {
        var parametros = List.of(
            new ParametroQuery(
                TipoParametroEnum.STRING,
                entidade.getNome(),
                1
            ),
            new ParametroQuery(
                TipoParametroEnum.STRING,
                entidade.getObservacao(),
                2
            ),
            new ParametroQuery(
                TipoParametroEnum.LOCAL_TIME,
                entidade.getHorario(),
                3
            ),
            new ParametroQuery(
                TipoParametroEnum.DOUBLE,
                entidade.getValor(),
                4
            ),
            new ParametroQuery(
                TipoParametroEnum.INTEGER,
                entidade.getAnimal().getId(),
                5
            ),
            new ParametroQuery(
                TipoParametroEnum.INTEGER,
                entidade.getFuncionario().getId(),
                6
            ),
            new ParametroQuery(
                TipoParametroEnum.INTEGER,
                entidade.getId(),
                7
            )
        );

        return persistir(ConsultaSqlConstante.ATUALIZAR, parametros);
    }

    @Override
    public Optional<Consulta> buscarPorId(Integer id) {
        var parametros = List.of(
            new ParametroQuery(
                TipoParametroEnum.INTEGER,
                id,
                1
            )
        );

        return consultar(ConsultaSqlConstante.BUSCAR_POR_ID, parametros);
    }

    @Override
    public Optional<Consulta> buscarUltimo() {
        return consultar(ConsultaSqlConstante.BUSCAR_ULTIMO);
    }

    @Override
    public List<Consulta> buscarTodos() {
        return consultarList(ConsultaSqlConstante.BUSCAR_TUDO);
    }

    public Boolean existePorAnimalId(Integer animalId) {
        var parametros = List.of(
            new ParametroQuery(
                TipoParametroEnum.INTEGER,
                animalId,
                1
            )
        );

        return consultar(ConsultaSqlConstante.BUSCAR_POR_ANIMAL_ID, parametros).isPresent();
    }

    public Boolean existePorFuncionarioId(Integer funcionarioId) {
        var parametros = List.of(
            new ParametroQuery(
                TipoParametroEnum.INTEGER,
                funcionarioId,
                1
            )
        );

        return consultar(ConsultaSqlConstante.BUSCAR_POR_ANIMAL_ID, parametros).isPresent();
    }

    @Override
    public void deletarTodos() {
        deletar(ConsultaSqlConstante.DELETAR_TUDO);
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

        deletar(ConsultaSqlConstante.DELETAR_POR_ID, parametros);
    }
}
