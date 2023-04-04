package br.com.pet_shop.servicos;

import br.com.pet_shop.entidades.Consulta;
import br.com.pet_shop.excecoes.EntidadeNaoEncontrada;
import br.com.pet_shop.repositorio.interfaces.ConsultaRepositorioInterface;
import br.com.pet_shop.tela.entidades.ConsultaTela;
import br.com.pet_shop.utilitarios.constantes.mensagens.ConsultaMensagem;

public class ConsultaServico {

    private final ConsultaRepositorioInterface consultaRepositorioInterface;

    public ConsultaServico(ConsultaRepositorioInterface consultaRepositorioInterface) {
        this.consultaRepositorioInterface = consultaRepositorioInterface;
    }

    public Consulta criar() {
        var consulta = ConsultaTela.criar();
        consultaRepositorioInterface.criar(consulta);

        return consultaRepositorioInterface.buscarUltimo();
    }

    public Consulta atualizar() {
        var consulta = ConsultaTela.atualizar();
        var consultaId = consulta.getId();

        var existeConsulta = consultaRepositorioInterface.existePorID(consultaId);

        if (existeConsulta.equals(Boolean.FALSE)) {
            throw new EntidadeNaoEncontrada(
                String.format(
                    ConsultaMensagem.NAO_ENCONTRADO,
                    consultaId
                )
            );
        }
        consultaRepositorioInterface.atualizar(consulta);

        return consultaRepositorioInterface.buscarPorId(consultaId).get();
    }

    public Consulta buscarPorId() {
        var consulta = ConsultaTela.buscar();
        var consultaId = consulta.getId();

        return consultaRepositorioInterface.buscarPorId(consultaId).orElseThrow(
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

        return consultaRepositorioInterface.deletarPorId(consulta.getId());
    }
}
