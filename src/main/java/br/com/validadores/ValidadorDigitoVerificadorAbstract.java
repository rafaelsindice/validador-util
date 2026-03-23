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
			return false;
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

}
