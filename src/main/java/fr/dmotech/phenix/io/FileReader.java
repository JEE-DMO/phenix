package fr.dmotech.phenix.io;

import java.io.IOException;
import java.util.stream.Stream;

import fr.dmotech.phenix.data.Transaction;

public interface FileReader {
	
	
	Stream<Transaction> loadTranscations(String path) throws IOException;
	
	
	

}
