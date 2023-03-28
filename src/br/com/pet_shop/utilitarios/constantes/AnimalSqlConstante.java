package br.com.pet_shop.utilitarios.constantes;

public final class AnimalSqlConstante {

    public static final String BUSCAR_POR_ID = "SELECT * FROM biblioteca.acervo "
            + "WHERE acervo.id = ?";

    public static final String CRIAR = "INSERT INTO biblioteca.cliente "
            + "(nome_completo, data_nascimento, cpf, telefone, ativo, foto) "
            + "VALUES "
            + "(?, ?, ?, ?, ?, ?);";

    public static final String ATUALIZAR = "UPDATE biblioteca.cliente cliente "
            + "SET "
            + "cliente.nome_completo = ?,"
            + "cliente.data_nascimento = ?,"
            + "cliente.cpf = ?,"
            + "cliente.telefone = ?,"
            + "cliente.ativo = ?,"
            + "cliente.foto = ? "
            + "WHERE cliente.id = ?;";

    public static final String INATIVAR = "UPDATE biblioteca.cliente cliente "
            + "SET "
            + "cliente.ativo = false "
            + "WHERE cliente.id = ?;";

    public static final String BUSCAR = "SELECT * FROM biblioteca.cliente;";

    public static final String DELETAR = "DELETE FROM biblioteca.cliente;";

    public static final String DELETAR_POR_ID = "DELETE FROM biblioteca.cliente cliente "
            + "WHERE cliente.id = ?;";

    private AnimalSqlConstante(){}
}
