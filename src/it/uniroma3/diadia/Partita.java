package it.uniroma3.diadia;



/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {
	private Stanza stanzaCorrente;
	private boolean finita;
	Giocatore giocatore;
	Labirinto labirinto;
	
	

	static final private int CFU_INIZIALI = 20;
	
	public Partita() {
			
		this.labirinto = new Labirinto();
		this.stanzaCorrente = this.labirinto.getStanzaIniziale();
		this.giocatore = new Giocatore();
		this.giocatore.setCfu(CFU_INIZIALI);
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
		return this.getStanzaCorrente()== this.labirinto.getStanzaVincente();
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


	public void setCfu(int i) {
		// TODO Auto-generated method stub
		
	}


	public int getCfu() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	public Giocatore getGiocatore() {
		return this.giocatore;
	}

}
