package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import it.uniroma3.diadia.Configuratore;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatoreAttrezziPerPeso;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = Configuratore.getPesoMax();
	public final static int CFU_INIZIALI = 20;
	private Map<String, Attrezzo> nome2attrezzi;
	private int numeroAttrezzi; //max attrezzi
	private int pesoMax;
	private int pesoCorrente;
	
		
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		// this.attrezzi = new ArrayList<Attrezzo>(); 
		this.nome2attrezzi = new TreeMap<>();
		this.numeroAttrezzi = 0;
		this.pesoCorrente = 0;
	}
	
// non servono piu gli attrezzi max solo peso
// static final private int NUMERO_MASSIMO_ATTREZZI = 10;

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso()+attrezzo.getPeso() > this.getPesoMax())
		return false;
		this.nome2attrezzi.put(attrezzo.getNome(),attrezzo);
		this.pesoCorrente = this.pesoCorrente + attrezzo.getPeso();
		return true;
	}
	
	public int getPesoMax() {
		return pesoMax;
	}
	
	public boolean getPesoRimanente(Attrezzo a) {
		if(a != null && this.getPesoMax()-this.getPeso()>=a.getPeso())
			return true;
		return false; 
	}


	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		if(nomeAttrezzo != null && this.nome2attrezzi.containsKey(nomeAttrezzo))
			a = this.nome2attrezzi.get(nomeAttrezzo);
		return a;
	
	}
	
	public int getPeso() {
		return this.pesoCorrente;
	}
	
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
	
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}


	/* rimuovere l'attrezzo dall'array degli attrezzi*/
	public Attrezzo removeAttrezzoBorsa(String nomeAttrezzo) {
		Attrezzo a = null;
		if(nomeAttrezzo!= null) {
			a = nome2attrezzi.remove(nomeAttrezzo);
		}
		return a;
	}
	
	SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		SortedSet<Attrezzo> s = new TreeSet<Attrezzo>(new ComparatoreAttrezziPerPeso());
		s.addAll(this.nome2attrezzi.values());
		return s;
	}
	// es n 3
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			s.append(this.getContenutoOrdinatoPerNome().toString());
			s.append(this.getContenutoRaggruppatoPerPeso().toString());
			s.append(this.getContenutoOrdinatoPerPeso().toString());
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
	SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		return new TreeSet<Attrezzo>(this.nome2attrezzi.values());
	}
	Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer, Set<Attrezzo>> a2p = new TreeMap<>(); //es 3
		for(Attrezzo a : this.nome2attrezzi.values()){
			if(a2p.containsKey(a.getPeso())) {
				a2p.get(a.getPeso()).add(a);
			}
			else {
				Set<Attrezzo>  s =new HashSet<Attrezzo>();
				s.add(a);
				a2p.put(a.getPeso(), s);
			}
		}
		return a2p;
	}
	
	List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> l = new ArrayList<>();
		l.addAll(this.nome2attrezzi.values());
		Collections.sort(l, new ComparatoreAttrezziPerPeso());
		return l;
	}


}

