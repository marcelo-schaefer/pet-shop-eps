package br.com.pet_shop.utilitarios.conversores;

import br.com.pet_shop.entidades.Animal;
import br.com.pet_shop.entidades.Cliente;
import br.com.pet_shop.entidades.Consulta;
import br.com.pet_shop.entidades.Especie;
import br.com.pet_shop.excecoes.ConverterResultSetExcecao;

import java.sql.ResultSet;

public final class ConversorEntidade {

    private ConversorEntidade() {
    }

    public static Especie resultSetParaEspecie(ResultSet resultSet) {
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

    public static Cliente resultSetParaCliente(ResultSet resultSet) {
        try {
            return new Cliente(

            );
        } catch (Exception exception) {
            throw new ConverterResultSetExcecao(
                "Erro ao converter Cliente.",
                exception
            );
        }
    }

    public static Consulta resultSetParaConsulta(ResultSet resultSet) {
        try {
            return new Consulta(

            );
        } catch (Exception exception) {
            throw new ConverterResultSetExcecao(
                "Erro ao converter Consulta.",
                exception
            );
        }
    }

    public static Animal resultSetParaAnimal(ResultSet resultSet) {
        try {
            return new Animal(
            );
        } catch (Exception exception) {
            throw new ConverterResultSetExcecao(
                "Erro ao converter Animal.",
                exception
            );
        }
    }
}
