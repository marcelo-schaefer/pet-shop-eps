package br.com.pet_shop.servicos;

import br.com.pet_shop.entidades.Medico;
import br.com.pet_shop.excecoes.EntidadeNaoEncontrada;
import br.com.pet_shop.repositorio.AnimalRepositorio;
import br.com.pet_shop.repositorio.MedicoRepositorio;
import br.com.pet_shop.servicos.interfaces.MedicoServicoInterface;
import br.com.pet_shop.tela.entidades.AnimalTela;
import br.com.pet_shop.tela.entidades.MedicoTela;
import br.com.pet_shop.utilitarios.constantes.mensagens.AnimalMensagem;

public class MedicoServico implements MedicoServicoInterface {

    private final MedicoRepositorio medicoRepositorio;

    public MedicoServico(MedicoRepositorio medicoRepositorio) {
        this.medicoRepositorio = medicoRepositorio;
    }

    public Medico criar() {
        var medico = MedicoTela.criar();
        medicoRepositorio.criar(medico);

        return medicoRepositorio.buscarUltimo();
    }

    public Medico atualizar() {
        var medico = MedicoTela.atualizar();
        var medicoId = medico.getId();

        var existeAnimal = medicoRepositorio.existePorID(medicoId);

        if (existeAnimal.equals(Boolean.FALSE)) {
            throw new EntidadeNaoEncontrada(
                String.format(
                    AnimalMensagem.NAO_ENCONTRADO,
                    medicoId
                )
            );
        }
        medicoRepositorio.atualizar(medico);

        return medicoRepositorio.buscarPorId(medicoId).get();
    }

    public Medico buscarPorId() {
        var animal = AnimalTela.buscar();
        var animalId = animal.getId();

        return medicoRepositorio.buscarPorId(animalId).orElseThrow(
            () -> new EntidadeNaoEncontrada(
                String.format(
                    AnimalMensagem.NAO_ENCONTRADO,
                    animalId
                )
            )
        );
    }

    public Boolean deletarPorId() {
        var animal = AnimalTela.deletar();

        return medicoRepositorio.deletarPorId(animal.getId());
    }
}
