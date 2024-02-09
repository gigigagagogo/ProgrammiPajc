package it.unibs.fp.asta;

public class Offerta {

	private String nomeOfferente;
	private double quantitaOfferta;
	private Quadro quadro;
	
	public Offerta(String nomeOfferente, double quantitaOfferta, Quadro quadro) {
		this.nomeOfferente = nomeOfferente;
		this.quantitaOfferta = quantitaOfferta;
		this.quadro = quadro;
	}

	public String getNomeOfferente() {
		return nomeOfferente;
	}

	public double getQuantitaOfferta() {
		return quantitaOfferta;
	}

	public Quadro getQuadro() {
		return quadro;
	}
	
	public String toString() { 
		StringBuffer descrizione = new StringBuffer();
		descrizione.append("Nome offerente: "+ getNomeOfferente());
		descrizione.append("\nOfferta: "+ getQuantitaOfferta());
		descrizione.append("\nQuadro: "+ getQuadro().getTitolo());
		return descrizione.toString();
	}
}
