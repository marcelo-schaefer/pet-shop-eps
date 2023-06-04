package br.com.pet_shop.utilitarios.dto;

import br.com.pet_shop.enums.TipoParametroEnum;

public class ParametroQuery {

    private final TipoParametroEnum tipo;

    private final Object valor;

    private final Integer posicao;

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
