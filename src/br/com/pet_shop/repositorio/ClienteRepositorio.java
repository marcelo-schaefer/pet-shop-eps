package br.com.pet_shop.repositorio;

import br.com.pet_shop.entidades.Cliente;
import br.com.pet_shop.enums.TipoParametroEnum;
import br.com.pet_shop.banco.sql.ClienteSqlConstante;
import br.com.pet_shop.utilitarios.conversores.ClienteConversor;
import br.com.pet_shop.utilitarios.dto.ParametroQuery;

import java.util.List;
import java.util.Optional;

public class ClienteRepositorio extends RepositorioAbstract<Cliente> {

    public ClienteRepositorio() {
        super(new ClienteConversor());
    }

    @Override
    public Cliente criar(Cliente entidade) {
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
            )
        );

        return persistir(ClienteSqlConstante.CRIAR, parametros);
    }

    @Override
    public Cliente atualizar(Cliente entidade) {
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
                TipoParametroEnum.INTEGER,
                entidade.getId(),
                4
            )
        );

        return persistir(ClienteSqlConstante.ATUALIZAR, parametros);
    }

    @Override
    public Optional<Cliente> buscarPorId(Integer id) {
        var parametros = List.of(
            new ParametroQuery(
                TipoParametroEnum.INTEGER,
                id,
                1
            )
        );

        return consultar(ClienteSqlConstante.BUSCAR_POR_ID, parametros);
    }

    @Override
    public Optional<Cliente> buscarUltimo() {
        return consultar(ClienteSqlConstante.BUSCAR_ULTIMO);
    }

    @Override
    public List<Cliente> buscarTodos() {
        return consultarList(ClienteSqlConstante.BUSCAR_TUDO);
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

        deletar(ClienteSqlConstante.DELETAR_POR_ID, parametros);
    }

    @Override
    public void deletarTodos() {
        deletar(ClienteSqlConstante.DELETAR_TUDO);
    }
}
