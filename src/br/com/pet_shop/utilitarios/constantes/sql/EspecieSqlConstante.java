package br.com.pet_shop.utilitarios.constantes.sql;

public final class EspecieSqlConstante {

    public static final String CRIAR = "insert into br.com.pet_shop.especie "
        + "(id, nome) "
        + "values "
        + "(?, ?);";

    public static final String ATUALIZAR = "update br.com.pet_shop.especie especie "
        + "set "
        + "especie.id = ?, "
        + "especie.nome = ? "
        + "where especie.id = ?;";

    public static final String DELETAR = "delete from br.com.pet_shop.especie;";

    public static final String DELETAR_POR_ID = "delete from br.com.pet_shop.especie especie where especie.id = ?;";

    public static final String BUSCAR = "select * from br.com.pet_shop.especie;";

    public static final String BUSCAR_POR_ID = "select * from br.com.pet_shop.especie where especie.id = ?;";

    private EspecieSqlConstante() {
    }
}
