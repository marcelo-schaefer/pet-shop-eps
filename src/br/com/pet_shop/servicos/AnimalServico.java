package br.com.pet_shop.servicos;

import br.com.pet_shop.entidades.Animal;
import br.com.pet_shop.excecoes.EntidadeNaoEncontrada;
import br.com.pet_shop.repositorio.AnimalRepositorio;
import br.com.pet_shop.servicos.interfaces.AnimalServicoInterface;
import br.com.pet_shop.servicos.interfaces.ServicoInterface;
import br.com.pet_shop.tela.entidades.AnimalTela;
import br.com.pet_shop.utilitarios.constantes.mensagens.AnimalMensagem;

public class AnimalServico implements AnimalServicoInterface {

    private final AnimalRepositorio animalRepositorio;

    public AnimalServico(AnimalRepositorio animalRepositorio) {
        this.animalRepositorio = animalRepositorio;
    }

    public Animal criar() {
        var animal = AnimalTela.criar();
        animalRepositorio.criar(animal);

        return animalRepositorio.buscarUltimo();
    }

    public Animal atualizar() {
        var animal = AnimalTela.atualizar();
        var animalId = animal.getId();

        var existeAnimal = animalRepositorio.existePorID(animalId);

        if (existeAnimal.equals(Boolean.FALSE)) {
            throw new EntidadeNaoEncontrada(
                String.format(
                    AnimalMensagem.NAO_ENCONTRADO,
                    animalId
                )
            );
        }
        animalRepositorio.atualizar(animal);

        return animalRepositorio.buscarPorId(animalId).get();
    }

    public Animal buscarPorId() {
        var animal = AnimalTela.buscar();
        var animalId = animal.getId();

        return animalRepositorio.buscarPorId(animalId).orElseThrow(
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

        return animalRepositorio.deletarPorId(animal.getId());
    }
}
