package br.com.pet_shop.enums;

import java.util.Map;

public enum SexoEnum {

    FEMININO,

    MASCULINO,

    HERMAFRODITA;

    public static final Map<Integer, SexoEnum> SEXO_POSICAO_MAP = Map.of(
        1, SexoEnum.FEMININO,
        2, SexoEnum.MASCULINO,
        3, SexoEnum.HERMAFRODITA
    );
}
