package br.com.pet_shop.repositorio;

import br.com.pet_shop.entidades.Animal;
import br.com.pet_shop.enums.TipoParametroEnum;
import br.com.pet_shop.banco.sql.AnimalSqlConstante;
import br.com.pet_shop.utilitarios.conversores.AnimalConversor;
import br.com.pet_shop.utilitarios.dto.ParametroQuery;

import java.util.List;
import java.util.Optional;

public class AnimalRepositorio extends RepositorioAbstract<Animal> {

    public AnimalRepositorio() {
        super(new AnimalConversor());
    }

    @Override
    public Animal criar(Animal entidade) {
        var parametros = List.of(
            new ParametroQuery(
                TipoParametroEnum.STRING,
                entidade.getNome(),
                1
            ),
            new ParametroQuery(
                TipoParametroEnum.STRING,
                entidade.getDetalhe(),
                2
            ),
            new ParametroQuery(
                TipoParametroEnum.DATE,
                entidade.getDataNascimento(),
                3
            ),
            new ParametroQuery(
                TipoParametroEnum.ENUM,
                entidade.getSexo(),
                4
            ),
            new ParametroQuery(
                TipoParametroEnum.INTEGER,
                entidade.getEspecie().getId(),
                5
            ),
            new ParametroQuery(
                TipoParametroEnum.INTEGER,
                entidade.getCliente().getId(),
                6
            )
        );

        return persistir(AnimalSqlConstante.CRIAR, parametros);
    }

    @Override
    public Animal atualizar(Animal entidade) {
        var parametros = List.of(
            new ParametroQuery(
                TipoParametroEnum.STRING,
                entidade.getNome(),
                1
            ),
            new ParametroQuery(
                TipoParametroEnum.STRING,
                entidade.getDetalhe(),
                2
            ),
            new ParametroQuery(
                TipoParametroEnum.DATE,
                entidade.getDataNascimento(),
                3
            ),
            new ParametroQuery(
                TipoParametroEnum.ENUM,
                entidade.getSexo(),
                4
            ),
            new ParametroQuery(
                TipoParametroEnum.INTEGER,
                entidade.getEspecie().getId(),
                5
            ),
            new ParametroQuery(
                TipoParametroEnum.INTEGER,
                entidade.getCliente().getId(),
                6
            ),
            new ParametroQuery(
                TipoParametroEnum.INTEGER,
                entidade.getId(),
                7
            )
        );

        return persistir(AnimalSqlConstante.ATUALIZAR, parametros);
    }

    @Override
    public Optional<Animal> buscarPorId(Integer id) {
        var parametros = List.of(
            new ParametroQuery(
                TipoParametroEnum.INTEGER,
                id,
                1
            )
        );

        return consultar(AnimalSqlConstante.BUSCAR_POR_ID, parametros);
    }

    public Boolean existePorEspecieId(Integer especieId) {
        var parametros = List.of(
            new ParametroQuery(
                TipoParametroEnum.INTEGER,
                especieId,
                1
            )
        );

        return consultar(AnimalSqlConstante.BUSCAR_POR_ESPECIE_ID, parametros).isPresent();
    }

    public Boolean existePorClienteId(Integer clienteId) {
        var parametros = List.of(
            new ParametroQuery(
                TipoParametroEnum.INTEGER,
                clienteId,
                1
            )
        );

        return consultar(AnimalSqlConstante.BUSCAR_POR_CLIENTE_ID, parametros).isPresent();
    }

    @Override
    public Optional<Animal> buscarUltimo() {
        return consultar(AnimalSqlConstante.BUSCAR_ULTIMO);
    }

    @Override
    public List<Animal> buscarTodos() {
        return consultarList(AnimalSqlConstante.BUSCAR_TUDO);
    }

    @Override
    public void deletarTodos() {
        deletar(AnimalSqlConstante.DELETAR_TUDO);
    }

    @Override
    public void deletarPorId(Integer id) {
        var parametros = List.of(
            new ParametroQuery(
                TipoParametroEnum.INTEGER,
                id,
                1
            )
        );

        deletar(AnimalSqlConstante.DELETAR_POR_ID, parametros);
    }
}
