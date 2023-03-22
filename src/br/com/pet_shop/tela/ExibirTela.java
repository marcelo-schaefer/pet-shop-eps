package br.com.pet_shop.tela;

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
}
