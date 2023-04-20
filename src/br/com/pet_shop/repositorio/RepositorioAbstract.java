package br.com.pet_shop.repositorio;

import br.com.pet_shop.banco.ConexaoBanco;
import br.com.pet_shop.excecoes.ManipulacaoBancoExcecao;
import br.com.pet_shop.utilitarios.conversores.ConversorTipos;
import br.com.pet_shop.utilitarios.dto.ParametroQuery;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public abstract class RepositorioAbstract<T> {

    abstract T criar(T entidade);

    abstract T atualizar(T entidade);

    abstract Optional<T> buscarPorId(Integer id);

    abstract T buscarUltimo();

    abstract List<T> buscarTodos();

    abstract Boolean deletarPorId(Integer id);

    abstract Boolean deletarTodos();

    abstract Boolean existePorID(Integer id);

    protected ResultSet executarQuery(String query, List<ParametroQuery> parametroQueries) {
        try (var connection = ConexaoBanco.pegarConexao()) {
            try (var preparedStatement = connection.prepareStatement(query)) {

                for (var parametroQuery : parametroQueries) {
                    contruirStatement(preparedStatement, parametroQuery);
                }

                return preparedStatement.executeQuery();
            }
        } catch (Exception exception) {
            throw new ManipulacaoBancoExcecao(
                "Erro ao executar consulta no banco de dados."
            );
        }
    }

    private void contruirStatement(PreparedStatement preparedStatement,
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
            default:
                var date = (Date) parametroQuery.getValor();
                preparedStatement.setDate(
                    posicao,
                    ConversorTipos.dateParaDateSql(date)
                );
        }
    }
}
