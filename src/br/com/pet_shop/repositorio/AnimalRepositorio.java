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
import br.com.pet_shop.excecoes.banco.ConexaoBancoExcecao;
import br.com.pet_shop.utilitarios.constantes.ConsultasConstante;
import br.com.pet_shop.utilitarios.conversores.ConversorEntidade;
import br.com.pet_shop.utilitarios.conversores.ConversorTipos;
import main.java.br.com.biblioteca.entidades.ClienteEntidade;

public class AnimalRepositorio {

    public Optional<Animal> buscarPorId(Integer id) {
        try {
            Connection connection = ConexaoBanco.pegarConexao();

            PreparedStatement preparedStatement = connection.prepareStatement(
                ConsultasConstante.Animal.BUSCAR_POR_ID
            );
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(
                    ConversorEntidade.resultSetParaAnimal(resultSet)
                );
            }
            return Optional.empty();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }    
    
    public Boolean criar(Animal entidade) {
        try {
            Connection connection = ConexaoBanco.pegarConexao();

            PreparedStatement preparedStatement = connection.prepareStatement(ConsultasConstante.Animal.CRIAR);
            preparedStatement.setInt(1, entidade.getId());
            preparedStatement.setString(3, entidade.getNome());
            preparedStatement.setDate(2, ConversorTipos.dateParaDateSql(entidade.getDataNascimento()));
            preparedStatement.setString(4, entidade.getSexo().toString());

            return preparedStatement.execute();
        } catch (SQLException exception) {
            throw new ConexaoBancoExcecao("Erro ao inserir na base de dados.", exception);
        }
    }


    public Boolean atualizar(Animal entidade) {
        try {
            Connection connection = ConexaoBanco.pegarConexao();

            PreparedStatement preparedStatement = connection.prepareStatement(ConsultasConstante.Cliente.ATUALIZAR);
            preparedStatement.setInt(1, entidade.getId());
            preparedStatement.setString(3, entidade.getNome());
            preparedStatement.setDate(2, ConversorTipos.dateParaDateSql(entidade.getDataNascimento()));
            preparedStatement.setString(4, entidade.getSexo().toString());

            return preparedStatement.execute();
        } catch (SQLException exception) {
            throw new ConexaoBancoExcecao("Erro ao inserir na base de dados.", exception);
        }
    }


    public List<Animal> buscar() {
        List<Animal> animais = new ArrayList<>();
        try {
            Connection connection = ConexaoBanco.pegarConexao();

            PreparedStatement preparedStatement = connection.prepareStatement(
                ConsultasConstante.Animal.BUSCAR
            );

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                animais.add(
                    ConversorEntidade.resultSetParaAnimal(resultSet)
                );
            }
            return animais;
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }
    
    public Boolean deletar() {
        try {
            Connection connection = ConexaoBanco.pegarConexao();

            PreparedStatement preparedStatement = connection.prepareStatement(
                ConsultasConstante.Animal.DELETAR
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
                ConsultasConstante.Animal.DELETAR_POR_ID
            );
            preparedStatement.setInt(1, id);

            return preparedStatement.execute();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }
}
