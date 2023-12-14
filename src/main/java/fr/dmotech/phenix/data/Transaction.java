package fr.dmotech.phenix.data;

import static fr.dmotech.phenix.common.Constants.DATETIME_FIELD_POS_1;
import static fr.dmotech.phenix.common.Constants.FILD_SEPARATOR;
import static fr.dmotech.phenix.common.Constants.MAGASIN_FIELD_POS_2;
import static fr.dmotech.phenix.common.Constants.PRODUIT_FIELD_POS_3;
import static fr.dmotech.phenix.common.Constants.QTE_FIELD_POS_4;
import static fr.dmotech.phenix.common.Constants.TXID_FIELD_POS_0;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
	private Integer txId;
	private LocalDateTime txDateTime;
	private String magasin; // UUID identifiant le magasin
	private Integer produit; // id du produit (nombre)
	private Integer qte; // quantité (nombre)

	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmssZ");

	public Transaction(String txId, String txDateTime,String magasin, String produit,  String qty) {
		this.txId = Integer.parseInt(txId);
		this.txDateTime = LocalDateTime.parse(txDateTime, formatter);
		this.magasin = magasin;
		this.produit = Integer.parseInt(produit);
		this.qte = Integer.parseInt(qty);

	}

	/**
	 * 
	 * @param psvLine
	 * @return
	 */
	public static Transaction buildTx(String psvLine) {
		//
		String[] fields = psvLine.split(FILD_SEPARATOR);

		return new Transaction(fields[TXID_FIELD_POS_0], 
				fields[DATETIME_FIELD_POS_1],
				fields[MAGASIN_FIELD_POS_2], 
				fields[PRODUIT_FIELD_POS_3],
				fields[QTE_FIELD_POS_4]);
	}

	public Integer getTxId() {
		return txId;
	}

	public void setTxId(Integer txId) {
		this.txId = txId;
	}

	public LocalDateTime getTxDateTime() {
		return txDateTime;
	}

	public void setTxDateTime(LocalDateTime txDateTime) {
		this.txDateTime = txDateTime;
	}

	public String getMagasin() {
		return magasin;
	}

	public void setMagasin(String magasin) {
		this.magasin = magasin;
	}

	public Integer getProduit() {
		return produit;
	}

	public void setProduit(Integer produit) {
		this.produit = produit;
	}

	public Integer getQte() {
		return qte;
	}

	public void setQte(Integer qte) {
		this.qte = qte;
	}

	@Override
	public String toString() {
		return "Transaction [txId=" + txId + ", txDateTime=" + txDateTime + ", magasin=" + magasin + ", produit="
				+ produit + ", qte=" + qte + ", formatter=" + formatter + "]";
	}



}
