package br.com.pet_shop.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.pet_shop.banco.ConexaoBanco;
import br.com.pet_shop.entities.Animal;
import br.com.pet_shop.entities.Cliente;
import br.com.pet_shop.excecoes.banco.ConexaoBancoExcecao;
import br.com.pet_shop.utilitarios.constantes.ConsultasConstante;
import br.com.pet_shop.utilitarios.conversores.ConversorEntidade;
import br.com.pet_shop.utilitarios.conversores.ConversorTipos;

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
	 
	  public Boolean criar(Cliente entidade) {
	        try {
	            Connection connection = ConexaoBanco.pegarConexao();

	            PreparedStatement preparedStatement = connection.prepareStatement(ConsultasConstante.Cliente.CRIAR);
	            preparedStatement.setInt(1, entidade.getId());
	            preparedStatement.setString(2, entidade.getNome());
	            preparedStatement.setString(3, entidade.getSobrenome());
	            preparedStatement.setString(4, entidade.getCpf());
	            preparedStatement.setDate(5, ConversorTipos.dateParaDateSql(entidade.getDataNascimento()));

	            return preparedStatement.execute();
	        } catch (SQLException exception) {
	            throw new ConexaoBancoExcecao("Erro ao inserir na base de dados.", exception);
	        }
	    }


	    public Boolean atualizar(Cliente entidade) {
	        try {
	            Connection connection = ConexaoBanco.pegarConexao();

	            PreparedStatement preparedStatement = connection.prepareStatement(ConsultasConstante.Cliente.ATUALIZAR);
	            preparedStatement.setInt(1, entidade.getId());
	            preparedStatement.setString(2, entidade.getNome());
	            preparedStatement.setString(3, entidade.getSobrenome());
	            preparedStatement.setString(4, entidade.getCpf());
	            preparedStatement.setDate(5, ConversorTipos.dateParaDateSql(entidade.getDataNascimento()));

	            return preparedStatement.execute();
	        } catch (SQLException exception) {
	            throw new ConexaoBancoExcecao("Erro ao inserir na base de dados.", exception);
	        }
	    }


	    public List<Cliente> buscar() {
	        List<Cliente> clientes = new ArrayList<>();
	        try {
	            Connection connection = ConexaoBanco.pegarConexao();

	            PreparedStatement preparedStatement = connection.prepareStatement(
	                ConsultasConstante.Cliente.BUSCAR
	            );

	            ResultSet resultSet = preparedStatement.executeQuery();
	            while (resultSet.next()) {
	                clientes.add(
	                    ConversorEntidade.resultSetParaCliente(resultSet)
	                );
	            }
	            return clientes;
	        } catch (SQLException exception) {
	            throw new RuntimeException(exception);
	        }
	    }
	    
	    public Boolean deletar() {
	        try {
	            Connection connection = ConexaoBanco.pegarConexao();

	            PreparedStatement preparedStatement = connection.prepareStatement(
	                ConsultasConstante.Cliente.DELETAR
	            );

	            return preparedStatement.execute();
	        } catch (SQLException exception) {
	            throw new RuntimeException(exception);
	        }
	    }
	    
	    public Boolean deletarPorId(Integer id) {
	        try {
	            Connection connection = ConexaoBanco.pegarConexao();

	            PreparedStatement preparedStatement = connection.prepareStatement(
	                ConsultasConstante.Cliente.DELETAR_POR_ID
	            );
	            preparedStatement.setInt(1, id);

	            return preparedStatement.execute();
	        } catch (SQLException exception) {
	            throw new RuntimeException(exception);
	        }
	    }
}
