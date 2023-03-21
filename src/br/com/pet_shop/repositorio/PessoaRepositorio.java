package br.com.pet_shop.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import br.com.pet_shop.banco.ConexaoBanco;
import br.com.pet_shop.entities.Pessoa;
import br.com.pet_shop.utilitarios.constantes.ConsultasConstante;
import br.com.pet_shop.utilitarios.conversores.ConversorEntidade;

public class PessoaRepositorio {

	
	public Optional<Pessoa> buscarPorId(Integer id) {
        try {
            Connection connection = ConexaoBanco.pegarConexao();

            PreparedStatement preparedStatement = connection.prepareStatement(
                ConsultasConstante.Pessoa.BUSCAR_POR_ID
            );
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(
                    ConversorEntidade.resultSetParaPessoa(resultSet)
                );
            }
            return Optional.empty();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }    
}
