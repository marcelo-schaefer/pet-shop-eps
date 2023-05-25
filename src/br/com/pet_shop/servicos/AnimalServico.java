package br.com.pet_shop.servicos;

import br.com.pet_shop.excecoes.EntidadeNaoEncontrada;
import br.com.pet_shop.repositorio.AnimalRepositorio;
import br.com.pet_shop.servicos.interfaces.AnimalServicoInterface;
import br.com.pet_shop.tela.entidades.AnimalTela;
import br.com.pet_shop.utilitarios.constantes.mensagens.AnimalMensagem;

public class AnimalServico implements AnimalServicoInterface {

    private final AnimalRepositorio animalRepositorio;

    public AnimalServico(AnimalRepositorio animalRepositorio) {
        this.animalRepositorio = animalRepositorio;
    }

    public void criar() {
        var animal = AnimalTela.criar();
        animalRepositorio.criar(animal);

        animalRepositorio.criar(animal);
    }

    public void atualizar() {
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

        animalRepositorio.buscarPorId(animalId).get();
    }

    @Override
    public void buscarTudo() {

    }

    public void buscarPorId() {
        var animal = AnimalTela.buscar();
        var animalId = animal.getId();

        animalRepositorio.buscarPorId(animalId).orElseThrow(
            () -> new EntidadeNaoEncontrada(
                String.format(
                    AnimalMensagem.NAO_ENCONTRADO,
                    animalId
                )
            )
        );
    }

    public void deletarPorId() {
        var animal = AnimalTela.deletar();

        animalRepositorio.deletarPorId(animal.getId());

    }

    @Override
    public void exibir(Object entidade) {

    }
}
