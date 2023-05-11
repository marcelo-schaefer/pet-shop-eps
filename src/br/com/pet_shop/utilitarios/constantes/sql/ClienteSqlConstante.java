package br.com.pet_shop.utilitarios.constantes.sql;

public final class ClienteSqlConstante {
    
    public static final String CRIAR = "insert into pet_shop.cliente "
        + "(nome, cpf, data_nascimento) "
        + "values "
        + "(?, ?, ?);";

    public static final String ATUALIZAR = "update pet_shop.cliente "
        + "set "
        + "nome = ?, "
        + "cpf = ?, "
        + "data_nascimento = ? "
        + "where id = ?;";

    public static final String BUSCAR_TUDO = "select * from pet_shop.cliente;";

    public static final String BUSCAR_POR_ID = "select " +
        "* " +
        "from pet_shop.cliente cliente" +
        "where " +
        "cliente.id = ?";

    public static final String BUSCAR_ULTIMO = "select " +
        "* " +
        "from " +
        "pet_shop.cliente cliente " +
        "order by " +
        "cliente.id desc " +
        "limit 1;";

    public static final String DELETAR_TUDO = "delete from pet_shop.cliente;";

    public static final String DELETAR_POR_ID = "delete from pet_shop.cliente " +
        "where " +
        "id = ?;";

    private ClienteSqlConstante() {
    }
}
