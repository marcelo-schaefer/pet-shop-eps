package br.com.pet_shop.repositorio;

import br.com.pet_shop.banco.ConexaoBanco;
import br.com.pet_shop.entidades.Cliente;
import br.com.pet_shop.excecoes.PersistirEntidadeExcecao;
import br.com.pet_shop.utilitarios.constantes.sql.ClienteSqlConstante;

import java.util.List;
import java.util.Optional;

public class ClienteRepositorio extends RepositorioAbstract<Cliente> {

    @Override
    public Cliente criar(Cliente entidade) {
        try (var conexao = ConexaoBanco.pegarConexao()) {
            try (var preparedStatement = conexao.prepareStatement(ClienteSqlConstante.CRIAR)) {
                preparedStatement.setString(1, entidade.getNome());

                preparedStatement.execute();
                return null;
            }
        } catch (Exception exception) {
            throw new PersistirEntidadeExcecao(
                "Erro ao criar cliente",
                exception
            );
        }
    }

    @Override
    public Cliente atualizar(Cliente entidade) {
        return null;
    }

    @Override
    public Optional<Cliente> buscarPorId(Integer id) {
        return Optional.empty();
    }

    @Override
    public Optional<Cliente> buscarUltimo() {
        return null;
    }

    @Override
    public List<Cliente> buscarTodos() {
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
