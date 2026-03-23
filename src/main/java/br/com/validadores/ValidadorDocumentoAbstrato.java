package br.com.validadores;

public abstract class ValidadorDocumentoAbstrato implements ValidadorDigitoVerificador {
	protected String normatizadorCnpj(String cnpj) {
		return cnpj.replaceAll("^A-za-z0-9", "");
	}

	// remove os carecteres invalidos como . e /
	protected String normatizadorCpf(String cpf) {
		return cpf = cpf.replaceAll("[^0-9]", "");
	}

	protected boolean isNullOrEmpty(String cnpj) {
		return cnpj == null || cnpj.trim().isEmpty();
	}

	protected boolean validaQuantidadeCaracteresCnpj(String cnpj) {
		// valida se tem 14 digitos
		if (cnpj.length() != 14) {
			return false;
		}
		return true;
	}

	protected static boolean verificaDigitosRepetidos(String cnpj) {
		char primeiroDigito = cnpj.charAt(0);
		for (int i = 1; i < cnpj.length(); i++) {
			if (cnpj.charAt(i) != primeiroDigito) {
				return true; // tem diferente
			}
		}
		return false; // todos iguais
	}

	protected static int converteCaractere(char c) {
		try {
			if (Character.isDigit(c)) {
				return c - '0';
			}
			if (Character.isUpperCase(c)) {
				return c - 48;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException("Caractere invalido no CNPJ informado" + c);
		}
		return c;
	}
}
