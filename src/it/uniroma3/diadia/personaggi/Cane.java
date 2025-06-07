package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;

public class Cane extends AbstractPersonaggio {

	/*NB: quando interagiamo con un cane, questi morde, togliendoci CFU a ogni morso*/
	
	private static final String MESSAGGIO_CANE="Woof, woof! Ti ho tolto un CFU";
	private String ciboPreferito;
	
	public Cane(String nome, String presentaz, String ciboPreferito) {
		super(nome, presentaz);
		this.ciboPreferito=ciboPreferito;
	}

	@Override
	public String agisci(Partita partita) {
		String msg;
		msg=MESSAGGIO_CANE;
		if(partita.getGiocatore().getCfu()>0) {
			partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		}
		return msg;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		if (attrezzo.getNome().equalsIgnoreCase(this.ciboPreferito)) {
			// cane lascia un oggetto per ringraziare
			Attrezzo osso = new Attrezzo("osso", 1);
			partita.getStanzaCorrente().addAttrezzo(osso);
			return "Wof! Grazie per il " + this.ciboPreferito + "! Ti lascio un osso!";
		} else {
			// morde!
			if (partita.getGiocatore().getCfu() > 0)
				partita.getGiocatore().setCfu(partita.getGiocatore().getCfu() - 1);
			return "GRRR! Non mi piace! Ti ho morso! -1 CFU.";
		}
	}

	
	
}
