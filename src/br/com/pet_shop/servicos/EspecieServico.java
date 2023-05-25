package br.com.pet_shop.servicos;

import br.com.pet_shop.entidades.Especie;
import br.com.pet_shop.repositorio.EspecieRepositorio;
import br.com.pet_shop.servicos.interfaces.EspecieServicoInterface;
import br.com.pet_shop.tela.dados.JOptionPaneTela;
import br.com.pet_shop.tela.dados.LerTela;

public class EspecieServico implements EspecieServicoInterface {

    private static final String NAO_ENCONTRADO = "Espécie com o id \"%d\" não encontrada.";

    private static final String DADOS_ESPECIE_TITULO = "Dados da Especie";

    private static final String CADASTRAR_ESPECIE_TITULO = "Cadastrar Especie";

    private static final String ATUALIZAR_ESPECIE_TITULO = "Atualizar Especie";

    private static final String BUSCAR_ESPECIE_TITULO = "Buscar Especie";

    private static final String DELETAR_ESPECIE_TITULO = "Deletar Especie";

    private final EspecieRepositorio especieRepositorio;

    public EspecieServico(EspecieRepositorio especieRepositorio) {
        this.especieRepositorio = especieRepositorio;
    }

    public void criar() {
        var nome = LerTela.lerString(CADASTRAR_ESPECIE_TITULO, "Nome:");

        var especie = new Especie(nome);
        especieRepositorio.criar(especie);

        JOptionPaneTela.optionMensagemInfo(
            CADASTRAR_ESPECIE_TITULO,
            "Espécie cadastrada com sucesso!"
        );
    }

    public void atualizar() {
        var id = LerTela.lerInteger(ATUALIZAR_ESPECIE_TITULO, "Id:");

        var existeEspecie = especieRepositorio.existePorID(id);

        if (existeEspecie.equals(Boolean.FALSE)) {
            JOptionPaneTela.optionMensagemAlerta(
                ATUALIZAR_ESPECIE_TITULO,
                String.format(
                    NAO_ENCONTRADO,
                    id
                )
            );
        } else {
            var nome = LerTela.lerString(ATUALIZAR_ESPECIE_TITULO, "Nome:");

            var especie = new Especie(id, nome);
            especieRepositorio.atualizar(especie);

            JOptionPaneTela.optionMensagemInfo(
                CADASTRAR_ESPECIE_TITULO,
                "Espécie atualizada com sucesso!"
            );
        }
    }

    public void buscarTudo() {
        var especies = especieRepositorio.buscarTodos();

        especies.forEach(this::exibir);
    }

    public void buscarPorId() {
        var id = LerTela.lerInteger(BUSCAR_ESPECIE_TITULO, "Id:");

        var especieOptional = especieRepositorio.buscarPorId(id);

        if (especieOptional.isPresent()) {
            var especie = especieOptional.get();
            exibir(especie);
        } else {
            JOptionPaneTela.optionMensagemInfo(
                BUSCAR_ESPECIE_TITULO,
                String.format(
                    NAO_ENCONTRADO,
                    id
                )
            );
        }
    }

    public void deletarPorId() {
        var id = LerTela.lerInteger(DELETAR_ESPECIE_TITULO, "Id:");

        especieRepositorio.deletarPorId(id);

        JOptionPaneTela.optionMensagemInfo(
            DELETAR_ESPECIE_TITULO,
            "Espécie deletada com sucesso!"
        );
    }

    public void exibir(Especie entidade) {
        var mensagem = "Id: %d"
            .concat("\n")
            .concat("Nome: %s");

        JOptionPaneTela.optionMensagemInfo(
            DADOS_ESPECIE_TITULO,
            String.format(
                mensagem,
                entidade.getId(),
                entidade.getNome()
            )
        );
    }
}
