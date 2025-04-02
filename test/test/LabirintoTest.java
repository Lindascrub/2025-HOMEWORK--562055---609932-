package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;

class LabirintoTest {
    
    private Labirinto labirinto;
    
    @BeforeEach
    void setUp() {
        labirinto = new Labirinto();
    }
    
    @Test
    void testStanzaIniziale() {
        assertNotNull(labirinto.getStanzaIniziale());
        assertEquals("Atrio", labirinto.getStanzaIniziale().getNome());
    }
    
    @Test
    void testStanzaVincente() {
        assertNotNull(labirinto.getStanzaVincente());
        assertEquals("Biblioteca", labirinto.getStanzaVincente().getNome());
    }
}
