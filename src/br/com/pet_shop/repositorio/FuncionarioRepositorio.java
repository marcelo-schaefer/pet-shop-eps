package br.com.pet_shop.repositorio;

import br.com.pet_shop.entidades.Funcionario;
import br.com.pet_shop.enums.TipoParametroEnum;
import br.com.pet_shop.banco.sql.FuncionarioSqlConstante;
import br.com.pet_shop.utilitarios.conversores.FuncionarioConversor;
import br.com.pet_shop.utilitarios.dto.ParametroQuery;

import java.util.List;
import java.util.Optional;

public class FuncionarioRepositorio extends RepositorioAbstract<Funcionario> {

    public FuncionarioRepositorio() {
        super(new FuncionarioConversor());
    }

    @Override
    public Funcionario criar(Funcionario entidade) {
        var parametros = List.of(
            new ParametroQuery(
                TipoParametroEnum.STRING,
                entidade.getNome(),
                1
            ),
            new ParametroQuery(
                TipoParametroEnum.STRING,
                entidade.getCpf(),
                2
            ),
            new ParametroQuery(
                TipoParametroEnum.DATE,
                entidade.getDataNascimento(),
                3
            ),
            new ParametroQuery(
                TipoParametroEnum.STRING,
                entidade.getCargo(),
                4
            )
        );

        return persistir(FuncionarioSqlConstante.CRIAR, parametros);
    }

    @Override
    public Funcionario atualizar(Funcionario entidade) {
        var parametros = List.of(
            new ParametroQuery(
                TipoParametroEnum.STRING,
                entidade.getNome(),
                1
            ),
            new ParametroQuery(
                TipoParametroEnum.STRING,
                entidade.getCpf(),
                2
            ),
            new ParametroQuery(
                TipoParametroEnum.DATE,
                entidade.getDataNascimento(),
                3
            ),
            new ParametroQuery(
                TipoParametroEnum.STRING,
                entidade.getCargo(),
                4
            ),
            new ParametroQuery(
                TipoParametroEnum.INTEGER,
                entidade.getId(),
                5
            )
        );

        return persistir(FuncionarioSqlConstante.ATUALIZAR, parametros);
    }

    @Override
    public Optional<Funcionario> buscarPorId(Integer id) {
        var parametros = List.of(
            new ParametroQuery(
                TipoParametroEnum.INTEGER,
                id,
                1
            )
        );

        return consultar(FuncionarioSqlConstante.BUSCAR_POR_ID, parametros);
    }

    @Override
    public Optional<Funcionario> buscarUltimo() {
        return consultar(FuncionarioSqlConstante.BUSCAR_ULTIMO);
    }

    @Override
    public List<Funcionario> buscarTodos() {
        return consultarList(FuncionarioSqlConstante.BUSCAR_TUDO);
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

        deletar(FuncionarioSqlConstante.DELETAR_POR_ID, parametros);
    }

    @Override
    public void deletarTodos() {
        deletar(FuncionarioSqlConstante.DELETAR_TUDO);
    }
}
