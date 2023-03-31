package br.com.pet_shop.utilitarios.constantes;

public final class FuncionarioSqlConstante {

    public static final String CRIAR = "insert into biblioteca.funcionario "
        + "(nome, cpf, data_nascimento, cargo, ativo) "
        + "values "
        + "(?, ?, ?, ?, ?, ?);";

    public static final String ATUALIZAR = "update biblioteca.funcionario funcionario "
        + "set "
        + "funcionario.nome = ?, "
        + "funcionario.cpf = ?, "
        + "funcionario.data_nascimento = ?, "
        + "funcionario.cargo = ?, "
        + "funcionario.ativo = ? "
        + "where funcionario.id = ?;";

    public static final String INATIVAR = "update biblioteca.funcionario funcionario "
        + "set "
        + "funcionario.ativo = false "
        + "where funcionario.id = ?;";

    public static final String BUSCAR = "select * from biblioteca.funcionario;";

    public static final String BUSCAR_POR_ID = "select * from biblioteca.funcionario where funcionario.id = ?";

    public static final String DELETAR = "delete from biblioteca.funcionario;";

    public static final String DELETAR_POR_ID = "delete from biblioteca.funcionario funcionario where funcionario.id = ?;";

    private FuncionarioSqlConstante() {
    }
}
