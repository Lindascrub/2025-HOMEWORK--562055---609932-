package it.uniroma3.diadia.giocatore;
import static org.junit.jupiter.api.Assertions.*;

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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatoreNomeAttrezzi;
import it.uniroma3.diadia.giocatore.Borsa;

class BorsaTest {

	private Borsa borsa;
    private Attrezzo attrezzoLeggero;
    private Attrezzo attrezzoPesante;
    private Attrezzo attrezzoMedio;
    private Attrezzo attrezzoLeggero2;
    
    @BeforeEach
    void setUp() {
        borsa = new Borsa(10);
        attrezzoLeggero = new Attrezzo("Torcia", 2);
        attrezzoPesante = new Attrezzo("Incudine", 15);
        attrezzoMedio = new Attrezzo("pala", 4);
        attrezzoLeggero2 = new Attrezzo("osso", 2);
    }
    
    @Test
    void testBorsaVuota() {
        assertTrue(borsa.isEmpty());
    }
    
    @Test
    void testAggiuntaAttrezzo() {
        assertTrue(borsa.addAttrezzo(attrezzoLeggero));
        assertFalse(borsa.isEmpty());
        assertEquals(attrezzoLeggero, borsa.getAttrezzo("Torcia"));
    }
    
    @Test
    void testNonAggiuntaAttrezzoTroppoPesante() {
        assertFalse(borsa.addAttrezzo(attrezzoPesante));
    }

    @Test
    void testGetContenutoOrdinatoPerPesoConTreAttrezzi() {
    	this.borsa=new Borsa(50);
    	List<Attrezzo> exp=new ArrayList<Attrezzo>();
    	exp.add(attrezzoLeggero);
    	exp.add(attrezzoMedio);
    	exp.add(attrezzoPesante);
    	borsa.addAttrezzo(attrezzoLeggero);
    	borsa.addAttrezzo(attrezzoPesante);
    	borsa.addAttrezzo(attrezzoMedio);
    	assertEquals(exp,borsa.getContenutoOrdinatoPerPeso());
    }
    
    @Test
    void testGetContenutoOrdinatoPerNomeConTreAttrezzi() {
    	this.borsa=new Borsa(50);
    	SortedSet<Attrezzo> exp = new TreeSet<Attrezzo>();
    	exp.add(attrezzoPesante);
    	exp.add(attrezzoMedio);
    	exp.add(attrezzoLeggero);
    	borsa.addAttrezzo(attrezzoLeggero);
    	borsa.addAttrezzo(attrezzoMedio);
    	borsa.addAttrezzo(attrezzoPesante);
    	assertEquals(exp,borsa.getContenutoOrdinatoPerNome());
    }
    
    @Test
    void testGetContenutoRaggruppatoPerPesoConTreAttrezziDiPesoDiverso() {
    	this.borsa=new Borsa(50);
    	Map<Integer,Set<Attrezzo>> exp = new HashMap<Integer, Set<Attrezzo>>();
    	
    	Set<Attrezzo> set1=new HashSet<Attrezzo>();
    	set1.add(attrezzoLeggero);
    	exp.put(attrezzoLeggero.getPeso(), set1);
    	
    	Set<Attrezzo> set2=new HashSet<Attrezzo>();
    	set2.add(attrezzoMedio);
    	exp.put(attrezzoMedio.getPeso(), set2);
    	
    	Set<Attrezzo> set3=new HashSet<Attrezzo>();
    	set3.add(attrezzoPesante);
    	exp.put(attrezzoPesante.getPeso(), set3);
    	
    	borsa.addAttrezzo(attrezzoLeggero);
    	borsa.addAttrezzo(attrezzoMedio);
    	borsa.addAttrezzo(attrezzoPesante);
    	assertTrue(borsa.getContenutoRaggruppatoPerPeso().size()==3);
    	assertTrue(borsa.getContenutoRaggruppatoPerPeso().containsKey(attrezzoLeggero.getPeso()));
    	assertTrue(borsa.getContenutoRaggruppatoPerPeso().containsKey(attrezzoMedio.getPeso()));
    	assertTrue(borsa.getContenutoRaggruppatoPerPeso().containsKey(attrezzoPesante.getPeso()));
    	
    }
    
    void testGetContenutoRaggruppatoPerPesoConDueAttrezziDiPesoUguale() {
    	this.borsa=new Borsa(50);
    	Map<Integer,Set<Attrezzo>> exp = new HashMap<Integer, Set<Attrezzo>>();
    	Set<Attrezzo> set=new HashSet<Attrezzo>();
    	set.add(attrezzoLeggero);
    	set.add(attrezzoLeggero2);
    	exp.put(attrezzoLeggero.getPeso(), set);
    	borsa.addAttrezzo(attrezzoLeggero);
    	borsa.addAttrezzo(attrezzoLeggero2);
    	assertEquals(exp,borsa.getContenutoRaggruppatoPerPeso());
    	
    }
    
    void testGetContenutoRaggruppatoPerPesoConTreAttrezziDueDiPesoUguale() {
    	this.borsa=new Borsa(50);
    	Map<Integer,Set<Attrezzo>> exp = new HashMap<Integer, Set<Attrezzo>>();
    	Set<Attrezzo> set1=new HashSet<Attrezzo>();
    	Set<Attrezzo> set2=new HashSet<Attrezzo>();
    	set1.add(attrezzoLeggero);
    	set1.add(attrezzoLeggero2);
    	set2.add(attrezzoPesante);
    	exp.put(attrezzoLeggero.getPeso(), set1);
    	exp.put(attrezzoPesante.getPeso(), set2);
    	borsa.addAttrezzo(attrezzoLeggero);
    	borsa.addAttrezzo(attrezzoLeggero2);
    	borsa.addAttrezzo(attrezzoPesante);
    	assertEquals(exp,borsa.getContenutoRaggruppatoPerPeso());
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
