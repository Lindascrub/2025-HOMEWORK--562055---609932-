package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {

	Direzione direzioneBloccata;
	String nomeAttrezzoSbloccante;
	
	public StanzaBloccata(String nome,String nomeAttrezzo,Direzione nomeDirezione) {
		super(nome);
		this.nomeAttrezzoSbloccante=nomeAttrezzo;
		this.direzioneBloccata=nomeDirezione;
	}
	 	
	
	public Stanza getStanzaAdiacente(Direzione direzione) {
		
        if(this.direzioneBloccata.equals(direzione) && !this.hasAttrezzo(nomeAttrezzoSbloccante)) {
        	return this;
        }
        return super.getStanzaAdiacente(direzione);
	}
	
	@Override
	 public String getDescrizione() {
		
		String bloccata="Stanza bloccata nella direzione: "+ direzioneBloccata+ "\nPrendi l'attrezzo "+nomeAttrezzoSbloccante+ " e posalo nella stanza\n";
		
		
		if(!this.hasAttrezzo(nomeAttrezzoSbloccante))
			return bloccata;
		
		return super.getDescrizione();
    }
	
	
}
