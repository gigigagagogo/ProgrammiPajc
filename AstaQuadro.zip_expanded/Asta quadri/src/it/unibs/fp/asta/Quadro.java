package it.unibs.fp.asta;

public class Quadro {
	private static final double PERCENTUALE_GUADAGNO = 0.25;
	
	private String titolo, autore, tecnica;
	private int anno;
	private double lato1, lato2, acquisto, baseAsta;

	public Quadro(String titolo, String autore, String tecnica, int anno, double lato1, double lato2, double acquisto) {
		this.titolo = titolo;
		this.autore = autore;
		this.tecnica = tecnica;
		this.anno = anno;
		this.lato1 = lato1;
		this.lato2 = lato2;
		this.acquisto = acquisto;
		this.setBaseAsta(acquisto + acquisto * PERCENTUALE_GUADAGNO);
	}

	public String getTitolo() {
		return titolo;
	}

	public String getAutore() {
		return autore;
	}

	public String getTecnica() {
		return tecnica;
	}

	public int getAnno() {
		return anno;
	}

	public double getAcquisto() {
		return acquisto;
	}

	public double getBaseAsta() {
		return baseAsta;
	}

	public void setBaseAsta(double baseAsta) {
		this.baseAsta = baseAsta;
	}

	public double getLato2() {
		return lato2;
	}

	public double getLato1() {
		return lato1;
	}
	
	public String toStringDescrizione() {
		StringBuffer descrizione = new StringBuffer();
		descrizione.append("Nome quadro: "+getTitolo());
		descrizione.append("Autore: "+getAutore());
		descrizione.append("Tecnica di pittura: "+getTecnica());
		descrizione.append("Anno realizzazione quadro: "+getAnno());
		return descrizione.toString();
	}
	
	public String toStringBase() {
		StringBuffer descrizione = new StringBuffer();
		descrizione.append("Base d'asta quadro selezionato: "+getBaseAsta());
		return descrizione.toString();
	}
}
