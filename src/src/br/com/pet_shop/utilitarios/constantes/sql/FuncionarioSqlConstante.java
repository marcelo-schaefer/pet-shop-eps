package br.com.pet_shop.utilitarios.constantes.sql;

public final class FuncionarioSqlConstante {

    public static final String CRIAR = "insert into pet_shop.funcionario "
        + "(nome, cpf, data_nascimento, cargo) "
        + "values "
        + "(?, ?, ?, ?);";

    public static final String ATUALIZAR = "update pet_shop.funcionario "
        + "set "
        + "nome = ?, "
        + "cpf = ?, "
        + "data_nascimento = ?, "
        + "cargo = ? "
        + "where id = ?;";

    public static final String BUSCAR_TODOS = "select * from pet_shop.funcionario;";

    public static final String BUSCAR_POR_ID = "select " +
        "* " +
        "from pet_shop.funcionario funcionario" +
        "where " +
        "funcionario.id = ?";

    public static final String DELETAR_TODOS = "delete from pet_shop.funcionario;";

    public static final String DELETAR_POR_ID = "delete from pet_shop.funcionario " +
        "where " +
        "id = ?;";

    private FuncionarioSqlConstante() {
    }
}
