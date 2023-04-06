package br.com.pet_shop.utilitarios.constantes.sql;

public final class ClienteSqlConstante {
    
    public static final String CRIAR = "insert into br.com.pet_shop.cliente "
        + "(nome, cpf, data_nascimento, ativo) "
        + "values "
        + "(?, ?, ?, ?);";

    public static final String ATUALIZAR = "update br.com.pet_shop.cliente cliente "
        + "set "
        + "cliente.nome = ?, "
        + "cliente.data_nascimento = ?, "
        + "cliente.cpf = ?, "
        + "cliente.telefone = ?, "
        + "cliente.ativo = ?, "
        + "cliente.foto = ? "
        + "where cliente.id = ?;";

    public static final String INATIVAR = "update br.com.pet_shop.cliente cliente "
        + "set "
        + "cliente.ativo = false "
        + "where cliente.id = ?;";

    public static final String BUSCAR = "select * from br.com.pet_shop.cliente;";

    public static final String BUSCAR_POR_ID = "select * from br.com.pet_shop.cliente where cliente.id = ?";
    
    public static final String DELETAR = "delete from br.com.pet_shop.cliente;";

    public static final String DELETAR_POR_ID = "delete from br.com.pet_shop.cliente cliente where cliente.id = ?;";

    private ClienteSqlConstante() {
    }
}
