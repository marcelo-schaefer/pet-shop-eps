package br.com.pet_shop.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import br.com.pet_shop.banco.ConexaoBanco;
import br.com.pet_shop.entities.Cliente;
import br.com.pet_shop.utilitarios.constantes.ConsultasConstante;
import br.com.pet_shop.utilitarios.conversores.ConversorEntidade;

public class ClienteRepositorio {

	
	 public Optional<Cliente> buscarPorId(Integer id) {
	        try {
	            Connection connection = ConexaoBanco.pegarConexao();

	            PreparedStatement preparedStatement = connection.prepareStatement(
	                ConsultasConstante.Cliente.BUSCAR_POR_ID
	            );
	            preparedStatement.setInt(1, id);

	            ResultSet resultSet = preparedStatement.executeQuery();
	            if (resultSet.next()) {
	                return Optional.of(
	                    ConversorEntidade.resultSetParaCliente(resultSet)
	                );
	            }
	            return Optional.empty();
	        } catch (SQLException exception) {
	            throw new RuntimeException(exception);
	        }
	    }    
}
