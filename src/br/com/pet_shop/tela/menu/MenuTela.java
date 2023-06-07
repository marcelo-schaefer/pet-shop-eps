package br.com.pet_shop.tela.menu;

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
                default:
            }
        } while (opcao != 6);
    }

    private static void menuCliente() {
        menuCrud("Cliente", new ClienteServico());
    }

    private static void menuFuncionario() {
        menuCrud("Funcionário", new FuncionarioServico());
    }

    private static void menuEspecie() {
        menuCrud("Espécie", new EspecieServico());
    }

    private static void menuAnimal() {
        menuCrud("Animal", new AnimalServico());
    }

    private static void menuConsulta() {
        menuCrud("Consulta", new ConsultaServico());
    }

    private static <T> void menuCrud(String titulo, ServicoInterface<T> servicoInterface) {
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
