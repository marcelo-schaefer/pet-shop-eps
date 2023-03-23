package br.com.pet_shop.tela;

import javax.swing.JOptionPane;

import br.com.pet_shop.enums.CargoEnum;
import br.com.pet_shop.enums.EspecieEnum;
import br.com.pet_shop.enums.SexoEnum;

public final class LerTela {

    private LerTela() {
    }

    public static String lerString(String mensagem, String titulo) {
        return String.valueOf(
            optionInputPergunta(
                mensagem,
                titulo
            )
        );
    }

    public static Double lerDouble(String mensagem, String titulo) {
        boolean invalido = false;

        do {
            try {
                return Double.valueOf(
                    lerString(
                        mensagem,
                        titulo
                    )
                );
            } catch (Exception exception) {
                optionMensagemAlerta(
                    "Inválido",
                    "Valor informado é inválido, informe um valor numérico."
                );
                invalido = true;
            }
        } while (invalido);

        return null;
    }

    
    private static Integer lerInteger(String mensagem, String titulo) {
    	boolean invalido = false;

        do {
            try {
                return Integer.valueOf(
                    lerString(
                        mensagem,
                        titulo
                    )
                );
            } catch (Exception exception) {
                optionMensagemAlerta(
                    "Inválido",
                    "Valor informado é inválido, informe um valor numérico sem casas decimais."
                );
                invalido = true;
            }
        } while (invalido);

        return null;
    }
    
    public static Boolean lerBoolean(String titulo, String message) {
    	return optionConfirmPergunta(message, titulo) == 0;
    }
    
    public static CargoEnum lerCargoEnum(String titulo) {
        boolean invalido = false;
        
        var menssagem = "Selecione uma das opções: \n"
        		+ "1 - Médico"
        		+ "2 - Atendente";
        
        do {
            try {
            	var opcao = lerOpcao(
	    			1,
	    			CargoEnum.values().length,
	    			titulo,
	    			menssagem
				);
            	
                return CargoEnum.pegarPorOpcao(opcao);
            } catch (Exception exception) {
                optionMensagemAlerta(
                    "Inválido",
                    "Valor informado é inválido, informe um valor numérico."
                );
                invalido = true;
            }
        } while (invalido);

        return null;
    }
    
    public static SexoEnum lerSexoEnum(String titulo) {
        boolean invalido = false;
        
        var menssagem = "Selecione uma das opções:"
        		.concat("\n")
        		.concat("1 - Feminino")
        		.concat("\n")
        		.concat("2 - Masculino")
        		.concat("\n")
        		.concat("3 - Hemafrodita")
        ;
        
        do {
            try {
            	var opcao = lerOpcao(
        			1,
        			SexoEnum.values().length,
        			titulo,
        			menssagem
    			);
            	
                return SexoEnum.pegarPorOpcao(opcao);
            } catch (Exception exception) {
                optionMensagemAlerta(
                    "Inválido",
                    "Valor informado é inválido, informe um valor numérico."
                );
                invalido = true;
            }
        } while (invalido);

        return null;
    }
    
    public static EspecieEnum lerEspecieEnum(String titulo) {
        boolean invalido = false;
        
        var menssagem = "Selecione uma das opções:"
        		.concat("\n")
        		.concat("1 - Feminino")
        		.concat("\n")
        		.concat("2 - Masculino")
        		.concat("\n")
        		.concat("3 - Hemafrodita")
        ;
        
        do {
            try {
            	var opcao = lerOpcao(
	    			1,
	    			EspecieEnum.values().length,
	    			titulo,
	    			menssagem
				);
            	
                return EspecieEnum.pegarPorOpcao(opcao);
            } catch (Exception exception) {
                optionMensagemAlerta(
                    "Inválido",
                    "Valor informado é inválido, informe um valor numérico."
                );
                invalido = true;
            }
        } while (invalido);

        return null;
    }
    
    private static Integer lerOpcao(Integer de, Integer ate, String titulo, String menssagem) {
        boolean invalido = false;
    	
    	do {
            try {
            	var opcao = lerInteger(menssagem, titulo);
            	
            	if (opcao >= de && opcao <= ate) {
            		return opcao;
            	}
            	
                throw new RuntimeException("");
            } catch (Exception exception) {
                optionMensagemAlerta(
                    "Inválido",
                    "Opção inválida, informe uma opção entre "
                    	.concat(de.toString())
                    	.concat(" e ")
                    	.concat(ate.toString())
                );
                invalido = true;
            }
        } while (invalido);
    	
    	return null;
    }
    
    private static Object optionInputPergunta(String menssagem, String titulo) {
        return JOptionPane.showInputDialog(
            null,
            menssagem,
            titulo,
            JOptionPane.QUESTION_MESSAGE
        );
    }
    
    private static Integer optionConfirmPergunta(String menssagem, String titulo) {
        return JOptionPane.showConfirmDialog(
            null,
            menssagem,
            titulo,
            JOptionPane.QUESTION_MESSAGE
        );
    }

    private static void optionMensagemAlerta(String menssagem, String titulo) {
        JOptionPane.showMessageDialog(
            null,
            menssagem,
            titulo,
            JOptionPane.WARNING_MESSAGE
        );
    }
}
