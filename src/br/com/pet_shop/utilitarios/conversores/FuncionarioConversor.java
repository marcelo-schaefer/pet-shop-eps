package br.com.pet_shop.utilitarios.conversores;

import br.com.pet_shop.entidades.Funcionario;
import br.com.pet_shop.excecoes.ConverterResultSetExcecao;
import br.com.pet_shop.utilitarios.conversores.interfaces.ConversorEntidadeInterface;

import java.sql.ResultSet;

public class FuncionarioConversor implements ConversorEntidadeInterface<Funcionario> {

    @Override
    public Funcionario resultSetParaEntiade(ResultSet resultSet) {
        try {
            return new Funcionario(
                resultSet.getInt("id"),
                resultSet.getString("nome"),
                resultSet.getString("cpf"),
                ConversorTipos.dateParaDateSql(resultSet.getDate("data_nascimento")),
                resultSet.getString("cargo")
            );
        } catch (Exception exception) {
            throw new ConverterResultSetExcecao(
                "Erro ao converter o Funcionário.",
                exception
            );
        }
    }
}
