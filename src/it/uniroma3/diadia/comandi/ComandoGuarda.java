package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends AbstractComando {

	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		partita.getIo().mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "guarda";
	}

}
