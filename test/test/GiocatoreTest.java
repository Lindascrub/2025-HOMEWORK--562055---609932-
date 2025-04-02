package test;



import static org.junit.jupiter.api.Assertions.*;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GiocatoreTest {
    
    private Giocatore giocatore;
    private Attrezzo attrezzo;
    
    @BeforeEach
    void setUp() {
        giocatore = new Giocatore();
        attrezzo = new Attrezzo("Spada", 3);
    }
    
    @Test
    void testCfuIniziali() {
        assertEquals(3, giocatore.getCfu());
    }
 
    
    @Test
    void testPrendereAttrezzo() {
        assertTrue(giocatore.prendereAttrezzo(attrezzo));
        assertNotNull(giocatore.getBorsa().getAttrezzo("Spada"));
    }
    
    @Test
    void testPosareAttrezzo() {
        giocatore.prendereAttrezzo(attrezzo);
        giocatore.posareAttrezzo("Spada");
        assertNull(giocatore.getBorsa().getAttrezzo("Spada"));
    }
}