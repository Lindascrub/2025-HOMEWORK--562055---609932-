package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;



public class Giocatore {
	private final static int CFU_INIZIALI = 3;
	private int cfu;
	private Borsa borsa;


	public Giocatore() {
		this.borsa = new Borsa();
		this.cfu=CFU_INIZIALI;
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

    public boolean prendereAttrezzo(Attrezzo Attrezzo) {
        return this.borsa.addAttrezzo(Attrezzo);
    }

    public Attrezzo[] posareAttrezzo(String nomeAttrezzo) {
        return this.borsa.removeAttrezzoBorsa(nomeAttrezzo);
    }
    

}
