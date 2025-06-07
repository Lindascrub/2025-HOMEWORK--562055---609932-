package it.uniroma3.diadia.personaggi;

import java.util.List;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio {
	
	private static final String MESSAGGIO_SALUTATA = "Ciao!";
	private static final String MESSAGGIO_NON_SALUTATA = "Perchè non mi hai salutata?";
	
	public Strega(String nome, String presentaz) {
		super(nome, presentaz);
	}

	@Override
	public String agisci(Partita partita) {
		String messaggio;
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		List<String> direzioni = stanzaCorrente.getDirezioni();
		
		if(direzioni.isEmpty()) {
			return "Non ci sono stanze adiacenti";
		}
		Stanza scelta=null;
		for(String direzione : direzioni) {
			Stanza adiacente = stanzaCorrente.getStanzaAdiacente(direzione);
			if(scelta == null ||
					(this.haSalutato() && adiacente.getAttrezzi().size() > scelta.getAttrezzi().size()) ||
					(!this.haSalutato() && adiacente.getAttrezzi().size() < scelta.getAttrezzi().size())) {
				scelta=adiacente;
				
			}
		}
		
		if(scelta!=null) {
			partita.setStanzaCorrente(scelta);
			messaggio=this.haSalutato() ? MESSAGGIO_SALUTATA : MESSAGGIO_NON_SALUTATA;
		}
		else {
			messaggio= "Non ho trovato stanze utili.";
		}
		
		return messaggio;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		return "Ahahah! Lo terrò con me, umano sciocco!";
	}

}
