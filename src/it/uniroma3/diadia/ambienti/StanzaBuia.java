package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {

	private String nomeAttrezzoNecessario;
	
	public StanzaBuia(String nome, String nomeAttrezzo) {
		super(nome);
		this.nomeAttrezzoNecessario=nomeAttrezzo;
	}
	
	
	@Override
	public String getDescrizione() {
		if(!this.hasAttrezzo(nomeAttrezzoNecessario))
			return "qui c'è buio pesto"; //es 2
        return this.toString();
    }
	
}
