package br.com.pet_shop.tela;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import br.com.pet_shop.enums.SexoEnum;

public final class LerTela {

	private static Scanner scanner = null;

	private LerTela() {
	}

	public static String lerString() {
		iniciarScanner();
		var value = scanner.next();
		fecharScanner();

		return value;
	}

	public static Double lerDouble() {
		iniciarScanner();
		var value = scanner.nextDouble();
		fecharScanner();

		return value;
	}

	public static Date lerData() throws Exception {
		var simpleDateForm = new SimpleDateFormat("dd/MM/yyyy");
		Date date;

		iniciarScanner();

		try {
			var input = lerString();
			date = simpleDateForm.parse(input);
		} catch (Exception exception) {
			throw new Exception("A data deve ser no formato dd/MM/aaaa");
		}

		fecharScanner();

		return date;
	}

	public static SexoEnum lerEnum() throws Exception {
		SexoEnum enumConvert;

		iniciarScanner();
		try {
			var input = lerString();

			enumConvert = SexoEnum.valueOf(input);
		} catch (Exception exception) {
			var opcoes = pegarOpcoesEnum(SexoEnum.values());

			var errorMessage = String.format("Opções válidas: %s", opcoes);

			throw new Exception(errorMessage);
		}
		fecharScanner();

		return enumConvert;
	}

	private static void iniciarScanner() {
		scanner = new Scanner(System.in);
	}

	private static void fecharScanner() {
		scanner.close();
	}
	
	private static <T extends Enum<T>> String pegarOpcoesEnum(Enum<T>[] enumeration) {
		var opcoes = "";

		for (var i = 0; i < SexoEnum.values().length; i++) {
			opcoes += SexoEnum.values()[i].toString().concat("\n");
		}
		
		return opcoes;
	}
}
