package br.com.pet_shop.servicos;

import br.com.pet_shop.entidades.Animal;
import br.com.pet_shop.entidades.Cliente;
import br.com.pet_shop.entidades.Especie;
import br.com.pet_shop.repositorio.AnimalRepositorio;
import br.com.pet_shop.repositorio.ClienteRepositorio;
import br.com.pet_shop.repositorio.ConsultaRepositorio;
import br.com.pet_shop.repositorio.EspecieRepositorio;
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

    private final AnimalRepositorio animalRepositorio = new AnimalRepositorio();

    public void criar() {
        var nome = LerTela.lerString(CADASTRAR_ANIMAL_TITULO, "Nome:");
        var detalhe = LerTela.lerString(CADASTRAR_ANIMAL_TITULO, "Detalhe:");
        var dataNascimento = LerTela.lerDate(CADASTRAR_ANIMAL_TITULO, "Data de Nascimento:");
        var sexoEnum = LerEnumTela.lerSexoEnum(CADASTRAR_ANIMAL_TITULO);
        var especie = pegarEspecie(CADASTRAR_ANIMAL_TITULO);
        var cliente = pegarCliente(CADASTRAR_ANIMAL_TITULO);

        var animal = new Animal(
            nome,
            detalhe,
            dataNascimento,
            sexoEnum,
            Boolean.TRUE,
            especie,
            cliente
        );

        animalRepositorio.criar(animal);

        JOptionPaneTela.optionMensagemInfo(
            CADASTRAR_ANIMAL_TITULO,
            "Animal cadastrado com sucesso!"
        );
    }

    public void atualizar() {
        var id = pegarId(ATUALIZAR_ANIMAL_TITULO);

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
            var especie = pegarEspecie(ATUALIZAR_ANIMAL_TITULO);
            var cliente = pegarCliente(CADASTRAR_ANIMAL_TITULO);

            var animal = new Animal(
                id,
                nome,
                detalhe,
                dataNascimento,
                sexoEnum,
                ativo,
                especie,
                cliente
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
        var id = pegarId(BUSCAR_ANIMAL_TITULO);

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
        var id = pegarId(DELETAR_ANIMAL_TITULO);

        var existeVinculo = existeVinculoComConsulta(id);

        if (existeVinculo.equals(Boolean.FALSE)) {
            animalRepositorio.deletarPorId(id);

            JOptionPaneTela.optionMensagemInfo(
                DELETAR_ANIMAL_TITULO,
                "Animal deletado com sucesso!"
            );
        } else {
            JOptionPaneTela.optionMensagemAlerta(
                DELETAR_ANIMAL_TITULO,
                "Animal não pode ser deletado pois existem consultas vinculadas."
            );
        }
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
            .concat("Espécie: %d")
            .concat("\n")
            .concat("Cliente: %d");

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
                entidade.getEspecie().getId(),
                entidade.getCliente().getId()
            )
        );
    }

    private Especie pegarEspecie(String titulo) {
        do {
            var especieId = LerTela.lerInteger(titulo, "Identificador da Espécie:");
            var especieRepositorio = new EspecieRepositorio();

            var existe = especieRepositorio.existePorID(especieId);

            if (existe.equals(Boolean.TRUE)) {
                return new Especie(especieId);
            } else {
                JOptionPaneTela.optionMensagemInfo(
                    titulo,
                    String.format(
                        "Não existe uma Espécie cadastrada com o id \"%s\"",
                        especieId
                    )
                );
            }
        } while (true);
    }

    private Cliente pegarCliente(String titulo) {
        do {
            var clienteId = LerTela.lerInteger(titulo, "Identificador do Cliente:");
            var clienteRepositorio = new ClienteRepositorio();

            var existe = clienteRepositorio.existePorID(clienteId);

            if (existe.equals(Boolean.TRUE)) {
                return new Cliente(clienteId);
            } else {
                JOptionPaneTela.optionMensagemInfo(
                    titulo,
                    String.format(
                        "Não existe um Cliente cadastrado com o id \"%s\"",
                        clienteId
                    )
                );
            }
        } while (true);
    }

    public Integer pegarId(String titulo) {
        return LerTela.lerInteger(titulo, "Id:");
    }

    private Boolean existeVinculoComConsulta(Integer id) {
        var consultaRepositorio = new ConsultaRepositorio();

        return consultaRepositorio.existePorAnimalId(id);
    }
}
