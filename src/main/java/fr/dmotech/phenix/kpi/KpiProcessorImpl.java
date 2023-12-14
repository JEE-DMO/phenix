package fr.dmotech.phenix.kpi;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.dmotech.phenix.common.IntAddMethRef;
import fr.dmotech.phenix.data.Transaction;

public class KpiProcessorImpl implements KPIProcessor {

	public Map<Integer, Integer> ProcessTopVenteGlobal(Stream<Transaction> transactions) {
		Map<Integer, Integer> topVente = new LinkedHashMap<Integer, Integer>();

		transactions.forEach(tx -> topVente.merge(tx.getProduit(), tx.getQte(), IntAddMethRef::add));

		return topVente.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).limit(100)

				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	}

	public Map<String, Integer> ProcessTopVenteByStore(Stream<Transaction> transactions) {
		Map<String, Integer> topVente = new LinkedHashMap<String, Integer>();

		transactions.forEach(tx -> topVente.merge((tx.getMagasin() + tx.getProduit()), 1, IntAddMethRef::add));

		Map<String, Integer> sortedTopVente = topVente.entrySet().stream()
				.sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		Integer Value100 = getPosistionValue(sortedTopVente, 100);

		return sortedTopVente.entrySet().stream().filter(elt -> elt.getValue() >= Value100)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

	}

	private Integer getPosistionValue(Map<String, Integer> sortedTopVente, int position) {
		return sortedTopVente.entrySet().stream().skip(position - 1).map(Map.Entry::getValue).findFirst().get();
	}

}
