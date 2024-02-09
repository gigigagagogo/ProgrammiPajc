package it.unibs.fp.asta;

import java.util.ArrayList;

public class Asta {

	private ArrayList<Quadro> listaQuadri = new ArrayList<>();

	public Asta(ArrayList<Quadro> listaQuadri) {
		super();
		this.listaQuadri = new ArrayList<>();
	}

	public ArrayList<Quadro> getListaQuadri() {
		return listaQuadri;
	}

	public void setListaQuadri(ArrayList<Quadro> listaQuadri) {
		this.listaQuadri = listaQuadri;
	}
	
	public void aggiungiQuadro(Quadro q) {
		listaQuadri.add(q);
	}
	
	public int selezionaQuadro(String nomeQuadro) {
		for(int i = 0; i < listaQuadri.size(); i++) {
			if(listaQuadri.get(i).getTitolo().equals(nomeQuadro) == true) {
				return i;
			}
		}
		return listaQuadri.size()+1;
	}
	
	public String toString() {
		StringBuffer descrizione = new StringBuffer();
		for(Quadro quadro : listaQuadri) {
			descrizione.append(quadro.toString());
		}
		return descrizione.toString();
	}
	
}
