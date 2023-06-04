package br.com.pet_shop.utilitarios.conversores;

import br.com.pet_shop.entidades.Animal;
import br.com.pet_shop.entidades.Consulta;
import br.com.pet_shop.entidades.Funcionario;
import br.com.pet_shop.excecoes.ConverterResultSetExcecao;
import br.com.pet_shop.utilitarios.conversores.interfaces.ConversorEntidadeInterface;

import java.sql.ResultSet;

public class ConsultaConversor implements ConversorEntidadeInterface<Consulta> {

    @Override
    public Consulta resultSetParaEntiade(ResultSet resultSet) {
        try {
            return new Consulta(
                resultSet.getInt("id"),
                resultSet.getString("nome"),
                resultSet.getString("observacao"),
                resultSet.getTime("horario").toLocalTime(),
                resultSet.getDouble("valor"),
                new Animal(
                    resultSet.getInt("animal_id")
                ),
                new Funcionario(
                    resultSet.getInt("funcionario_id")
                )
            );
        } catch (Exception exception) {
            throw new ConverterResultSetExcecao(
                "Erro ao converter Consulta.",
                exception
            );
        }
    }
}
