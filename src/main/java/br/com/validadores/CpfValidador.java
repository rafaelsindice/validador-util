package br.com.validadores;

public class CpfValidador extends ValidadorDigitoVerificadorAbstract {
	@Override
	public boolean validar(String cpf) {

		// valida se tem 11 numeros
		if (!validaQuantidadeCaracteresCpf(cpf)) {
			return false;
		}
		if (!verificaDigitosRepetidosCpf(cpf)) {
			return false;
		}
		if (calculaPrimeirodigitoCpf(cpf)) {
			if (!calculaSegundoDigitoCpf(cpf)) {
				return false;
			}

		}
		return true;
	}

}
