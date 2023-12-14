package fr.dmotech.phenix.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import fr.dmotech.phenix.common.Constants;
import fr.dmotech.phenix.data.Transaction;

public class FileReaderImpl implements FileReader {

	@Override
	public Stream<Transaction> loadTranscations(String path) throws IOException {

		return Files.list(Paths.get(path))
				.filter(filePath -> isTransactionFile(filePath))
				.flatMap(filePath -> readPsvLines(filePath))
				.map(psvLine -> Transaction.buildTx(psvLine));
		
	}

	private Stream<? extends String> readPsvLines(Path filePath) {
		try {
			return Files.lines(filePath);
		} catch (IOException e) {
			System.err.println("An error occurred while reading file: " + filePath);
			return Stream.empty();
		}
	}

	/**
	 * Return true if file start with "transactions_" prefix
	 * 
	 * @param filePath
	 * @return
	 */
	private boolean isTransactionFile(Path filePath) {
		return filePath.getFileName().toString().startsWith(Constants.TX_FILE_PREFIX);
	}

}
