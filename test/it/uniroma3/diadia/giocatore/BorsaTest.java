package it.uniroma3.diadia.giocatore;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class BorsaTest {

	private Borsa borsa;
    private Attrezzo attrezzoLeggero;
    private Attrezzo attrezzoPesante;
    private Attrezzo attrezzoMedio;
    
    @BeforeEach
    void setUp() {
        borsa = new Borsa(10);
        attrezzoLeggero = new Attrezzo("Torcia", 2);
        attrezzoPesante = new Attrezzo("Incudine", 15);
        attrezzoMedio = new Attrezzo("pala", 4);
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
}
