package br.com.pet_shop.banco.sql;

public final class ConsultaSqlConstante {

    public static final String CRIAR = "insert into pet_shop.consulta "
        + "(nome, observacao, horario, valor, animal_id, funcionario_id) "
        + "values "
        + "(?, ?, ?, ?, ?, ?);";

    public static final String ATUALIZAR = "update pet_shop.consulta "
        + "set "
        + "nome = ?, "
        + "observacao = ?, "
        + "horario = ?, "
        + "valor = ?, "
        + "animal_id = ?, "
        + "funcionario_id = ? "
        + "where "
        + "id = ?;";

    public static final String BUSCAR_TUDO = "select * from pet_shop.consulta;";

    public static final String BUSCAR_POR_ID = "select "
        + "* "
        + "from "
        + "pet_shop.consulta consulta "
        + "where "
        + "consulta.id = ?";

    public static final String BUSCAR_POR_ANIMAL_ID = "select "
        + "* "
        + "from "
        + "pet_shop.consulta consulta "
        + "where "
        + "consulta.animal_id = ?";

    public static final String BUSCAR_POR_FUNCIONARIO_ID = "select "
        + "* "
        + "from "
        + "pet_shop.consulta consulta "
        + "where "
        + "consulta.funcionario_id = ?";

    public static final String BUSCAR_ULTIMO = "select " +
        "* " +
        "from " +
        "pet_shop.consulta consulta " +
        "order by " +
        "consulta.id desc " +
        "limit 1;";

    public static final String DELETAR_TUDO = "delete from pet_shop.consulta;";

    public static final String DELETAR_POR_ID = "delete from pet_shop.consulta "
        + "where "
        + "id = ?;";

    private ConsultaSqlConstante() {
    }
}
