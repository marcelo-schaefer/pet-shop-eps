package br.com.pet_shop.servicos;

import br.com.pet_shop.entidades.Consulta;
import br.com.pet_shop.excecoes.EntidadeNaoEncontrada;
import br.com.pet_shop.repositorio.ConsultaRepositorio;
import br.com.pet_shop.servicos.interfaces.AnimalServicoInterface;
import br.com.pet_shop.servicos.interfaces.ConsultaServicoInterface;
import br.com.pet_shop.tela.entidades.ConsultaTela;
import br.com.pet_shop.utilitarios.constantes.mensagens.ConsultaMensagem;

public class ConsultaServico implements ConsultaServicoInterface {

    private final ConsultaRepositorio consultaRepositorio;

    public ConsultaServico(ConsultaRepositorio consultaRepositorio) {
        this.consultaRepositorio = consultaRepositorio;
    }

    public Consulta criar() {
        var consulta = ConsultaTela.criar();
        consultaRepositorio.criar(consulta);

        return consultaRepositorio.criar(consulta);
    }

    public Consulta atualizar() {
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

        return consultaRepositorio.buscarPorId(consultaId).get();
    }

    public Consulta buscarPorId() {
        var consulta = ConsultaTela.buscar();
        var consultaId = consulta.getId();

        return consultaRepositorio.buscarPorId(consultaId).orElseThrow(
            () -> new EntidadeNaoEncontrada(
                String.format(
                    ConsultaMensagem.NAO_ENCONTRADO,
                    consultaId
                )
            )
        );
    }

    public Boolean deletarPorId() {
        var consulta = ConsultaTela.deletar();

        return consultaRepositorio.deletarPorId(consulta.getId());
    }
}
