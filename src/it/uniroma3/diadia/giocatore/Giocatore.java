package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Giocatore {
	private int cfu;
	private Borsa borsa;
	

	public Giocatore() {
		this.setBorsa(new Borsa());
	}

	public int getCfu() {
		return cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;
	}

	public Borsa getBorsa() {
		return borsa;
	}

	public void setBorsa(Borsa borsa) {
		this.borsa = borsa;
	}

}
