package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {

	String direzioneBloccata;
	String nomeAttrezzoSbloccante;
	
	public StanzaBloccata(String nome,String nomeAttrezzo,String nomeDirezione) {
		super(nome);
		this.nomeAttrezzoSbloccante=nomeAttrezzo;
		this.direzioneBloccata=nomeDirezione;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
        if(!this.hasAttrezzo(nomeAttrezzoSbloccante))
        	return this;
        else {
        	return super.getStanzaAdiacente(direzione);
        }
	}
	
	@Override
	 public String getDescrizione() {
		if(this.hasAttrezzo(nomeAttrezzoSbloccante))
			return this.toString();
		else return "stanza bloccata";
    }
	
	
}
