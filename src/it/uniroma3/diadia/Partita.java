package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	private boolean finita;
	Giocatore giocatore;
	Labirinto labirinto;
	
	

	static final private int CFU_INIZIALI = 20;
	
	public Partita() {
		this(CFU_INIZIALI);
	}
	
	public Partita(int cfu) {
		
		this.labirinto = new Labirinto();
		this.stanzaCorrente = this.labirinto.getStanzaIniziale();
		this.stanzaVincente = this.labirinto.getStanzaVincente();
		this.giocatore = new Giocatore();
		this.giocatore.setCfu(cfu);
	}
	

	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente() == this.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (this.giocatore.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	public Giocatore getGiocatore() {
		return this.giocatore;
	}

	public boolean giocatoreIsVivo() {
		// TODO Auto-generated method stub
		return this.giocatore.getCfu()>0;
	}

}
