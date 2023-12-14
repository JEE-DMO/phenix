package fr.dmotech.phenix.kpi;

import java.util.Map;
import java.util.stream.Stream;

import fr.dmotech.phenix.data.Transaction;

/**
 * 	Run TOP_VENTE
	-------------
		- top_100_ventes_<ID_MAGASIN>_YYYYMMDD.data
		- top_100_ventes_GLOBAL_YYYYMMDD.data

		- top_100_ventes_<ID_MAGASIN>_YYYYMMDD-J7.data
		- top_100_ventes_GLOBAL_YYYYMMDD-J7.data

	Run TOP_CA
	----------
	  	- top_100_ca_<ID_MAGASIN>_YYYYMMDD.data
		- top_100_ca_GLOBAL_YYYYMMDD.data

		- top_100_ca_<ID_MAGASIN>_YYYYMMDD-J7.data
		- top_100_ca_GLOBAL_YYYYMMDD-J7.data
 */

public interface KPIProcessor {
	
	public  Map<Integer, Integer> ProcessTopVenteGlobal(Stream<Transaction> transactions) ;
	public  Map<String, Integer> ProcessTopVenteByStore(Stream<Transaction> transactions) ;

}
