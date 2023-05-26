package br.com.pet_shop.servicos;

import br.com.pet_shop.entidades.Animal;
import br.com.pet_shop.entidades.Especie;
import br.com.pet_shop.repositorio.AnimalRepositorio;
import br.com.pet_shop.servicos.interfaces.AnimalServicoInterface;
import br.com.pet_shop.tela.dados.JOptionPaneTela;
import br.com.pet_shop.tela.dados.LerEnumTela;
import br.com.pet_shop.tela.dados.LerTela;

public class AnimalServico implements AnimalServicoInterface {

    private static final String NAO_ENCONTRADO = "Animal com o id \"%d\" não encontrado.";

    private static final String DADOS_ESPECIE_TITULO = "Dados do Animal";

    private static final String CADASTRAR_ANIMAL_TITULO = "Cadastrar Animal";

    private static final String ATUALIZAR_ANIMAL_TITULO = "Atualizar Animal";

    private static final String BUSCAR_ANIMAL_TITULO = "Buscar Animal";

    private static final String DELETAR_ANIMAL_TITULO = "Deletar Animal";


    private final AnimalRepositorio animalRepositorio;

    public AnimalServico(AnimalRepositorio animalRepositorio) {
        this.animalRepositorio = animalRepositorio;
    }

    public void criar() {
        var nome = LerTela.lerString(CADASTRAR_ANIMAL_TITULO, "Nome:");
        var detalhe = LerTela.lerString(CADASTRAR_ANIMAL_TITULO, "Detalhe:");
        var dataNascimento = LerTela.lerDate(CADASTRAR_ANIMAL_TITULO, "Data de Nascimento:");
        var sexoEnum = LerEnumTela.lerSexoEnum(CADASTRAR_ANIMAL_TITULO);
        var especieId = LerTela.lerInteger(CADASTRAR_ANIMAL_TITULO, "Identificador da especie:");

        var animal = new Animal(
            nome,
            detalhe,
            dataNascimento,
            sexoEnum,
            Boolean.TRUE,
            new Especie(especieId)
        );

        animalRepositorio.criar(animal);

        JOptionPaneTela.optionMensagemInfo(
            CADASTRAR_ANIMAL_TITULO,
            "Animal cadastrado com sucesso!"
        );
    }

    public void atualizar() {
        var id = LerTela.lerInteger(ATUALIZAR_ANIMAL_TITULO, "Id:");

        var animalExiste = animalRepositorio.existePorID(id);

        if (animalExiste.equals(Boolean.FALSE)) {
            JOptionPaneTela.optionMensagemAlerta(
                ATUALIZAR_ANIMAL_TITULO,
                String.format(
                    NAO_ENCONTRADO,
                    id
                )
            );
        } else {
            var nome = LerTela.lerString(ATUALIZAR_ANIMAL_TITULO, "Nome:");
            var detalhe = LerTela.lerString(ATUALIZAR_ANIMAL_TITULO, "Detalhe:");
            var dataNascimento = LerTela.lerDate(ATUALIZAR_ANIMAL_TITULO, "Data de Nascimento:");
            var sexoEnum = LerEnumTela.lerSexoEnum(ATUALIZAR_ANIMAL_TITULO);
            var ativo = LerTela.lerBoolean(ATUALIZAR_ANIMAL_TITULO, "Ativo?");
            var especieId = LerTela.lerInteger(ATUALIZAR_ANIMAL_TITULO, "Identificador da especie:");

            var animal = new Animal(
                id,
                nome,
                detalhe,
                dataNascimento,
                sexoEnum,
                ativo,
                new Especie(especieId)
            );

            animalRepositorio.atualizar(animal);

            JOptionPaneTela.optionMensagemInfo(
                CADASTRAR_ANIMAL_TITULO,
                "Animal atualizado com sucesso!"
            );
        }
    }

    @Override
    public void buscarTudo() {
        var animais = animalRepositorio.buscarTodos();

        animais.forEach(this::exibir);
    }

    public void buscarPorId() {
        var id = LerTela.lerInteger(BUSCAR_ANIMAL_TITULO, "Id:");

        var animalOptional = animalRepositorio.buscarPorId(id);

        if (animalOptional.isPresent()) {
            var animal = animalOptional.get();

            exibir(animal);
        } else {
            JOptionPaneTela.optionMensagemInfo(
                BUSCAR_ANIMAL_TITULO,
                String.format(
                    NAO_ENCONTRADO,
                    id
                )
            );
        }
    }

    public void deletarPorId() {
        var id = LerTela.lerInteger(DELETAR_ANIMAL_TITULO, "Id:");

        animalRepositorio.deletarPorId(id);

        JOptionPaneTela.optionMensagemInfo(
            DELETAR_ANIMAL_TITULO,
            "Animal deletado com sucesso!"
        );
    }

    @Override
    public void exibir(Animal entidade) {
        var mensagem = "Id: %d"
            .concat("\n")
            .concat("Nome: %s")
            .concat("\n")
            .concat("Detalhe: %s")
            .concat("\n")
            .concat("Data Nascimento: %s")
            .concat("\n")
            .concat("Sexo: %s")
            .concat("\n")
            .concat("Ativo: %b")
            .concat("\n")
            .concat("Espécie: %d");

        JOptionPaneTela.optionMensagemInfo(
            DADOS_ESPECIE_TITULO,
            String.format(
                mensagem,
                entidade.getId(),
                entidade.getNome(),
                entidade.getDetalhe(),
                entidade.getDataNascimento(),
                entidade.getSexo(),
                entidade.getAtivo(),
                entidade.getEspecie().getId()
            )
        );
    }
}
