package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {

	private String direzione;
	
	/*public ComandoVai(String direzione) {
		this.direzione=direzione;
	}*/
	
	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		Stanza stanzaCorrente=partita.getStanzaCorrente();
		Stanza prossimaStanza=null;
		if(direzione==null) {
			partita.getIo().mostraMessaggio("Dove vuoi andare? Devi specificare una direzione");
			return;
		}
		prossimaStanza=stanzaCorrente.getStanzaAdiacente(this.direzione);
		if(prossimaStanza==null) {
			partita.getIo().mostraMessaggio("Direzione inesistente");
			return;
		}
		partita.setStanzaCorrente(prossimaStanza);
		partita.getIo().mostraMessaggio(partita.getStanzaCorrente().getNome());
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		this.direzione=parametro;
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "vai";
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return this.direzione;
	}

}
