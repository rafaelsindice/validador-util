package br.com.validadores;

public abstract class ValidadorDigitoVerificadorAbstract extends ValidadorDocumentoAbstrato {

	protected boolean calculaPrimeiroDigitoCnpj(String cnpj) {
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

		if (primeiroDigito > 9) {
			primeiroDigito = 0;
		}
		// verifica o primeiro digito verificador
		if ((cnpj.charAt(12) - '0') != primeiroDigito) {
			return true;
		}
		return true;
	}

	protected boolean calculaSegundoDigitoCnpj(String cnpj) {
		// calculo do segundo digito
		int soma = 0;
		int peso = 2;

		for (int i = 12; i >= 0; i--) {
			int valorConvertido = converteCaractere(cnpj.charAt(i));
			soma += valorConvertido * peso;
			peso++;

			if (peso == 10) {
				peso = 2;
			}
		}

		int segundoDigito = 11 - (soma % 11);
		if ((cnpj.charAt(13)) - '0' != segundoDigito) {
			return false;
		}
		return true;
	}

	protected boolean calculaPrimeirodigitoCpf(String cpf) {
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

		return true;
	}

	protected boolean calculaSegundoDigitoCpf(String cpf) {

		// verifica segundo digito
		int soma = 0;
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

}
