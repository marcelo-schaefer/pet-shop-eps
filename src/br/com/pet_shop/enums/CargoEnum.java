package br.com.pet_shop.enums;

public enum CargoEnum {
	ATENDENTE,
	
	MEDICO;
	
	public static CargoEnum pegarPorOpcao(Integer opcao) {
		if (opcao.equals(1)) {
			return CargoEnum.ATENDENTE;
		}
		
		return CargoEnum.MEDICO;
	}
}
