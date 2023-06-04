package br.com.pet_shop.utilitarios.conversores;

import br.com.pet_shop.entidades.Cliente;
import br.com.pet_shop.excecoes.ConverterResultSetExcecao;
import br.com.pet_shop.utilitarios.conversores.interfaces.ConversorEntidadeInterface;

import java.sql.ResultSet;

public class ClienteConversor implements ConversorEntidadeInterface<Cliente> {

    @Override
    public Cliente resultSetParaEntiade(ResultSet resultSet) {
        try {
            return new Cliente(
                resultSet.getInt("id"),
                resultSet.getString("nome"),
                resultSet.getString("cpf"),
                ConversorTipos.dateParaDateSql(resultSet.getDate("data_nascimento"))
            );
        } catch (Exception exception) {
            throw new ConverterResultSetExcecao(
                "Erro ao converter Cliente.",
                exception
            );
        }
    }
}
