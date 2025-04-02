package test;

import static org.junit.jupiter.api.Assertions.*;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BorsaTest {
    
    private Borsa borsa;
    private Attrezzo attrezzoLeggero;
    private Attrezzo attrezzoPesante;
    
    @BeforeEach
    void setUp() {
        borsa = new Borsa(10);
        attrezzoLeggero = new Attrezzo("Torcia", 2);
        attrezzoPesante = new Attrezzo("Incudine", 15);
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
    
}

