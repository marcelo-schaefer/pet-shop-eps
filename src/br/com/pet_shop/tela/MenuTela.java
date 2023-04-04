package br.com.pet_shop.tela;

public final class MenuTela {

    private MenuTela() {
    }

    public static void principal() {
        var menuPrincipal = "1 - Cliente\n2 - Funcionário\n3 - Espécie\n4 - Animal\n5 - Consulta\n6 - Sair\nOpção: ";
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
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    break;
            }
        } while (opcao != 6);
    }

    private static void menuCliente() {

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
                default:
                    opcaoDeletar.run();
                    break;
            }
        } while (opcao != 5);
    }
}
