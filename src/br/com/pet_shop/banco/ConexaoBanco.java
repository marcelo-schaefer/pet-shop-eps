package br.com.pet_shop.banco;

import br.com.pet_shop.RunApp;
import br.com.pet_shop.excecoes.ConexaoBancoExcecao;
import br.com.pet_shop.excecoes.ManipulacaoBancoExcecao;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
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

            for (var query : queries) {
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
            var fileReader = new FileReader(RunApp.CAMINHO_ARQUIVO_CRIACAO_BASE);
            var buffRead = new BufferedReader(fileReader);

            var conteudo = new StringBuilder();

            while (true) {
                var linha = buffRead.readLine();

                if (linha != null) {
                    conteudo.append(linha);
                } else {
                    break;
                }
            }

            buffRead.close();

            return conteudo.toString();
        } catch (Exception exception) {
            throw new ConexaoBancoExcecao(
                "Erro ao criar base",
                exception
            );
        }
    }
}
