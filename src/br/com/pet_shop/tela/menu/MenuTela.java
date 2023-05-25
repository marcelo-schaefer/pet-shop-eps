package br.com.pet_shop.tela.menu;

import br.com.pet_shop.repositorio.*;
import br.com.pet_shop.servicos.*;
import br.com.pet_shop.servicos.interfaces.ServicoInterface;
import br.com.pet_shop.tela.dados.LerTela;

public final class MenuTela {

    private MenuTela() {
    }

    public static void menuPrincipal() {
        int opcao;
        var menuPrincipal = "1 - Cliente"
            .concat("\n")
            .concat("2 - Funcionário")
            .concat("\n")
            .concat("3 - Espécie")
            .concat("\n")
            .concat("4 - Animal")
            .concat("\n")
            .concat("5 - Consulta")
            .concat("\n")
            .concat("6 - Sair")
            .concat("\n")
            .concat("Opção:");

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

        menuCrud("Cliente", clienteServico);
    }

    private static void menuFuncionario() {
        var funcionarioServico = new FuncionarioServico(
            new FuncionarioRepositorio()
        );

        menuCrud("Funcionário", funcionarioServico);
    }

    private static void menuEspecie() {
        var especieServico = new EspecieServico(
            new EspecieRepositorio()
        );

        menuCrud("Espécie", especieServico);
    }

    private static void menuAnimal() {
        var animalServico = new AnimalServico(
            new AnimalRepositorio()
        );

        menuCrud("Animal", animalServico);
    }

    private static void menuConsulta() {
        var consultaServico = new ConsultaServico(
            new ConsultaRepositorio()
        );

        menuCrud("Consulta", consultaServico);
    }

    private static void menuCrud(String titulo, ServicoInterface servicoInterface) {
        var mensagem = "1 - Cadastrar"
            .concat("\n")
            .concat("2 - Atualizar")
            .concat("\n")
            .concat("3 - Buscar por Id")
            .concat("\n")
            .concat("4 - Buscar tudo")
            .concat("\n")
            .concat("5 - Deletar")
            .concat("\n")
            .concat("6 - Sair")
            .concat("\n")
            .concat("Opção:");

        int opcao;

        do {
            opcao = LerTela.lerInteger(titulo, mensagem);

            switch (opcao) {
                case 1:
                    servicoInterface.criar();
                    break;
                case 2:
                    servicoInterface.atualizar();
                    break;
                case 3:
                    servicoInterface.buscarPorId();
                    break;
                case 4:
                    servicoInterface.buscarTudo();
                    break;
                case 5:
                    servicoInterface.deletarPorId();
                    break;
                default:
                    break;
            }
        } while (opcao != 6);
    }
}
