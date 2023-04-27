package br.com.pet_shop.utilitarios.conversores;

import br.com.pet_shop.entidades.Especie;
import br.com.pet_shop.utilitarios.conversores.interfaces.ConversorEntidadeInterface;

import java.sql.ResultSet;

public class ConversorEspecie implements ConversorEntidadeInterface<Especie> {

    @Override
    public Especie resultSetParaEntiade(ResultSet resultSet) {
        return null;
    }
}
