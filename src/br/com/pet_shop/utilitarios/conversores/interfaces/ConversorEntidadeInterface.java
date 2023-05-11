package br.com.pet_shop.utilitarios.conversores.interfaces;

import java.sql.ResultSet;

public interface ConversorEntidadeInterface<E> {

    E resultSetParaEntiade(ResultSet resultSet);
}
