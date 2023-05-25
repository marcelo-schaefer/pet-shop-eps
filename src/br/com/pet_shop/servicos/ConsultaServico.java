package br.com.pet_shop.servicos;

import br.com.pet_shop.excecoes.EntidadeNaoEncontrada;
import br.com.pet_shop.repositorio.ConsultaRepositorio;
import br.com.pet_shop.servicos.interfaces.ConsultaServicoInterface;
import br.com.pet_shop.tela.entidades.ConsultaTela;
import br.com.pet_shop.utilitarios.constantes.mensagens.ConsultaMensagem;

public class ConsultaServico implements ConsultaServicoInterface {

    private final ConsultaRepositorio consultaRepositorio;

    public ConsultaServico(ConsultaRepositorio consultaRepositorio) {
        this.consultaRepositorio = consultaRepositorio;
    }

    public void criar() {
        var consulta = ConsultaTela.criar();
        consultaRepositorio.criar(consulta);

        consultaRepositorio.criar(consulta);
    }

    public void atualizar() {
        var consulta = ConsultaTela.atualizar();
        var consultaId = consulta.getId();

        var existeConsulta = consultaRepositorio.existePorID(consultaId);

        if (existeConsulta.equals(Boolean.FALSE)) {
            throw new EntidadeNaoEncontrada(
                String.format(
                    ConsultaMensagem.NAO_ENCONTRADO,
                    consultaId
                )
            );
        }
        consultaRepositorio.atualizar(consulta);

        consultaRepositorio.buscarPorId(consultaId).get();
    }

    @Override
    public void buscarTudo() {

    }

    public void buscarPorId() {
        var consulta = ConsultaTela.buscar();
        var consultaId = consulta.getId();

        consultaRepositorio.buscarPorId(consultaId).orElseThrow(
            () -> new EntidadeNaoEncontrada(
                String.format(
                    ConsultaMensagem.NAO_ENCONTRADO,
                    consultaId
                )
            )
        );
    }

    public void deletarPorId() {
        var consulta = ConsultaTela.deletar();

        consultaRepositorio.deletarPorId(consulta.getId());
    }

    @Override
    public void exibir(Object entidade) {

    }
}
