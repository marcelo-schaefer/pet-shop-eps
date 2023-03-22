package br.com.pet_shop.banco;

import br.com.pet_shop.excecoes.ConexaoBancoExcecao;

import javax.swing.*;
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
                String nomeServidor = "localhost";
                String nomeBanco = "pet-shop";
                String url = "jdbc:mysql://"
                    .concat(nomeServidor)
                    .concat("/")
                    .concat(nomeBanco);

                String usuario = "root";
                String senha = "";

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
}