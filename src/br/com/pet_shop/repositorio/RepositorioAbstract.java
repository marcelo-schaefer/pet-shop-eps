package br.com.pet_shop.repositorio;

import br.com.pet_shop.banco.ConexaoBanco;
import br.com.pet_shop.excecoes.ManipulacaoBancoExcecao;
import br.com.pet_shop.utilitarios.conversores.ConversorTipos;
import br.com.pet_shop.utilitarios.conversores.interfaces.ConversorEntidadeInterface;
import br.com.pet_shop.utilitarios.dto.ParametroQuery;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public abstract class RepositorioAbstract<E> {

    private final ConversorEntidadeInterface<E> conversorEntidadeInterface;

    public RepositorioAbstract(ConversorEntidadeInterface<E> conversorEntidadeInterface) {
        this.conversorEntidadeInterface = conversorEntidadeInterface;
    }

    abstract E criar(E entidade);

    abstract E atualizar(E entidade);

    abstract Optional<E> buscarPorId(Integer id);

    abstract Optional<E> buscarUltimo();

    abstract List<E> buscarTodos();

    abstract void deletarPorId(Integer id);

    abstract void deletarTodos();

    public Boolean existePorID(Integer id) {
        return buscarPorId(id).isPresent();
    }

    protected E persistir(String query) {
        return persistir(query, List.of());
    }

    protected Optional<E> consultar(String query) {
        return consultar(query, List.of());
    }

    protected Optional<E> consultar(String query, List<ParametroQuery> parametros) {
        var entidades = consultarList(query, parametros);

        if (!entidades.isEmpty()) {
            return Optional.of(
                entidades.get(0)
            );
        }

        return Optional.empty();
    }

    protected List<E> consultarList(String query) {
        return consultarList(query, List.of());
    }

    private List<E> consultarList(String query, List<ParametroQuery> parametros) {
        try (var connection = ConexaoBanco.pegarConexaoBase()) {
            try (var preparedStatement = connection.prepareStatement(query)) {

                for (var parametroQuery : parametros) {
                    construirStatement(preparedStatement, parametroQuery);
                }

                var resultSet = preparedStatement.executeQuery();
                var entidades = new ArrayList<E>();

                while (resultSet.next()) {
                    var entidade = conversorEntidadeInterface.resultSetParaEntiade(resultSet);
                    entidades.add(entidade);
                }

                return entidades;
            }
        } catch (Exception exception) {
            throw new ManipulacaoBancoExcecao(
                "Erro ao executar consulta no banco de dados.",
                exception
            );
        }
    }

    protected E persistir(String query, List<ParametroQuery> parametros) {
        try (var connection = ConexaoBanco.pegarConexaoBase()) {
            try (var preparedStatement = connection.prepareStatement(query)) {

                for (var parametroQuery : parametros) {
                    construirStatement(preparedStatement, parametroQuery);
                }

                preparedStatement.execute();
                return buscarUltimo().get();
            }
        } catch (Exception exception) {
            throw new ManipulacaoBancoExcecao(
                "Erro ao executar persistência no banco de dados.",
                exception
            );
        }
    }

    protected void deletar(String query) {
        deletar(query, List.of());
    }

    protected void deletar(String query, List<ParametroQuery> parametros) {
        try (var connection = ConexaoBanco.pegarConexaoBase()) {
            try (var preparedStatement = connection.prepareStatement(query)) {

                for (var parametroQuery : parametros) {
                    construirStatement(preparedStatement, parametroQuery);
                }

                preparedStatement.execute();
            }
        } catch (Exception exception) {
            throw new ManipulacaoBancoExcecao(
                "Erro ao executar deleção no banco de dados.",
                exception
            );
        }
    }

    private void construirStatement(PreparedStatement preparedStatement,
                                    ParametroQuery parametroQuery) throws Exception {
        var posicao = parametroQuery.getPosicao();

        switch (parametroQuery.getTipo()) {
            case STRING:
                preparedStatement.setString(
                    posicao,
                    (String) parametroQuery.getValor()
                );
                break;
            case INTEGER:
                preparedStatement.setInt(
                    posicao,
                    (Integer) parametroQuery.getValor()
                );
                break;
            case DOUBLE:
                preparedStatement.setDouble(
                    posicao,
                    (Double) parametroQuery.getValor()
                );
                break;
            case BOOLEAN:
                preparedStatement.setBoolean(
                    posicao,
                    (Boolean) parametroQuery.getValor()
                );
                break;
            case DATE:
                var date = (Date) parametroQuery.getValor();
                preparedStatement.setDate(
                    posicao,
                    ConversorTipos.dateParaDateSql(date)
                );
                break;
            default:
                preparedStatement.setString(
                    posicao,
                    parametroQuery.getValor().toString()
                );
        }
    }
}
