package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;


public class LabirintoBuilder {

	private Labirinto labirinto;
	private Map<String,Stanza> nome2stanza;
	private Stanza ultimaStanza;
	
	public LabirintoBuilder() {
		this.labirinto=new Labirinto();
		this.nome2stanza=new HashMap<String, Stanza>();
	}
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	
	public LabirintoBuilder addStanzaIniziale(String nomeStanza) {
		Stanza stanza=null;
		if(this.nome2stanza.containsKey(nomeStanza)) {
			stanza=nome2stanza.get(nomeStanza);
		}
		else {
			stanza=new Stanza(nomeStanza);
			nome2stanza.put(nomeStanza, stanza);
		}
		this.labirinto.setStanzaIniziale(stanza);
		this.ultimaStanza=stanza;
		return this;
	}
	
	public LabirintoBuilder addStanzaVincente(String nomeStanza) {
		Stanza stanza=null;
		if(this.nome2stanza.containsKey(nomeStanza)) {
			stanza=nome2stanza.get(nomeStanza);
		}
		else {
			stanza=new Stanza(nomeStanza);
			nome2stanza.put(nomeStanza, stanza);
		}
		this.labirinto.setStanzaVincente(stanza);
		this.ultimaStanza=stanza;
		return this;
	}
	
	public LabirintoBuilder addAttrezzo(String attrezzo,int peso) {
		Attrezzo attrezzoDaAggiungere=new Attrezzo(attrezzo, peso);
		ultimaStanza.addAttrezzo(attrezzoDaAggiungere);
		return this;
	}
	
	public LabirintoBuilder addAdiacenza(String origine,String dest,String dir) {
		if(nome2stanza.containsKey(origine) && nome2stanza.containsKey(dest)) {
			nome2stanza.get(origine).impostaStanzaAdiacente(dir,nome2stanza.get(dest));
		}
		return this;
	}
	
	public LabirintoBuilder addStanza(String nomeStanza) {
		if(!nome2stanza.containsKey(nomeStanza)) {
			Stanza stanza=new Stanza(nomeStanza);
			nome2stanza.put(nomeStanza, stanza);
			ultimaStanza=stanza;
		}
		return this;
	}
	
	
}
