package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatoreNomeAttrezzi;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	public final static int CFU_INIZIALI = 20;
	private List<Attrezzo> attrezzi;
	private int pesoMax;
	static final private int NUMERO_MASSIMO_ATTREZZI = 10;
	
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new ArrayList<Attrezzo>(); 
	}
	
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo.getPeso()+this.getPeso()>this.getPesoMax()) {
			return false;
		}
		return this.attrezzi.add(attrezzo);
	}
	
	public int getPesoMax() {
		return pesoMax;
	}
	
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		for(Attrezzo a : this.attrezzi) {
			if(a.getNome().equals(nomeAttrezzo)) {
				return a;
			}
		}
		return null;
	}
	
	public int getPeso() {
		int peso = 0;
		for(Attrezzo a : this.attrezzi) {
			peso+=a.getPeso();
		}
		return peso;
	}
	
	public boolean isEmpty() {
		return this.attrezzi.size() == 0;
	}
	
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	
	/* rimuovere l'attrezzo dall'array degli attrezzi*/
	public Attrezzo removeAttrezzoBorsa(String nomeAttrezzo) {
		Attrezzo attrezzoDaRimuovere=null;
		for(Attrezzo a : this.attrezzi) {
			if(a.getNome().equals(nomeAttrezzo)) {
				attrezzoDaRimuovere=a;
				break;
			}
		}
		if(attrezzoDaRimuovere!=null) {
			this.attrezzi.remove(attrezzoDaRimuovere);
		}
		return attrezzoDaRimuovere;
	}
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> attrezziOrdinati=new ArrayList<Attrezzo>();
		attrezziOrdinati.addAll(this.attrezzi);
		Collections.sort(attrezziOrdinati);
		return attrezziOrdinati;
	}
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		Comparator<Attrezzo> cmp=new ComparatoreNomeAttrezzi();
		SortedSet<Attrezzo> attrezziOrdinati=new TreeSet<Attrezzo>(cmp);
		attrezziOrdinati.addAll(this.attrezzi);
		return attrezziOrdinati;
		
	}
	
	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer,Set<Attrezzo>> peso2attrezzi=new HashMap<Integer, Set<Attrezzo>>();
		for(Attrezzo a : this.attrezzi) {
			if(peso2attrezzi.containsKey(a.getPeso())) {
				peso2attrezzi.get(a.getPeso()).add(a);
			}
			else {
				Set<Attrezzo> set=new HashSet<Attrezzo>();
				set.add(a);
				peso2attrezzi.put(a.getPeso(),set);
			}
		}
		return peso2attrezzi;
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i= 0; i<this.attrezzi.size(); i++)
				s.append(this.attrezzi.get(i).toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
}

