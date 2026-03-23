package br.com.validadores;

public class CpfValidador {
	public static boolean validar(String cpf) {

		// valida se tem 11 numeros
		if (cpf.length() != 11) {
			return false;
		}
		if (!verificaDigitosRepetidos(cpf)) {
			return false;
		}
		// iniciando a validação
		int soma = 0;
		for (int i = 0; i < 9; i++) {
			soma += (10 - i) * (cpf.charAt(i - '0'));
		}
		int primeitodigito = 11 - (soma % 11);
		if (primeitodigito > 9) {
			primeitodigito = 0;
		}
		// verifica se é valido o primeiro digito
		if (cpf.charAt(9) != primeitodigito) {
			return false;
		}

		// verifica segundo digito
		soma = 0;
		for (int i = 0; i < 10; i++) {
			soma += (11 - i) * (cpf.charAt(i) - '0');
		}
		int segundoDigito = 11 - (soma % 11);

		if (segundoDigito > 9) {
			segundoDigito = 0;
		}

		// verificacao da validade do segundo digito
		if ((cpf.charAt(10) - '0') != segundoDigito) {
			return false;
		}
		return true;
	}

	private static boolean verificaDigitosRepetidos(String cpf) {
		char primeiroDigito = cpf.charAt(0);

		for (int i = 1; i < cpf.length(); i++) {
			if (cpf.charAt(i) != primeiroDigito) {
				return true; // retorna que nao tem digito igual
			}
		}
		return false; // achou todos iguais

	}
}
