package br.com.pet_shop.servicos;

import br.com.pet_shop.entidades.Funcionario;
import br.com.pet_shop.excecoes.EntidadeNaoEncontrada;
import br.com.pet_shop.repositorio.FuncionarioRepositorio;
import br.com.pet_shop.servicos.interfaces.FuncionarioServicoInterface;
import br.com.pet_shop.tela.entidades.AnimalTela;
import br.com.pet_shop.tela.entidades.FuncionarioTela;
import br.com.pet_shop.utilitarios.constantes.mensagens.AnimalMensagem;

public class FuncionarioServico implements FuncionarioServicoInterface {

    private final FuncionarioRepositorio medicoRepositorio;

    public FuncionarioServico(FuncionarioRepositorio medicoRepositorio) {
        this.medicoRepositorio = medicoRepositorio;
    }

    public Funcionario criar() {
        var medico = FuncionarioTela.criar();
        medicoRepositorio.criar(medico);

        return medicoRepositorio.buscarUltimo();
    }

    public Funcionario atualizar() {
        var medico = FuncionarioTela.atualizar();
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

    public Funcionario buscarPorId() {
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
