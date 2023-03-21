package br.com.pet_shop.tela;

import br.com.pet_shop.utilitarios.constantes.TelaConstant;

public final class ExibirTela {
		
	private ExibirTela() {
	}
	
	public static void print(Object object) {
		System.out.print(object);
	}
	
	public static void println(Object object) {
		System.out.println(object);
	}
	
	public static void quebrarLinha() {
		System.out.println();
	}
	
	public static void limparTela() {
		for (var i = 0; i <= 15; i++) {
			quebrarLinha();
		}
	}
	
	public static void linha() {
		println(TelaConstant.LINHA);
	}
}
