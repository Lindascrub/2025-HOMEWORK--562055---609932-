package it.uniroma3.diadia.personaggi;

import java.util.List;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
// es 14
public class Strega extends AbstractPersonaggio {

	private static final String MESSAGGIO_SALUTATA = "Ciao!";
	private static final String MESSAGGIO_NON_SALUTATA = "Perchè non mi hai salutata?";

	public Strega(String nome, String presentazione) {
		super(nome, presentazione);
	}

	@Override
	public String agisci(Partita partita) {
		String msg;
		List<Stanza> stanzeAdiacenti = ((Stanza) partita.getStanzaCorrente()).getStanzeAdiacenti();

		Stanza maxAtrezzi = stanzeAdiacenti.get(0);
		Stanza minAtrezzi = stanzeAdiacenti.get(0);

		for(Stanza s : stanzeAdiacenti) {
			if(s != null) {
				if(s.getNumeroAttrezzi() > maxAtrezzi.getNumeroAttrezzi())
					maxAtrezzi = s;
				if(s.getNumeroAttrezzi() < minAtrezzi.getNumeroAttrezzi())
					minAtrezzi = s;
			}
		}

		if(this.haSalutato()) {
			partita.setStanzaCorrente(maxAtrezzi);
			msg = MESSAGGIO_SALUTATA;
		} else {
			partita.setStanzaCorrente(minAtrezzi);
			msg = MESSAGGIO_NON_SALUTATA;
		}

		return msg;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		return "ahahah!";
	}

}
