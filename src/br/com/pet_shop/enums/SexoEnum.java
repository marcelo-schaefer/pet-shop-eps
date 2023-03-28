package br.com.pet_shop.enums;

public enum SexoEnum {

	FEMININO,

	MASCULINO,

	HEMAFRODITA;

	public static SexoEnum pegarPorOpcao(Integer posicao) {
		switch (posicao) {
		case 1:
			return SexoEnum.FEMININO;
		case 2:
			return SexoEnum.MASCULINO;
		default:
			return SexoEnum.HEMAFRODITA;
		}
	}
}
