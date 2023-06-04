package br.com.pet_shop.servicos;

import br.com.pet_shop.entidades.Funcionario;
import br.com.pet_shop.repositorio.FuncionarioRepositorio;
import br.com.pet_shop.servicos.interfaces.FuncionarioServicoInterface;
import br.com.pet_shop.tela.dados.JOptionPaneTela;
import br.com.pet_shop.tela.dados.LerTela;

public class FuncionarioServico implements FuncionarioServicoInterface {

    private static final String NAO_ENCONTRADO = "Funcionário com o id \"%d\" não encontrado.";

    private static final String DADOS_FUNCIONARIO_TITULO = "Dados do Funcionário";

    private static final String CADASTRAR_FUNCIONARIO_TITULO = "Cadastrar Funcionário";

    private static final String ATUALIZAR_FUNCIONARIO_TITULO = "Atualizar Funcionário";

    private static final String BUSCAR_FUNCIONARIO_TITULO = "Buscar Funcionário";

    private static final String DELETAR_FUNCIONARIO_TITULO = "Deletar Funcionário";

    private final FuncionarioRepositorio funcionarioRepositorio = new FuncionarioRepositorio();

    public void criar() {
        var nome = LerTela.lerString(CADASTRAR_FUNCIONARIO_TITULO, "Nome:");
        var cpf = LerTela.lerString(CADASTRAR_FUNCIONARIO_TITULO, "Cpf:");
        var dataNascimento = LerTela.lerDate(CADASTRAR_FUNCIONARIO_TITULO, "Data de Nascimento:");
        var cargo = LerTela.lerString(CADASTRAR_FUNCIONARIO_TITULO, "Cargo:");

        var funcionario = new Funcionario(
            nome,
            cpf,
            dataNascimento,
            cargo
        );

        funcionarioRepositorio.criar(funcionario);

        JOptionPaneTela.optionMensagemInfo(
            CADASTRAR_FUNCIONARIO_TITULO,
            "Funcionário cadastrado com sucesso!"
        );
    }

    public void atualizar() {
        var id = pegarId(ATUALIZAR_FUNCIONARIO_TITULO);

        var existeFuncionario = funcionarioRepositorio.existePorID(id);

        if (existeFuncionario.equals(Boolean.FALSE)) {
            JOptionPaneTela.optionMensagemAlerta(
                ATUALIZAR_FUNCIONARIO_TITULO,
                String.format(
                    NAO_ENCONTRADO,
                    id
                )
            );
        } else {
            var nome = LerTela.lerString(ATUALIZAR_FUNCIONARIO_TITULO, "Nome:");
            var cpf = LerTela.lerString(CADASTRAR_FUNCIONARIO_TITULO, "Cpf:");
            var dataNascimento = LerTela.lerDate(ATUALIZAR_FUNCIONARIO_TITULO, "Data de Nascimento:");
            var cargo = LerTela.lerString(CADASTRAR_FUNCIONARIO_TITULO, "Cargo:");

            var funcionario = new Funcionario(
                id,
                nome,
                cpf,
                dataNascimento,
                cargo
            );
            funcionarioRepositorio.atualizar(funcionario);

            JOptionPaneTela.optionMensagemInfo(
                CADASTRAR_FUNCIONARIO_TITULO,
                "Funcionário atualizado com sucesso!"
            );
        }
    }

    @Override
    public void buscarTudo() {
        var funcionarios = funcionarioRepositorio.buscarTodos();

        funcionarios.forEach(this::exibir);
    }

    public void buscarPorId() {
        var id = pegarId(BUSCAR_FUNCIONARIO_TITULO);

        var funcionarioOptional = funcionarioRepositorio.buscarPorId(id);

        if (funcionarioOptional.isPresent()) {
            var funcionario = funcionarioOptional.get();
            exibir(funcionario);
        } else {
            JOptionPaneTela.optionMensagemInfo(
                BUSCAR_FUNCIONARIO_TITULO,
                String.format(
                    NAO_ENCONTRADO,
                    id
                )
            );
        }
    }

    public void deletarPorId() {
        var id = pegarId(DELETAR_FUNCIONARIO_TITULO);

        funcionarioRepositorio.deletarPorId(id);

        JOptionPaneTela.optionMensagemInfo(
            DELETAR_FUNCIONARIO_TITULO,
            "Espécie deletada com sucesso!"
        );
    }

    @Override
    public void exibir(Funcionario entidade) {
        var mensagem = "Id: %d"
            .concat("\n")
            .concat("Nome: %s")
            .concat("\n")
            .concat("CPF: %s")
            .concat("\n")
            .concat("Data de Nascimento: %s")
            .concat("\n")
            .concat("Cargo: %s");

        JOptionPaneTela.optionMensagemInfo(
            DADOS_FUNCIONARIO_TITULO,
            String.format(
                mensagem,
                entidade.getId(),
                entidade.getNome(),
                entidade.getCpf(),
                entidade.getDataNascimento(),
                entidade.getCargo()
            )
        );
    }

    private static Integer pegarId(String titulo) {
        return LerTela.lerInteger(titulo, "Id:");
    }
}
