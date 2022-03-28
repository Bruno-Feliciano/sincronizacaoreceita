package sincronizacaoreceita;

public class SincronizacaoParametros {

	private SincronizacaoParametros() {
		throw new IllegalStateException("Instance of utility class: SincronizacaoParametros");
	}

	public static final String ERROR_MSG_FILE_NOT_INFORMED = "Arquivo não informado.";
	public static final String ERROR_MSG_INVALID_FILE = "Arquivo informado não é válido.";
	public static final String ERROR_MSG_FILE_NOT_FOUND = "Arquivo não encontrado.";
	public static final String ERROR_MSG_FILE_READ_FAIL = "Erro ao tentar fazer a leitura do arquivo.";
	public static final String ERROR_MSG_FILE_INVALID_HEADER = "Estrutura de Header do arquivo não está em formato válido.";

	public static final String FILE_TYPE = ".csv";

	public static final String FILE_DELIMITER = ";";

	public static final String FILE_INPUT_HEADER_BRANCH = "agencia";
	public static final String FILE_INPUT_HEADER_ACCOUNT = "conta";
	public static final String FILE_INPUT_HEADER_BALANCE = "saldo";
	public static final String FILE_INPUT_HEADER_STATUS = "status";

	public static final String FILE_OUTPUT_HEADER_RESULT = "resultado";

	public static final String FILE_OUTPUT_NAME_SUFIX = "_Resultado_";
	public static final String FILE_OUTPUT_DATE_PATTERN = "ddMMyyyyHHmmSS";

}
