package br.com.pet_shop.servicos;

import br.com.pet_shop.entidades.Animal;
import br.com.pet_shop.entidades.Consulta;
import br.com.pet_shop.repositorio.ConsultaRepositorio;
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

    private final ConsultaRepositorio consultaRepositorio;

    public ConsultaServico(ConsultaRepositorio consultaRepositorio) {
        this.consultaRepositorio = consultaRepositorio;
    }

    public void criar() {
        var nome = LerTela.lerString(CADASTRAR_CONSULTA_TITULO, "Nome:");
        var observacao = LerTela.lerString(CADASTRAR_CONSULTA_TITULO, "Observação:");
        var horario = LerTela.lerDate(CADASTRAR_CONSULTA_TITULO, "Horário:");
        var animalId = LerTela.lerInteger(CADASTRAR_CONSULTA_TITULO, "Identificador do Animal:");
        var valor = LerTela.lerDouble(CADASTRAR_CONSULTA_TITULO, "Valor:");

        var consulta = new Consulta(
            nome,
            observacao,
            horario,
            valor,
            new Animal(animalId)
        );

        consultaRepositorio.criar(consulta);

        JOptionPaneTela.optionMensagemInfo(
            CADASTRAR_CONSULTA_TITULO,
            "Consulta cadastrada com sucesso!"
        );
    }

    public void atualizar() {
        var id = LerTela.lerInteger(ATUALIZAR_CONSULTA_TITULO, "Id:");

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
            var horario = LerTela.lerDate(ATUALIZAR_CONSULTA_TITULO, "Horário:");
            var animalId = LerTela.lerInteger(ATUALIZAR_CONSULTA_TITULO, "Identificador do Animal:");
            var valor = LerTela.lerDouble(ATUALIZAR_CONSULTA_TITULO, "Valor:");

            var consulta = new Consulta(
                id,
                nome,
                observacao,
                horario,
                valor,
                new Animal(animalId)
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
        var id = LerTela.lerInteger(BUSCAR_CONSULTA_TITULO, "Id:");

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
        var id = LerTela.lerInteger(DELETAR_CONSULTA_TITULO, "Id:");

        consultaRepositorio.deletarPorId(id);

        JOptionPaneTela.optionMensagemInfo(
            DELETAR_CONSULTA_TITULO,
            "Espécie deletada com sucesso!"
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
            .concat("Animal: %d");

        JOptionPaneTela.optionMensagemInfo(
            DADOS_ESPECIE_TITULO,
            String.format(
                mensagem,
                entidade.getId(),
                entidade.getNome(),
                entidade.getObservacao(),
                entidade.getHorario(),
                entidade.getValor(),
                entidade.getAnimal().getId()
            )
        );
    }
}
