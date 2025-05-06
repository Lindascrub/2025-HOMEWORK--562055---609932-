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
	private Labirinto labirinto;
	private Giocatore giocatore;
	private boolean finita;

	public Partita() {
			
		this.labirinto = new Labirinto();
		this.giocatore = new Giocatore();
		labirinto.creaStanze();
		this.finita = false;
	}
	

	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return labirinto.getStanzaCorrente().equals(labirinto.getStanzaVincente());
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || !(giocatoreIsVivo());
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	
	public void setFinita() {
		this.finita = true;
	}
	
	
	public String toString() {
		return this.getStanzaCorrente()+"\nCfu = " + this.giocatore.getCfu();
	}
	
	private Stanza getStanzaCorrente() {
		// TODO Auto-generated method stub
		return this.getLabirinto().getStanzaCorrente();
	}
	
	public Giocatore getGiocatore() {
		return giocatore;
	}
	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}

	public boolean giocatoreIsVivo() {
		return (this.giocatore.getCfu() > 0);
	}



	public Labirinto getLabirinto() {
		// TODO Auto-generated method stub
		return labirinto;
	}

	public void setLabirinto(Labirinto labirinto) {
		this.labirinto = labirinto;
	}

}
