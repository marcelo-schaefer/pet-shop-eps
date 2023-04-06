package br.com.pet_shop.utilitarios.constantes.sql;

public final class AnimalSqlConstante {

    public static final String CRIAR = "insert into br.com.pet_shop.animal "
        + "(nome, data_nascimento, sexo, ativo) "
        + "values "
        + "(?, ?, ?, ?);";

    public static final String ATUALIZAR = "update br.com.pet_shop.animal animal "
        + "set "
        + "animal.nome = ?, "
        + "animal.data_nascimento = ?, "
        + "animal.sexo = ?, "
        + "animal.ativo = ?, "
        + "where animal.id = ?;";

    public static final String INATIVAR = "update br.com.pet_shop.animal animal "
        + "set "
        + "animal.ativo = false "
        + "where animal.id = ?;";

    public static final String DELETAR = "delete from br.com.pet_shop.animal;";

    public static final String DELETAR_POR_ID = "delete from br.com.pet_shop.animal animal where animal.id = ?;";

    public static final String BUSCAR = "select * from br.com.pet_shop.animal;";

    public static final String BUSCAR_POR_ID = "select * from br.com.pet_shop.animal where animal.id = ?;";

    private AnimalSqlConstante() {
    }
}
