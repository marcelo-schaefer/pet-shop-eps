package br.com.pet_shop.utilitarios.dto;

import br.com.pet_shop.enums.TipoParametroEnum;

public class ParametroQuery {

    private TipoParametroEnum tipo;

    private Object valor;

    private Integer posicao;

    public ParametroQuery(TipoParametroEnum tipo, Object valor, Integer posicao) {
        this.tipo = tipo;
        this.valor = valor;
        this.posicao = posicao;
    }

    public TipoParametroEnum getTipo() {
        return tipo;
    }

    public Object getValor() {
        return valor;
    }

    public Integer getPosicao() {
        return posicao;
    }
}
