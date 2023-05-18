package br.com.pet_shop.servicos;

import br.com.pet_shop.entidades.Especie;
import br.com.pet_shop.excecoes.EntidadeNaoEncontrada;
import br.com.pet_shop.repositorio.EspecieRepositorio;
import br.com.pet_shop.servicos.interfaces.EspecieServicoInterface;
import br.com.pet_shop.tela.entidades.EspecieTela;
import br.com.pet_shop.utilitarios.constantes.mensagens.EspecieMensagem;

public class EspecieServico implements EspecieServicoInterface {

    private final EspecieRepositorio especieRepositorio;

    public EspecieServico(EspecieRepositorio especieRepositorio) {
        this.especieRepositorio = especieRepositorio;
    }

    public Especie criar() {
        var especie = EspecieTela.criar();
        especieRepositorio.criar(especie);

        return especieRepositorio.criar(especie);
    }

    public Especie atualizar() {
        var especie = EspecieTela.atualizar();
        var especieId = especie.getId();

        var existeEspecie = especieRepositorio.existePorID(especieId);

        if (existeEspecie.equals(Boolean.FALSE)) {
            throw new EntidadeNaoEncontrada(
                String.format(
                    EspecieMensagem.NAO_ENCONTRADO,
                    especieId
                )
            );
        }
        especieRepositorio.atualizar(especie);

        return especieRepositorio.buscarPorId(especieId).get();
    }

    public Especie buscarPorId() {
        var especie = EspecieTela.buscar();
        var especieId = especie.getId();

        return especieRepositorio.buscarPorId(especieId).orElseThrow(
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

        especieRepositorio.deletarPorId(especie.getId());

        return Boolean.TRUE;
    }
}
