package br.com.pet_shop.tela.menu;

import br.com.pet_shop.repositorio.AnimalRepositorio;
import br.com.pet_shop.repositorio.ClienteRepositorio;
import br.com.pet_shop.repositorio.ConsultaRepositorio;
import br.com.pet_shop.repositorio.EspecieRepositorio;
import br.com.pet_shop.servicos.AnimalServico;
import br.com.pet_shop.servicos.ClienteServico;
import br.com.pet_shop.servicos.ConsultaServico;
import br.com.pet_shop.servicos.EspecieServico;
import br.com.pet_shop.tela.dados.LerTela;

public final class MenuTela {

    private MenuTela() {
    }

    public static void menuPrincipal() {
        var menuPrincipal = "1 - Cliente\n2 - Espécie\n3 - Animal\n4 - Consulta\n5 - Sair\nOpção: ";
        int opcao;

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
                    menuEspecie();
                    break;
                case 3:
                    menuAnimal();
                    break;
                default:
                    menuConsulta();
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
