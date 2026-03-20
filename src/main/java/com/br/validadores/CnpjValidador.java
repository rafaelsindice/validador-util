package com.br.validadores;

public class CnpjValidador {
	public static boolean validar(String cnpj) {
		cnpj.replaceAll("^A-za-z0-9", "");
		// valida se tem 14 digitos
		if (cnpj.length() != 14) {
			return false;
		}
		if (!verificaDigitosRepetidos(cnpj)) {
			return false;
		}
		int soma = 0;
		int peso = 2;

		for (int i = 11; i >= 0; i--) {
			int valorConvertido = converteCaractere(cnpj.charAt(i));
			soma += valorConvertido * peso;
			peso++;
			if (peso == 10) {
				peso = 2;
			}
		}
		int primeiroDigito = 11 - (soma % 11);
		
		if(primeiroDigito > 9) {
			primeiroDigito = 0;
		}
		//verifica o primeiro digito verificador
		if((cnpj.charAt(12) - '0')!= primeiroDigito) {
			return false;
		}
		
		//calculo do segundo digito
		soma = 0;
		peso = 2;
		
		for(int i = 12;i  >= 0 ; i --) {
			int valorConvertido = converteCaractere(cnpj.charAt(i));
			soma += valorConvertido * peso;
			peso++;
			
			if (peso == 10) {
				peso = 2;
			}
		}
		
		int segundoDigito = 11 - (soma % 11);
		if ((cnpj.charAt(13))- '0' != segundoDigito) {
			return false;
		}
		return true;
	}
	private static boolean verificaDigitosRepetidos(String cnpj) {
		char primeiroDigito = cnpj.charAt(0);
		for (int i = 1; i < cnpj.length(); i++) {
			if (cnpj.charAt(i)!= primeiroDigito) {
				return true; // tem diferente
			}
		}
		return false; // todos iguais
	} 
	private static int converteCaractere(char c) {
		try {
			if (Character.isDigit(c)) {
				return c - '0';
			}
			if (Character.isUpperCase(c)) {
				return c - 48;
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException("Caractere invalido no CNPJ informado" +  c);
		}
		return c;
	}
	
	
}
