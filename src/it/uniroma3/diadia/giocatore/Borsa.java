package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	public final static int CFU_INIZIALI = 20;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	static final private int NUMERO_MASSIMO_ATTREZZI = 10;
	
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10]; 
		this.numeroAttrezzi = 0;
	}
	
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (attrezzo!= null) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.numeroAttrezzi==10)
			return false;
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		}
		return true;
	
	}
	
	public int getPesoMax() {
		return pesoMax;
	}
	
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			if (this.attrezzi[i] != null && this.attrezzi[i].getNome().equals(nomeAttrezzo) )
				a = attrezzi[i];
		return a;
	}
	
	public int getPeso() {
		int peso = 0;
		for (int i= 0; i<this.numeroAttrezzi; i++){
			if(this.attrezzi[i] != null)
			peso += this.attrezzi[i].getPeso();
		}
		return peso;
	}
	
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
	
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	
	/* rimuovere l'attrezzo dall'array degli attrezzi*/
	public Attrezzo[] removeAttrezzoBorsa(String nomeAttrezzo) {
		Attrezzo[] attrezzoRimosso = new Attrezzo[NUMERO_MASSIMO_ATTREZZI];
		for(int i = 0; i<NUMERO_MASSIMO_ATTREZZI; i++) {
			if(this.attrezzi[i]!= null) {
				if(this.attrezzi[i].getNome().equals(nomeAttrezzo)) {
					 this.attrezzi[i]= attrezzoRimosso[i]  ;
					 attrezzoRimosso[i] = null;
			}
		}
		}
		return attrezzoRimosso;
	}
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i= 0; i<this.numeroAttrezzi; i++)
				s.append(attrezzi[i].toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
}

