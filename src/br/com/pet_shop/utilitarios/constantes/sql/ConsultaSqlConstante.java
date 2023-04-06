package br.com.pet_shop.utilitarios.constantes.sql;

public final class ConsultaSqlConstante {

    public static final String CRIAR = "insert into br.com.pet_shop.consulta "
        + "(nome, observacao, horario, cliente_id) "
        + "values "
        + "(?, ?, ?, ?);";

    public static final String ATUALIZAR = "update br.com.pet_shop.consulta consulta "
        + "set "
        + "consulta.nome = ?, "
        + "consulta.observacao = ?, "
        + "consulta.horario = ?, "
        + "consulta.cliente_id = ? "
        + "where consulta.id = ?;";

    public static final String INATIVAR = "update br.com.pet_shop.consulta consulta "
        + "set "
        + "consulta.ativo = false "
        + "where consulta.id = ?;";

    public static final String BUSCAR = "select * from br.com.pet_shop.consulta;";

    public static final String BUSCAR_POR_ID = "select * from br.com.pet_shop.consulta where consulta.id = ?";

    public static final String DELETAR = "delete from br.com.pet_shop.consulta;";

    public static final String DELETAR_POR_ID = "delete from br.com.pet_shop.consulta consulta where consulta.id = ?;";

    private ConsultaSqlConstante() {
    }
}
