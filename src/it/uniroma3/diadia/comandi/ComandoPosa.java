package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {

	private String nomeAttrezzo;
	
	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		if( nomeAttrezzo == null) {
			partita.getIo().mostraMessaggio("Che attrezzo vuoi posare?\nAttrezzo inesistente!\n");
		}
		else {
			Stanza stanzaCorrente = partita.getStanzaCorrente();
			if (!partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
				partita.getIo().mostraMessaggio("Che attrezzo vuoi posare?\n");
			}
			else {
				Attrezzo attrezzoPosato = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
				if(attrezzoPosato != null) {
					partita.getGiocatore().getBorsa().removeAttrezzoBorsa(nomeAttrezzo);
					stanzaCorrente.addAttrezzo(attrezzoPosato);

				}
				else {
					partita.getIo().mostraMessaggio("La borsa è vuota!");
				}
			}
		}
		partita.getIo().mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		this.nomeAttrezzo=parametro;
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "posa";
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return this.nomeAttrezzo;
	}

}
