package br.com.pet_shop.tela.menu;

import br.com.pet_shop.repositorio.*;
import br.com.pet_shop.servicos.*;
import br.com.pet_shop.tela.dados.LerTela;

public final class MenuTela {

    private MenuTela() {
    }

    public static void menuPrincipal() {
        int opcao;
        var menuPrincipal = "1 - Cliente" +
            "\n2 - Funcionário" +
            "\n3 - Espécie" +
            "\n4 - Animal" +
            "\n5 - Consulta" +
            "\n6 - Sair" +
            "\nOpção: ";

        do {
            opcao = LerTela.lerInteger(
                "Menu Principal",
                menuPrincipal
            );

            switch (opcao) {
                case 1:
                    menuCliente();
                    break;
                case 2:
                    menuFuncionario();
                    break;
                case 3:
                    menuEspecie();
                    break;
                case 4:
                    menuAnimal();
                    break;
                case 5:
                    menuConsulta();
                    break;
            }
        } while (opcao != 6);
    }

    private static void menuCliente() {
        var clienteServico = new ClienteServico(
            new ClienteRepositorio()
        );

        menuCrud(
            "Cliente",
            clienteServico::criar,
            clienteServico::atualizar,
            clienteServico::buscarPorId,
            clienteServico::deletarPorId
        );
    }

    private static void menuFuncionario() {
        var funcionarioServico = new FuncionarioServico(
            new FuncionarioRepositorio()
        );

        menuCrud(
            "Funcionário",
            funcionarioServico::criar,
            funcionarioServico::atualizar,
            funcionarioServico::buscarPorId,
            funcionarioServico::deletarPorId
        );
    }

    private static void menuEspecie() {
        var especieServico = new EspecieServico(
            new EspecieRepositorio()
        );

        menuCrud(
            "Espécie",
            especieServico::criar,
            especieServico::atualizar,
            especieServico::buscarPorId,
            especieServico::deletarPorId
        );
    }

    private static void menuAnimal() {
        var animalServico = new AnimalServico(
            new AnimalRepositorio()
        );

        menuCrud(
            "Animal",
            animalServico::criar,
            animalServico::atualizar,
            animalServico::buscarPorId,
            animalServico::deletarPorId
        );
    }

    private static void menuConsulta() {
        var consultaServico = new ConsultaServico(
            new ConsultaRepositorio()
        );

        menuCrud(
            "Consulta",
            consultaServico::criar,
            consultaServico::atualizar,
            consultaServico::buscarPorId,
            consultaServico::deletarPorId
        );
    }

    private static void menuCrud(String titulo, Runnable opcaoCadastrar, Runnable opcaoAtualizar, Runnable opcaoBuscar,
                                 Runnable opcaoDeletar) {
        var mensagem = "1 - Cadastrar\n2 - Atualizar\n3 - Buscar\n4 - Deletar\n5 - Sair\nOpção";
        int opcao;

        do {
            opcao = LerTela.lerInteger(titulo, mensagem);

            switch (opcao) {
                case 1:
                    opcaoCadastrar.run();
                    break;
                case 2:
                    opcaoAtualizar.run();
                    break;
                case 3:
                    opcaoBuscar.run();
                    break;
                case 4:
                    opcaoDeletar.run();
                    break;
                default:
                    break;
            }
        } while (opcao != 5);
    }
}
