package br.com.pet_shop.servicos;

import br.com.pet_shop.entidades.Cliente;
import br.com.pet_shop.repositorio.ClienteRepositorio;
import br.com.pet_shop.servicos.interfaces.ClienteServicoInterface;
import br.com.pet_shop.tela.dados.JOptionPaneTela;
import br.com.pet_shop.tela.dados.LerTela;

public class ClienteServico implements ClienteServicoInterface {

    private static final String NAO_ENCONTRADO = "Cliente com o id \"%d\" não encontrado.";

    private static final String DADOS_CLIENTE_TITULO = "Dados da Cliente";

    private static final String CADASTRAR_CLIENTE_TITULO = "Cadastrar Cliente";

    private static final String ATUALIZAR_CLIENTE_TITULO = "Atualizar Cliente";

    private static final String BUSCAR_CLIENTE_TITULO = "Buscar Cliente";

    private static final String DELETAR_CLIENTE_TITULO = "Deletar Cliente";

    private final ClienteRepositorio clienteRepositorio = new ClienteRepositorio();

    public void criar() {
        var nome = LerTela.lerString(CADASTRAR_CLIENTE_TITULO, "Nome:");
        var cpf = LerTela.lerString(CADASTRAR_CLIENTE_TITULO, "CPF:");
        var dataNascimento = LerTela.lerDate(CADASTRAR_CLIENTE_TITULO, "Data de Nascimento:");

        var cliente = new Cliente(
            nome,
            cpf,
            dataNascimento
        );

        clienteRepositorio.criar(cliente);

        JOptionPaneTela.optionMensagemInfo(
            CADASTRAR_CLIENTE_TITULO,
            "Cliente cadastrado com sucesso!"
        );
    }

    public void atualizar() {
        var id = pegarId(ATUALIZAR_CLIENTE_TITULO);

        var existeCliente = clienteRepositorio.existePorID(id);

        if (existeCliente.equals(Boolean.FALSE)) {
            JOptionPaneTela.optionMensagemAlerta(
                ATUALIZAR_CLIENTE_TITULO,
                String.format(
                    NAO_ENCONTRADO,
                    id
                )
            );
        } else {
            var nome = LerTela.lerString(ATUALIZAR_CLIENTE_TITULO, "Nome:");
            var cpf = LerTela.lerString(ATUALIZAR_CLIENTE_TITULO, "CPF:");
            var dataNascimento = LerTela.lerDate(ATUALIZAR_CLIENTE_TITULO, "Data de Nascimento:");

            var cliente = new Cliente(
                id,
                nome,
                cpf,
                dataNascimento
            );
            clienteRepositorio.atualizar(cliente);

            JOptionPaneTela.optionMensagemInfo(
                CADASTRAR_CLIENTE_TITULO,
                "Cliente atualizado com sucesso!"
            );
        }
    }

    @Override
    public void buscarTudo() {
        var clientes = clienteRepositorio.buscarTodos();

        clientes.forEach(this::exibir);
    }

    public void buscarPorId() {
        var id = pegarId(BUSCAR_CLIENTE_TITULO);

        var clienteOptional = clienteRepositorio.buscarPorId(id);

        if (clienteOptional.isPresent()) {
            var cliente = clienteOptional.get();
            exibir(cliente);
        } else {
            JOptionPaneTela.optionMensagemInfo(
                BUSCAR_CLIENTE_TITULO,
                String.format(
                    NAO_ENCONTRADO,
                    id
                )
            );
        }
    }

    public void deletarPorId() {
        var id = pegarId(DELETAR_CLIENTE_TITULO);

        clienteRepositorio.deletarPorId(id);

        JOptionPaneTela.optionMensagemInfo(
            DELETAR_CLIENTE_TITULO,
            "Cliente deletada com sucesso!"
        );
    }

    @Override
    public void exibir(Cliente entidade) {
        var mensagem = "Id: %d"
            .concat("\n")
            .concat("Nome: %s")
            .concat("\n")
            .concat("CPF: %s")
            .concat("\n")
            .concat("Data de Nascimento: %s");

        JOptionPaneTela.optionMensagemInfo(
            DADOS_CLIENTE_TITULO,
            String.format(
                mensagem,
                entidade.getId(),
                entidade.getNome(),
                entidade.getCpf(),
                entidade.getDataNascimento()
            )
        );
    }

    private static Integer pegarId(String titulo) {
        return LerTela.lerInteger(titulo, "Id:");
    }
}
