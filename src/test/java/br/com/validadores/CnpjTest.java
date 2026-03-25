package br.com.validadores;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CnpjTest {
	@Test
	public void deveRetornarValidoQuandoDigitadoAlfanumericoOk() {
	// arrange
	String cnpj = "S16YKRRL000181";

	CnpjValidador validador = new CnpjValidador();
	// ACT
	boolean saida = validador.validar(cnpj);

	// assets
	assertTrue(saida);
	}
	@Test
	public void deveRetornarValidoQuandoDigitadoNumericoOk() {
		//arrange
		String cnpj = "42208237000102";
		
		CnpjValidador validador = new CnpjValidador();
		//ACT
		boolean saida = validador.validar(cnpj);

		//assets
		assertTrue(saida);
	}
	@Test
	public void deveRetornarValidoQuandoDigitadoVazio() {
		//arrange
		String cnpj = "";
		
		CnpjValidador validador = new CnpjValidador();
		//ACT
		boolean saida = validador.validar(cnpj);

		//assets
		assertFalse(saida);
	}
	//cenario nao feliz
	@Test
	public void deveRetornarValidoQuandoDigitadoAlfanumericoMenor() {
	// arrange
	String cnpj = "S16YKRRL0001";

	CnpjValidador validador = new CnpjValidador();
	// ACT
	boolean saida = validador.validar(cnpj);

	// assets
	assertFalse(saida);
	}
	
	@Test
	public void deveRetornarValidoQuandoDigitadoNumericoMenor() {
	// arrange
	String cnpj = "422082370001";

	CnpjValidador validador = new CnpjValidador();
	// ACT
	boolean saida = validador.validar(cnpj);

	// assets
	assertFalse(saida);
	}
	@Test
	public void deveRetornarValidoQuandoDigitadoAlfanumericoInvalido() {
	// arrange
	String cnpj = "S16YKRWL000181";

	CnpjValidador validador = new CnpjValidador();
	// ACT
	boolean saida = validador.validar(cnpj);

	// assets
	assertFalse(saida);
	}
	public void deveRetornarValidoQuandoDigitadoNumericoInvalido() {
		// arrange
		String cnpj = "5590149600166";

		CnpjValidador validador = new CnpjValidador();
		// ACT
		boolean saida = validador.validar(cnpj);

		// assets
		assertFalse(saida);
		}
	@Test
	public void deveRetornarValidoQuandoDigitadoAlfanumericoNaoRecomendado() {
	// arrange
	String cnpj = "P0H8723V000I52";

	CnpjValidador validador = new CnpjValidador();
	// ACT
	boolean saida = validador.validar(cnpj);

	// assets
	assertFalse(saida);
	}
	public void deveRetornarValidoQuandoDigitadoAlfanumericoRepetido() {
		// arrange
		String cnpj = "PPPPPPPPPPPPPP";

		CnpjValidador validador = new CnpjValidador();
		// ACT
		boolean saida = validador.validar(cnpj);

		// assets
		assertFalse(saida);
		}
}
