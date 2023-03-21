package br.com.pet_shop;

import br.com.pet_shop.enums.SexoEnum;

public class RunApp {
	
	public static void main(String[] args) {
		var enumNome = "";
		
		for (var i =0; i < SexoEnum.values().length; i++) {
			enumNome += SexoEnum.values()[i].toString().concat("\n");
		}
		
		var errorMessage = String.format(
				"Opções válidas: %s",
				enumNome
		);
		System.out.print(errorMessage);
	}
	
}
