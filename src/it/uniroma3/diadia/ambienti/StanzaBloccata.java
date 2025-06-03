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
		
        if(this.direzioneBloccata.equals(direzione) && !this.hasAttrezzo(nomeAttrezzoSbloccante)) {
        	return this;
        }
        return super.getStanzaAdiacente(direzione);
	}
	
	@Override
	 public String getDescrizione() {
		
		String bloccata="Stanza bloccata nella direzione: "+ direzioneBloccata+ "\nPrendi l'attrezzo "+nomeAttrezzoSbloccante+ " e posalo nella stanza\n";
		
		String result = "";
		
		if(!this.hasAttrezzo(nomeAttrezzoSbloccante))
			result=result+bloccata;
		
		result = result + super.getDescrizione();
		
		return result;
    }
	
	
}
