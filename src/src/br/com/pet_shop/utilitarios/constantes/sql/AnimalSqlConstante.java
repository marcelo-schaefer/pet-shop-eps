package br.com.pet_shop.utilitarios.constantes.sql;

public final class AnimalSqlConstante {

    public static final String CRIAR = "insert into pet_shop.animal "
        + "(nome, detalhe, data_nascimento, sexo, ativo, cliente_id) "
        + "values "
        + "(?, ?, ?, ?, ?, ?);";

    public static final String ATUALIZAR = "update pet_shop.animal "
        + "set "
        + "nome = ?, "
        + "detalhe = ?, "
        + "data_nascimento = ?, "
        + "sexo = ?, "
        + "ativo = ?, "
        + "cliente_id = ? "
        + "where "
        + "id = ?;";

    public static final String INATIVAR = "update pet_shop.animal "
        + "set "
        + "ativo = false "
        + "where "
        + "id = ?;";

    public static final String BUSCAR_TODOS = "select * from pet_shop.animal;";

    public static final String BUSCAR_POR_ID = "select " +
        "* " +
        "from " +
        "pet_shop.animal animal" +
        "where " +
        "animal.id = ?;";

    public static final String DELETAR_TODOS = "delete from pet_shop.animal;";

    public static final String DELETAR_POR_ID = "delete from pet_shop.animal " +
        "where " +
        "animal.id = ?;";

    private AnimalSqlConstante() {
    }
}