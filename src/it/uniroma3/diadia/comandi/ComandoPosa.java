package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {

	private String nomeAttrezzo;
	private IOConsole ioConsole=IOConsole.getIOConsole();
	
	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		if( nomeAttrezzo == null) {
			this.ioConsole.mostraMessaggio("Che attrezzo vuoi posare?\nAttrezzo inesistente!\n");
		}
		else {
			Stanza stanzaCorrente = partita.getStanzaCorrente();
			if (!partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
				this.ioConsole.mostraMessaggio("Che attrezzo vuoi posare?\n");
			}
			else {
				Attrezzo attrezzoPosato = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
				if(attrezzoPosato != null) {
					partita.getGiocatore().getBorsa().removeAttrezzoBorsa(nomeAttrezzo);
					stanzaCorrente.addAttrezzo(attrezzoPosato);

				}
				else {
					this.ioConsole.mostraMessaggio("La borsa è vuota!");
				}
			}
		}
		this.ioConsole.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		this.nomeAttrezzo=parametro;
	}

}
