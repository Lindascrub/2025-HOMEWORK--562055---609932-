package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.giocatore.Giocatore;

public class Cane extends AbstractPersonaggio {

	/*NB: quando interagiamo con un cane, questi morde, togliendoci CFU a ogni morso*/
	
	private Giocatore giocatore; 
	private static final String MESSAGGIO_ABBAIO="Woof, woof!";
	
	public Cane(String nome, String presentaz) {
		super(nome, presentaz);
	}

	@Override
	public String agisci(Partita partita) {
		String msg;
		msg=MESSAGGIO_ABBAIO;
		if(this.giocatore.getCfu()>0) {
			this.giocatore.setCfu(0);
		}
		return msg;
	}

	
	
}
