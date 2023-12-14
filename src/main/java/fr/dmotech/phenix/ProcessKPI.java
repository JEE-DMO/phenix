package fr.dmotech.phenix;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.dmotech.phenix.common.IntAddMethRef;
import fr.dmotech.phenix.common.Params;
import fr.dmotech.phenix.data.Transaction;
import fr.dmotech.phenix.io.FileReader;
import fr.dmotech.phenix.io.FileReaderImpl;
import fr.dmotech.phenix.kpi.KPIProcessor;
import fr.dmotech.phenix.kpi.KpiProcessorImpl;

/**
 * 
 */
public class ProcessKPI {
	private static final Logger logger = LoggerFactory.getLogger(ProcessKPI.class);
	private static FileReader fileReader = new FileReaderImpl();
	private static KPIProcessor KpiPrpcessor = new KpiProcessorImpl();

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Params params = initCheck(args);

		if (params == null) {
			logger.error("No conditions found for start job...");
			System.exit(-1);
		}

		logger.info("Start procissing...");

		// Top Vente : No need price files, just read the transactions file

		// 1- Load transaction
		try {
			Stream<Transaction> transactions = fileReader.loadTranscations(params.getInputDir());
			Map<Integer, Integer> top100VenteGlobal = KpiPrpcessor.ProcessTopVenteGlobal(transactions);

			// Map<String, Integer> top100VenteByStore =
			// KpiPrpcessor.ProcessTopVenteByStore(transactions);
			top100VenteGlobal.forEach((k, v) -> System.out.println("ID=" + k + "| nb_vente = " + v));

			logger.info("its ok");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Count transaction

	}

	/**
	 * 
	 * @param commandLineArgs
	 * @return
	 */
	private static Params initCheck(String[] commandLineArgs) {

		Params params = new Params();
		if (commandLineArgs.length != 0) {
			params.setInputDir(commandLineArgs[0]);
			params.setOutputDir(commandLineArgs[1]);
		} else {
			params.setInputDir("./data/");
			params.setOutputDir("./data/kpi");
		}
		return params;
	}
}
