package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoSaluta extends AbstractComando {
	
	@Override
	public void esegui(Partita partita) {
		AbstractPersonaggio personaggio = partita.getStanzaCorrente().getPersonaggio();
		
		if(personaggio!=null) {
			this.io.mostraMessaggio(personaggio.saluta());
		}
		else {
			this.io.mostraMessaggio("Non c'è nessuno da salutare...");
		}
	}

	@Override
	public String getNome() {
		return "saluta";
	}

}
