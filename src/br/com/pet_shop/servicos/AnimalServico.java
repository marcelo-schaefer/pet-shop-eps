package br.com.pet_shop.servicos;

import br.com.pet_shop.entidades.Animal;
import br.com.pet_shop.excecoes.EntidadeNaoEncontrada;
import br.com.pet_shop.repositorio.interfaces.AnimalRepositorioInterface;
import br.com.pet_shop.tela.entidades.AnimalTela;
import br.com.pet_shop.utilitarios.constantes.mensagens.AnimalMensagem;

public class AnimalServico {

    private final AnimalRepositorioInterface animalRepositorioInterface;

    public AnimalServico(AnimalRepositorioInterface animalRepositorioInterface) {
        this.animalRepositorioInterface = animalRepositorioInterface;
    }

    public Animal criar() {
        var animal = AnimalTela.criar();
        animalRepositorioInterface.criar(animal);

        return animalRepositorioInterface.buscarUltimo();
    }

    public Animal atualizar() {
        var animal = AnimalTela.atualizar();
        var animalId = animal.getId();

        var existeAnimal = animalRepositorioInterface.existePorID(animalId);

        if (existeAnimal.equals(Boolean.FALSE)) {
            throw new EntidadeNaoEncontrada(
                String.format(
                    AnimalMensagem.NAO_ENCONTRADO,
                    animalId
                )
            );
        }
        animalRepositorioInterface.atualizar(animal);

        return animalRepositorioInterface.buscarPorId(animalId).get();
    }

    public Animal buscarPorId() {
        var animal = AnimalTela.buscar();
        var animalId = animal.getId();

        return animalRepositorioInterface.buscarPorId(animalId).orElseThrow(
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

        return animalRepositorioInterface.deletarPorId(animal.getId());
    }
}
