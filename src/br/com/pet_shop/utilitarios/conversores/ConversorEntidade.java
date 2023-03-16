package br.com.pet_shop.utilitarios.conversores;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.pet_shop.entities.Animal;
import br.com.pet_shop.entities.Cliente;
import br.com.pet_shop.entities.Consulta;
import br.com.pet_shop.entities.Pessoa;

public class ConversorEntidade {

    private ConversorEntidade() {
    }

    public static Cliente resultSetParaCliente(ResultSet resultSet) {
        try {
            return new Cliente(
               
            );
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public static Consulta resultSetParaConsulta(ResultSet resultSet) {
        try {
            return new Consulta(
              
            );
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public static Pessoa resultSetParaPessoa(ResultSet resultSet) {
        try {
            return new Pessoa(
                
            );
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
    
    public static Animal resultSetParaAnimal(ResultSet resultSet) {
        try {
            return new Animal(
                
            );
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}
