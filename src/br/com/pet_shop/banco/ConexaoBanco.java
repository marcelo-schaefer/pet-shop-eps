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

    public static Connection pegarConexaoBase() throws ConexaoBancoExcecao {
        return pegarConexao("pet_shop");
    }

    public static Connection pegarConexaoServidor() throws ConexaoBancoExcecao {
        return pegarConexao(null);
    }

    public static void criarBanco() {
        var queryCompleta = pegarScriptDeCriacao();

        try (var connection = pegarConexaoServidor()) {
            var queries = queryCompleta.split("#");

            for (var i = 0; i < queries.length; i++) {
                var query = queries[i];

                try (var preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.executeUpdate();
                }
            }
        } catch (Exception exception) {
            throw new ManipulacaoBancoExcecao(
                "Erro ao criar base de dados.",
                exception
            );
        }
    }

    private static Connection pegarConexao(String host) {
        try {
            if (conexao == null || conexao.isClosed()) {
                var nomeServidor = "localhost";
                var url = "jdbc:mysql://".concat(nomeServidor);

                if (host != null) {
                    url = url.concat("/").concat(host);
                }

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
                Paths.get("C:\\Users\\Aluno\\Desktop\\pet-shop-eps\\src\\sql\\criar_banco.sql")
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
