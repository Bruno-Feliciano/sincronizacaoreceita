package sincronizacaoreceita;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SincronizacaoUtilTests {

	@Test
	void fileNameValidation_Sucess() {
		boolean result = SincronizacaoUtil.fileNameValidation("teste.csv");
		assertTrue(result);

		result = SincronizacaoUtil.fileNameValidation("teste1.csv");
		assertTrue(result);

		result = SincronizacaoUtil.fileNameValidation("abc.edf.csv");
		assertTrue(result);
	}

	@Test
	void fileNameValidation_Fail() {
		boolean result = SincronizacaoUtil.fileNameValidation(null);
		assertFalse(result);

		result = SincronizacaoUtil.fileNameValidation("teste.cs");
		assertFalse(result);

		result = SincronizacaoUtil.fileNameValidation("teste.doc");
		assertFalse(result);
	}

	@Test
	void headerFileValidation_Sucess() {
		boolean result = SincronizacaoUtil.headerFileValidation("agencia;conta;saldo;status");
		assertTrue(result);
	}

	@Test
	void headerFileValidation_Fail() {
		boolean result = SincronizacaoUtil.headerFileValidation(null);
		assertFalse(result);

		result = SincronizacaoUtil.headerFileValidation("agencia;saldo;status");
		assertFalse(result);

		result = SincronizacaoUtil.headerFileValidation("agencia;conta;saldo;");
		assertFalse(result);
	}
	
	@Test
	void createOutputFileName_Equals() {
		String result = SincronizacaoUtil.createOutputFileName("teste.csv");
		assertNotEquals("teste.csv", result);
	}
	
	@Test
	void createOutputHeader_Equals() {
		String result = SincronizacaoUtil.createOutputHeader("agencia;conta;saldo;status");
		assertEquals("agencia;conta;saldo;status;resultado", result);
	}
	
	@Test
	void createOutputBody_Equals() {
		String result = SincronizacaoUtil.createOutputBody("0101;12225-6;100,00;A", true);
		assertEquals("0101;12225-6;100,00;A;true", result);

		result = SincronizacaoUtil.createOutputBody("0101;12225-6;100,00;A", false);
		assertEquals("0101;12225-6;100,00;A;false", result);
	}

	@Test
	void convertStringBalanceToDouble_Sucess() throws ParseException {
		double result = SincronizacaoUtil.convertStringBalanceToDouble("100,00");
		assertEquals(100.00d, result);

		result = SincronizacaoUtil.convertStringBalanceToDouble("123,2");
		assertEquals(123.2d, result);

		result = SincronizacaoUtil.convertStringBalanceToDouble("867");
		assertEquals(867d, result);
	}

	@Test
	void convertStringBalanceToDouble_Fail() {
		Assertions.assertThrows(ParseException.class, () -> SincronizacaoUtil.convertStringBalanceToDouble("teste"));
	}
}
