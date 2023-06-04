package br.com.pet_shop.banco.sql;

public final class AnimalSqlConstante {

    public static final String CRIAR = "insert into pet_shop.animal "
        + "(nome, detalhe, data_nascimento, sexo, ativo, especie_id, cliente_id) "
        + "values "
        + "(?, ?, ?, ?, ?, ?, ?);";

    public static final String ATUALIZAR = "update pet_shop.animal "
        + "set "
        + "nome = ?, "
        + "detalhe = ?, "
        + "data_nascimento = ?, "
        + "sexo = ?, "
        + "ativo = ?, "
        + "especie_id = ? "
        + "cliente_id = ? "
        + "where "
        + "id = ?;";

    public static final String INATIVAR = "update pet_shop.animal "
        + "set "
        + "ativo = false "
        + "where "
        + "id = ?;";

    public static final String BUSCAR_TUDO = "select * from pet_shop.animal;";

    public static final String BUSCAR_POR_ID = "select " +
        "* " +
        "from " +
        "pet_shop.animal animal " +
        "where " +
        "animal.id = ?;";

    public static final String BUSCAR_ULTIMO = "select " +
        "* " +
        "from " +
        "pet_shop.animal animal " +
        "order by " +
        "animal.id desc " +
        "limit 1;";
    
    public static final String DELETAR_TUDO = "delete from pet_shop.animal;";

    public static final String DELETAR_POR_ID = "delete from pet_shop.animal " +
        "where " +
        "animal.id = ?;";

    private AnimalSqlConstante() {
    }
}
