package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoRegala extends AbstractComando {

	private String parametro;
	
	@Override
	public void esegui(Partita partita) {
		AbstractPersonaggio personaggio = partita.getStanzaCorrente().getPersonaggio();

		if (this.parametro == null) {
			io.mostraMessaggio("Devi specificare l'attrezzo da regalare.");
			return;
		}

		if (personaggio == null) {
			io.mostraMessaggio("Non c'è nessun personaggio a cui regalare qualcosa.");
			return;
		}

		Attrezzo daRegalare = partita.getGiocatore().getBorsa().getAttrezzo(this.parametro);

		if (daRegalare == null) {
			io.mostraMessaggio("Non hai questo attrezzo nella borsa.");
			return;
		}

		// Rimuove dalla borsa e lo regala
		partita.getGiocatore().getBorsa().removeAttrezzoBorsa(this.parametro);
		String risposta = personaggio.riceviRegalo(daRegalare, partita);
		io.mostraMessaggio(risposta);
	}
;
	@Override
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}
	
	@Override
	public String getParametro() {
		return this.parametro;
	}
	
	@Override
	public String getNome() {
		return "regala";
	}

}
