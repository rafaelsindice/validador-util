package br.com.validadores;

public class CnpjValidador extends ValidadorDigitoVerificadorAbstract {
	@Override
	public boolean validar(String cnpj) {

		cnpj = normatizadorCnpj(cnpj);

		if (isNullOrEmpty(cnpj)) {
			System.out.println("nulo ou vazio");
			return false;
		}

		if (!validaQuantidadeCaracteresCnpj(cnpj)) {
			return false;
		}

		if (!verificaDigitosRepetidosCnpj(cnpj)) {
			return false;
		}

		if (calculaPrimeiroDigitoCnpj(cnpj)) {
			if (!calculaSegundoDigitoCnpj(cnpj)) {
				return false;
			}
		}

		return true;
	}

}
