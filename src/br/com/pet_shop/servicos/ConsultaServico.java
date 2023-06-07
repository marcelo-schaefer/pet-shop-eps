package br.com.pet_shop.servicos;

import br.com.pet_shop.entidades.Animal;
import br.com.pet_shop.entidades.Consulta;
import br.com.pet_shop.entidades.Funcionario;
import br.com.pet_shop.repositorio.AnimalRepositorio;
import br.com.pet_shop.repositorio.ConsultaRepositorio;
import br.com.pet_shop.repositorio.FuncionarioRepositorio;
import br.com.pet_shop.servicos.interfaces.ConsultaServicoInterface;
import br.com.pet_shop.tela.dados.JOptionPaneTela;
import br.com.pet_shop.tela.dados.LerTela;

public class ConsultaServico implements ConsultaServicoInterface {

    private static final String NAO_ENCONTRADO = "Consulta com o id \"%d\" não encontrada.";

    private static final String DADOS_ESPECIE_TITULO = "Dados da Consulta";

    private static final String CADASTRAR_CONSULTA_TITULO = "Cadastrar Consulta";

    private static final String ATUALIZAR_CONSULTA_TITULO = "Atualizar Consulta";

    private static final String BUSCAR_CONSULTA_TITULO = "Buscar Consulta";

    private static final String DELETAR_CONSULTA_TITULO = "Deletar Consulta";

    private final ConsultaRepositorio consultaRepositorio = new ConsultaRepositorio();

    public void criar() {
        var nome = LerTela.lerString(CADASTRAR_CONSULTA_TITULO, "Nome:");
        var observacao = LerTela.lerString(CADASTRAR_CONSULTA_TITULO, "Observação:");
        var horario = LerTela.lerLocalTime(CADASTRAR_CONSULTA_TITULO, "Horário:");
        var valor = LerTela.lerDouble(CADASTRAR_CONSULTA_TITULO, "Valor:");
        var animal = pegarAnimal(CADASTRAR_CONSULTA_TITULO);
        var funcionario = pegarFuncionario(CADASTRAR_CONSULTA_TITULO);

        var consulta = new Consulta(
            nome,
            observacao,
            horario,
            valor,
            animal,
            funcionario
        );

        consultaRepositorio.criar(consulta);

        JOptionPaneTela.optionMensagemInfo(
            CADASTRAR_CONSULTA_TITULO,
            "Consulta cadastrada com sucesso!"
        );
    }

    public void atualizar() {
        var id = pegarId(ATUALIZAR_CONSULTA_TITULO);

        var consultaEspecie = consultaRepositorio.existePorID(id);

        if (consultaEspecie.equals(Boolean.FALSE)) {
            JOptionPaneTela.optionMensagemAlerta(
                ATUALIZAR_CONSULTA_TITULO,
                String.format(
                    NAO_ENCONTRADO,
                    id
                )
            );
        } else {
            var nome = LerTela.lerString(ATUALIZAR_CONSULTA_TITULO, "Nome:");
            var observacao = LerTela.lerString(ATUALIZAR_CONSULTA_TITULO, "Observação:");
            var horario = LerTela.lerLocalTime(ATUALIZAR_CONSULTA_TITULO, "Horário:");
            var valor = LerTela.lerDouble(ATUALIZAR_CONSULTA_TITULO, "Valor:");
            var animal = pegarAnimal(ATUALIZAR_CONSULTA_TITULO);
            var funcionario = pegarFuncionario(ATUALIZAR_CONSULTA_TITULO);

            var consulta = new Consulta(
                id,
                nome,
                observacao,
                horario,
                valor,
                animal,
                funcionario
            );
            consultaRepositorio.atualizar(consulta);

            JOptionPaneTela.optionMensagemInfo(
                CADASTRAR_CONSULTA_TITULO,
                "Consulta atualizada com sucesso!"
            );
        }
    }

    @Override
    public void buscarTudo() {
        var consultas = consultaRepositorio.buscarTodos();

        consultas.forEach(this::exibir);
    }

    public void buscarPorId() {
        var id = pegarId(BUSCAR_CONSULTA_TITULO);

        var optionalConsulta = consultaRepositorio.buscarPorId(id);

        if (optionalConsulta.isPresent()) {
            var consulta = optionalConsulta.get();

            exibir(consulta);
        } else {
            JOptionPaneTela.optionMensagemInfo(
                BUSCAR_CONSULTA_TITULO,
                String.format(
                    NAO_ENCONTRADO,
                    id
                )
            );
        }
    }

    public void deletarPorId() {
        var id = pegarId(DELETAR_CONSULTA_TITULO);

        consultaRepositorio.deletarPorId(id);

        JOptionPaneTela.optionMensagemInfo(
            DELETAR_CONSULTA_TITULO,
            "Consulta deletada com sucesso!"
        );
    }

    @Override
    public void exibir(Consulta entidade) {
        var mensagem = "Id: %d"
            .concat("\n")
            .concat("Nome: %s")
            .concat("\n")
            .concat("Observação: %s")
            .concat("\n")
            .concat("Horário: %s")
            .concat("\n")
            .concat("Valor: R$%.2f")
            .concat("\n")
            .concat("Animal: %d")
            .concat("\n")
            .concat("Funcionário: %d");

        JOptionPaneTela.optionMensagemInfo(
            DADOS_ESPECIE_TITULO,
            String.format(
                mensagem,
                entidade.getId(),
                entidade.getNome(),
                entidade.getObservacao(),
                entidade.getHorario(),
                entidade.getValor(),
                entidade.getAnimal().getId(),
                entidade.getFuncionario().getId()
            )
        );
    }

    private Animal pegarAnimal(String titulo) {
        do {
            var animalId = LerTela.lerInteger(titulo, "Identificador do Animal:");
            var animalRepositorio = new AnimalRepositorio();

            var existe = animalRepositorio.existePorID(animalId);

            if (existe.equals(Boolean.TRUE)) {
                return new Animal(animalId);
            } else {
                JOptionPaneTela.optionMensagemInfo(
                    titulo,
                    String.format(
                        "Não existe um Animal cadastrada com o id \"%d\"",
                        animalId
                    )
                );
            }
        } while (true);
    }

    private Funcionario pegarFuncionario(String titulo) {
        do {
            var funcionarioId = LerTela.lerInteger(titulo, "Identificador do Funcionário:");
            var funcionarioRepositorio = new FuncionarioRepositorio();

            var existe = funcionarioRepositorio.existePorID(funcionarioId);

            if (existe.equals(Boolean.TRUE)) {
                return new Funcionario(funcionarioId);
            } else {
                JOptionPaneTela.optionMensagemInfo(
                    titulo,
                    String.format(
                        "Não existe um Funcionário cadastrado com o id \"%d\"",
                        funcionarioId
                    )
                );
            }
        } while (true);
    }

    private static Integer pegarId(String titulo) {
        return LerTela.lerInteger(titulo, "Id:");
    }
}
