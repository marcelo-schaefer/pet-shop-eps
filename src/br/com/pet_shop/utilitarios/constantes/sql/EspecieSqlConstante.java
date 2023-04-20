package br.com.pet_shop.utilitarios.constantes.sql;

public final class EspecieSqlConstante {

    public static final String CRIAR = "insert into pet_shop.especie "
        + "(id, nome) "
        + "values "
        + "(?, ?);";

    public static final String ATUALIZAR = "update pet_shop.especie "
        + "set "
        + "nome = ? "
        + "where id = ?;";

    public static final String BUSCAR_TUDO = "select * from pet_shop.especie;";

    public static final String BUSCAR_POR_ID = "select " +
        "* " +
        "from " +
        "pet_shop.especie especie " +
        "where especie.id = ?;";

    public static final String DELETAR_TUDO = "delete from pet_shop.especie;";

    public static final String DELETAR_POR_ID = "delete from pet_shop.especie " +
        "where id = ?;";

    private EspecieSqlConstante() {
    }
}
