package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {

	private String nomeAttrezzo;
	private IOConsole ioConsole=IOConsole.getIOConsole();
	@Override
	public void esegui(Partita partita) {
		if( nomeAttrezzo == null) {
			this.ioConsole.mostraMessaggio("Che attrezzo vuoi prendere?\nAttrezzo inesistente!\n");
		}else {
			//se {
			Stanza stanzaCorrente = partita.getStanzaCorrente();
			if (!stanzaCorrente.hasAttrezzo(nomeAttrezzo)) {
				this.ioConsole.mostraMessaggio("Che attrezzo vuoi prendere?\n");
			}
			else {
				Attrezzo attrezzoPreso = stanzaCorrente.getAttrezzo(nomeAttrezzo);
				if(partita.getGiocatore().prendereAttrezzo(attrezzoPreso)) {
					stanzaCorrente.removeAttrezzo(attrezzoPreso);

				}
				else {
					this.ioConsole.mostraMessaggio("La borsa è piena!");
				}
			}
			this.ioConsole.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		}
	}
	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		this.nomeAttrezzo=parametro;
	}
	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "prendi";
	}
	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return this.nomeAttrezzo;
	}

}
