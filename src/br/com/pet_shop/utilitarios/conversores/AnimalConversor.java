package br.com.pet_shop.utilitarios.conversores;

import br.com.pet_shop.entidades.Animal;
import br.com.pet_shop.entidades.Especie;
import br.com.pet_shop.enums.SexoEnum;
import br.com.pet_shop.excecoes.ConverterResultSetExcecao;
import br.com.pet_shop.utilitarios.conversores.interfaces.ConversorEntidadeInterface;

import java.sql.ResultSet;

public class AnimalConversor implements ConversorEntidadeInterface<Animal> {

    @Override
    public Animal resultSetParaEntiade(ResultSet resultSet) {
        try {
            return new Animal(
                resultSet.getInt("id"),
                resultSet.getString("nome"),
                resultSet.getString("detalhe"),
                ConversorTipos.dateParaDateSql(resultSet.getDate("data_nascimento")),
                SexoEnum.valueOf(resultSet.getString("sexo")),
                resultSet.getBoolean("ativo"),
                new Especie(
                    resultSet.getInt("especie_id")
                )
            );
        } catch (Exception exception) {
            throw new ConverterResultSetExcecao(
                "Erro ao converter Espécie.",
                exception
            );
        }
    }
}
