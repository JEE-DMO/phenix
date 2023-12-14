package fr.dmotech.phenix.common;

public interface Constants {
	public static final String FILE_EXT = ".data";
	public static final String TX_FILE_PREFIX = "transactions_";
	public static final String REF_PRIX_FILE_PREFIX = "reference_prod-";
	public static final String FILD_SEPARATOR = "\\|";

	// Transaction Field Position

	public static final short TXID_FIELD_POS_0 = 0;
	public static final short DATETIME_FIELD_POS_1 = 1;
	public static final short MAGASIN_FIELD_POS_2 = 2;
	public static final short PRODUIT_FIELD_POS_3 = 3;
	public static final short QTE_FIELD_POS_4 = 4;
	public static final short PRIX_FIELD_POS_5 = 5;

	// KPI
	public static final String KPI_TOP_VENTE_PREFIX = "top_100_ventes_"; // top_100_ventes_GLOBAL_YYYYMMDD-J7.data
	public static final String KPI_TOP_CA_PREFIX = "top_100_ca_";
	public static final String KPI_GLOBAL_MARQUER = "GLOBAL_";
	public static final String KPI_7DAYS_MARQUER = "-J7";

}
