package it.unibs.fp.asta;

import java.util.ArrayList;

import it.unibs.fp.mylib.InputDati;

public class IOUtil {

	public static Offerta creaOfferta(Quadro quadro) {
		String nomeOfferente = InputDati.leggiStringa("Inserisci il nome dell'offerente: ");
		double soldiOfferti = InputDati.leggiDoubleConMinimo("Inserisci l'offerta fatta: ", quadro.getBaseAsta());
		Offerta nuovaOfferta = new Offerta(nomeOfferente, soldiOfferti, quadro);
		return nuovaOfferta;
	}
	
	public static Quadro creaQuadro() {
		String titolo = InputDati.leggiStringa("Inserisci il tiolo del nuovo quadro: ");
		String autore = InputDati.leggiStringa("Inserisci il nome dell'autore del nuovo quadro: ");
		String tecnica = InputDati.leggiStringa("Inserisci la tecnica di realizzazione del quadro: ");
		int anno = InputDati.leggiIntero("Inserisci l'anno in cui è stato realizzato il quadro: ");
		double lato1 = InputDati.leggiDoubleConMinimo("Inserisci la misura del primo lato in cm: ",0);
		double lato2 = InputDati.leggiDoubleConMinimo("Inserisci la misura del secondo lato in cm: ",0);
		double prezzoAcquisto = InputDati.leggiDoubleConMinimo("Inserisci il prezzo d'acquisto del quadro: ", 1);
		Quadro nuovoQuadro = new Quadro(titolo, autore, tecnica, anno, lato1, lato2, prezzoAcquisto);
		return nuovoQuadro;
	}
	
	public static Asta creaAsta() {
		ArrayList<Quadro> listaQuadri = new ArrayList<>();
		int n = InputDati.leggiInteroConMinimo("Inserisci il numero di quadri che saranno battuti all'asta: ", 1);
		for(int i = 0; i < n; i++) {
			Quadro nuovoQuadro = IOUtil.creaQuadro();
			listaQuadri.add(nuovoQuadro);
		}
		Asta nuovAsta = new Asta(listaQuadri);
		return nuovAsta;
	}
	
	public static void avvia(Asta asta) {
		
		ArrayList<Quadro> quadriVenduti = new ArrayList<>();
		logicaAsta(asta, quadriVenduti);
		boolean altraAsta = InputDati.yesOrNo("Desideri procedere con un altra asta? ");
		while(altraAsta == true) {
			int n = InputDati.leggiIntero("Quanti quadri vuoi aggiungere alla tua nuova asta?");
			for(int i = 0; i < n; i++) {
				Quadro nuovoQuadro = IOUtil.creaQuadro();
				asta.aggiungiQuadro(nuovoQuadro);
			}
			logicaAsta(asta, quadriVenduti);
		}
		
		
	}

	public static void logicaAsta(Asta asta, ArrayList<Quadro> quadriVenduti) {
		double guadagno = 0;
		double vendita;
		boolean continua = false;
		do {
			asta.toString();
			String quadroScelto = InputDati.leggiStringa("Inserisci il nome del quadro da selezionare: ");
			if(asta.selezionaQuadro(quadroScelto) < asta.getListaQuadri().size()+1) {
				System.out.println(""+asta.getListaQuadri().get(asta.selezionaQuadro(quadroScelto)));
				boolean rilancio = false;
				boolean scelta = InputDati.yesOrNo("Ci sono offerte per questo quadro?");
				Offerta nuovaOfferta;
				if(scelta == true) {
					do {
						nuovaOfferta = IOUtil.creaOfferta(asta.getListaQuadri().get(asta.selezionaQuadro(quadroScelto)));
						vendita = nuovaOfferta.getQuantitaOfferta();
						rilancio = InputDati.yesOrNo("Qualcuno ha rilanciato?");
					} while (!rilancio);
					System.out.println(""+nuovaOfferta.toString());
					quadriVenduti.add(asta.getListaQuadri().get(asta.selezionaQuadro(quadroScelto)));
					asta.getListaQuadri().remove(asta.selezionaQuadro(quadroScelto));
					guadagno = vendita - asta.getListaQuadri().get(asta.selezionaQuadro(quadroScelto)).getAcquisto();
				}
				continua = InputDati.yesOrNo("Continuare con l'asta?");
			}else {
				System.out.println("Il quadro da selezionare non è presente in lista!!!");
				continua = InputDati.yesOrNo("Continuare con l'asta?");
			}
		}while(continua);
		System.out.println("Il guadagno ottenuto da questa asta è :"+guadagno);
		
	}
}
