package br.com.pet_shop.utilitarios.conversores;

import br.com.pet_shop.entidades.Especie;
import br.com.pet_shop.excecoes.ConverterResultSetExcecao;
import br.com.pet_shop.utilitarios.conversores.interfaces.ConversorEntidadeInterface;

import java.sql.ResultSet;

public class EspecieConversor implements ConversorEntidadeInterface<Especie> {

    @Override
    public Especie resultSetParaEntiade(ResultSet resultSet) {
        try {
            return new Especie(
                resultSet.getInt("id"),
                resultSet.getString("nome")
            );
        } catch (Exception exception) {
            throw new ConverterResultSetExcecao(
                "Erro ao converter Espécie.",
                exception
            );
        }
    }
}
