package it.uniroma3.diadia;

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

    public boolean prendereAttrezzo(Attrezzo nomeAttrezzo) {
        return this.borsa.addAttrezzo(nomeAttrezzo);
    }

    public Attrezzo[] posareAttrezzo(String nomeAttrezzo) {
        return this.borsa.removeAttrezzoBorsa(nomeAttrezzo);
    }

}
