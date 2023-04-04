package br.com.pet_shop.servicos;

import br.com.pet_shop.entidades.Especie;
import br.com.pet_shop.excecoes.EntidadeNaoEncontrada;
import br.com.pet_shop.repositorio.interfaces.EspecieRepositorioInterface;
import br.com.pet_shop.tela.entidades.EspecieTela;
import br.com.pet_shop.utilitarios.constantes.mensagens.EspecieMensagem;

public class EspecieServico {

    private final EspecieRepositorioInterface especieRepositorioInterface;

    public EspecieServico(EspecieRepositorioInterface especieRepositorioInterface) {
        this.especieRepositorioInterface = especieRepositorioInterface;
    }

    public Especie criar() {
        var especie = EspecieTela.criar();
        especieRepositorioInterface.criar(especie);

        return especieRepositorioInterface.buscarUltimo();
    }

    public Especie atualizar() {
        var especie = EspecieTela.atualizar();
        var especieId = especie.getId();

        var existeEspecie = especieRepositorioInterface.existePorID(especieId);

        if (existeEspecie.equals(Boolean.FALSE)) {
            throw new EntidadeNaoEncontrada(
                String.format(
                    EspecieMensagem.NAO_ENCONTRADO,
                    especieId
                )
            );
        }
        especieRepositorioInterface.atualizar(especie);

        return especieRepositorioInterface.buscarPorId(especieId).get();
    }

    public Especie buscarPorId() {
        var especie = EspecieTela.buscar();
        var especieId = especie.getId();

        return especieRepositorioInterface.buscarPorId(especieId).orElseThrow(
            () -> new EntidadeNaoEncontrada(
                String.format(
                    EspecieMensagem.NAO_ENCONTRADO,
                    especieId
                )
            )
        );
    }

    public Boolean deletarPorId() {
        var especie = EspecieTela.deletar();

        return especieRepositorioInterface.deletarPorId(especie.getId());
    }
}
