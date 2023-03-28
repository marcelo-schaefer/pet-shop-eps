package br.com.pet_shop.enums;

public enum EspecieEnum {
	CACHORRO,
	GATO,
	COBRA,
	PAPAGAIO;
	
	public static EspecieEnum pegarPorOpcao(Integer posicao) {
		switch (posicao) {
			case 1:
				return EspecieEnum.CACHORRO;
			case 2:
				return EspecieEnum.GATO;
			case 3:
				return EspecieEnum.COBRA;
			default:
				return EspecieEnum.PAPAGAIO;
		}
	}
}
