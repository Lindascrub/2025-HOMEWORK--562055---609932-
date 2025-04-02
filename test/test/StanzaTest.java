package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;


class StanzaTest {
    
    private Stanza stanza;
    private Attrezzo attrezzo;
    
    
    @BeforeEach
    void setUp() {
        stanza = new Stanza("Aula");
        attrezzo = new Attrezzo("Chiave", 1);
      
    }
 
    
    @Test
    void testAddAttrezzo() {
        assertTrue(stanza.addAttrezzo(attrezzo));
        assertEquals(attrezzo, stanza.getAttrezzo("Chiave"));
    }
    
    @Test
    void testHasAttrezzo() {
        stanza.addAttrezzo(attrezzo);
        assertTrue(stanza.hasAttrezzo("Chiave"));
    }
    
    @Test
    void testRemoveAttrezzo() {
        stanza.addAttrezzo(attrezzo);
        assertTrue(stanza.removeAttrezzo(attrezzo));
        assertFalse(stanza.hasAttrezzo("Chiave"));
    }
}