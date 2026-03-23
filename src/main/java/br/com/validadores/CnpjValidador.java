package br.com.validadores;

public class CnpjValidador extends ValidadorDigitoVerificadorAbstract {
	@Override
	public boolean validar(String cnpj) {

		cnpj = normatizadorCnpj(cnpj);

		if (isNullOrEmpty(cnpj)) {
			return false;
		}

		if (validaQuantidadeCaracteresCnpj(cnpj)) {
			return false;
		}

		if (!verificaDigitosRepetidos(cnpj)) {
			return false;
		}

		if (calculaPrimeiroDigitoCnpj(cnpj)) {
			if (calculaSegundoDigitoCnpj(cnpj)) {
				return true;
			}
		}

		return true;
	}

}
