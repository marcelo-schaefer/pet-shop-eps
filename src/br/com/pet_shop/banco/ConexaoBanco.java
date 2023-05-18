package br.com.pet_shop.banco;

import br.com.pet_shop.excecoes.ConexaoBancoExcecao;
import br.com.pet_shop.excecoes.ManipulacaoBancoExcecao;

import javax.swing.*;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {

    private static Connection conexao;

    private ConexaoBanco() {
    }

    public static Connection pegarConexao() throws ConexaoBancoExcecao {
        try {
            if (conexao == null || conexao.isClosed()) {
                var nomeServidor = "localhost";
                var nomeBanco = "pet_shop";
                var url = "jdbc:mysql://"
                    .concat(nomeServidor)
                    .concat("/")
                    .concat(nomeBanco);

                var usuario = "root";
                var senha = "";

                conexao = DriverManager.getConnection(url, usuario, senha);
            }

            return conexao;
        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(
                null,
                "Erro ao conectar com o banco. Verifique as configurações.",
                "Erro ao Conectar",
                JOptionPane.ERROR_MESSAGE
            );
            throw new ConexaoBancoExcecao(exception);
        }
    }

    public static void criarBanco() {
        var query = pegarScriptDeCriacao();

        try (var connection = ConexaoBanco.pegarConexaoBase()) {
            try (var preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.execute();
            }
        } catch (Exception exception) {
            throw new ManipulacaoBancoExcecao(
                "Erro ao executar persistência no banco de dados."
            );
        }
    }

    private static Connection pegarConexaoBase() throws ConexaoBancoExcecao {
        try {
            if (conexao == null || conexao.isClosed()) {
                var nomeServidor = "localhost";
                var url = "jdbc:mysql://".concat(nomeServidor);

                var usuario = "root";
                var senha = "";

                conexao = DriverManager.getConnection(url, usuario, senha);
            }

            return conexao;
        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(
                null,
                "Erro ao conectar com o banco. Verifique as configurações.",
                "Erro ao Conectar",
                JOptionPane.ERROR_MESSAGE
            );
            throw new ConexaoBancoExcecao(exception);
        }
    }

    private static String pegarScriptDeCriacao() {
        try {
            byte[] encoded = Files.readAllBytes(
                Paths.get("C:\\Users\\Aluno\\Desktop\\pet-shop-eps-main\\src\\sql\\criar_banco.sql")
            );

            return StandardCharsets
                .UTF_8
                .decode(ByteBuffer.wrap(encoded))
                .toString();
        } catch (Exception exception) {
            throw new RuntimeException(
                "Erro ao criar base",
                exception
            );
        }
    }
}
