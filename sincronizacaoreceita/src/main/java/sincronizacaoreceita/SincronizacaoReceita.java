package sincronizacaoreceita;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SincronizacaoReceita implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SincronizacaoReceita.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {		
		if(args.length == 0 || args[0] == null)
	    {
			System.out.println(SincronizacaoParametros.ERROR_MSG_FILE_NOT_INFORMED);
	    } else {
			String fileName = args[0];
			if (SincronizacaoUtil.fileNameValidation(fileName)) {
				readFile(fileName);	
			} else {
				System.out.println(SincronizacaoParametros.ERROR_MSG_INVALID_FILE);
			}
	    }
	}

	public void readFile(String fileName) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			BufferedWriter writer = new BufferedWriter(new FileWriter(
					SincronizacaoUtil.createOutputFileName(fileName), false));
			
			boolean header = false;
			String line;
		    while ((line = reader.readLine()) != null) {
		        String[] values = line.split(SincronizacaoParametros.FILE_DELIMITER);
		        boolean result = readLine(values);
		        
		        if (!header) {
		        	if (SincronizacaoUtil.headerFileValidation(line)) {
		        		writer.write(SincronizacaoUtil.createOutputHeader(line));
		        		header = true;
		        	} else {
		        		System.out.println(SincronizacaoParametros.ERROR_MSG_FILE_INVALID_HEADER);
		        		break;
		        	}
		        } else {
		        	writer.newLine();
		        	writer.write(SincronizacaoUtil.createOutputBody(line, result));
		        }
		    }

		    reader.close();

		    writer.flush();
		    writer.close();
		} catch (FileNotFoundException e) {
			System.out.println(SincronizacaoParametros.ERROR_MSG_FILE_NOT_FOUND);
		} catch (Exception e) {
			System.out.println(SincronizacaoParametros.ERROR_MSG_FILE_READ_FAIL);
		}
	}
	
	public boolean readLine(String[] values) {
        boolean result = false;

        try {
    		String branch = values[0];
    		String account = values[1];
    		double balance = SincronizacaoUtil.convertStringBalanceToDouble(values[2]);
    		String status = values[3];
    		
            ReceitaService receitaService = new ReceitaService();
            result = receitaService.atualizarConta(branch, account, balance, status);
		} catch (Exception e) {
			result = false;
		}

        return result;
	}
}
