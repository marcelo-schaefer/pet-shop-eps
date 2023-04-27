package br.com.pet_shop.utilitarios.constantes.sql;

public final class ConsultaSqlConstante {

    public static final String CRIAR = "insert into pet_shop.consulta "
        + "(nome, observacao, horario, valor, animal_id) "
        + "values "
        + "(?, ?, ?, ?, ?);";

    public static final String ATUALIZAR = "update pet_shop.consulta "
        + "set "
        + "nome = ?, "
        + "observacao = ?, "
        + "horario = ?, "
        + "animal_id = ? "
        + "where "
        + "id = ?;";

    public static final String BUSCAR_TODOS = "select * from pet_shop.consulta;";

    public static final String BUSCAR_POR_ID = "select "
        + "* "
        + "from "
        + "pet_shop.consulta consulta "
        + "where "
        + "consulta.id = ?";

    public static final String DELETAR_TODOS = "delete from pet_shop.consulta;";

    public static final String DELETAR_POR_ID = "delete from pet_shop.consulta "
        + "where "
        + "id = ?;";

    private ConsultaSqlConstante() {
    }
}
