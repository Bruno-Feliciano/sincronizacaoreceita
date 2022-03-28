package sincronizacaoreceita;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SincronizacaoUtil {
	
	private SincronizacaoUtil() {
		throw new IllegalStateException("Instance of utility class: SincronizacaoUtil");
	}

	public static boolean fileNameValidation(String fileName) {
		return (fileName != null && !fileName.isEmpty() 
				&& fileName.contains(SincronizacaoParametros.FILE_TYPE));
	}

	public static boolean headerFileValidation(String line) {
		return (line != null && !line.isEmpty() 
				&& line.contains(SincronizacaoParametros.FILE_INPUT_HEADER_BRANCH)
				&& line.contains(SincronizacaoParametros.FILE_INPUT_HEADER_ACCOUNT)
				&& line.contains(SincronizacaoParametros.FILE_INPUT_HEADER_BALANCE)
				&& line.contains(SincronizacaoParametros.FILE_INPUT_HEADER_STATUS));
	}

	public static String createOutputFileName(String inputFileName) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				SincronizacaoParametros.FILE_OUTPUT_DATE_PATTERN);
		String date = simpleDateFormat.format(new Date());

		String outputFileName = inputFileName.replace(SincronizacaoParametros.FILE_TYPE, 
				SincronizacaoParametros.FILE_OUTPUT_NAME_SUFIX 
				+ date + SincronizacaoParametros.FILE_TYPE);

		return outputFileName;
	}
	
	public static String createOutputHeader(String line) {
		return line + SincronizacaoParametros.FILE_DELIMITER + SincronizacaoParametros.FILE_OUTPUT_HEADER_RESULT;
	}

	public static String createOutputBody(String line, boolean result) {
		return line + SincronizacaoParametros.FILE_DELIMITER + result;
	}

	public static double convertStringBalanceToDouble(String value) throws ParseException{
		NumberFormat format = NumberFormat.getNumberInstance();
		double number = format.parse(value).doubleValue();
		return number;
	}
}
