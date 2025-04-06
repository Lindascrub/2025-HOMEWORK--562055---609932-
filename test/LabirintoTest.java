import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Labirinto;

class LabirintoTest {

	 private Labirinto labirinto;

	    @BeforeEach
	    void setUp() {
	        labirinto = new Labirinto();
	    }

	    @Test
	    void testStanzaInizialeNonNull() {
	        assertNotNull(labirinto.getStanzaIniziale(), "La stanza iniziale non dovrebbe essere null");
	    }
	    
	    @Test
	    void testStanzaVincenteNonNull() {
	        assertNotNull(labirinto.getStanzaVincente(), "La stanza vincente non dovrebbe essere null");
	    }
	    
	    @Test
	    void testStanzaInizialeCorretta() {
	        assertEquals("Atrio", labirinto.getStanzaIniziale().getNome(), "La stanza iniziale dovrebbe essere l'Atrio");
	    }
	    
	    @Test
	    void testStanzaVincenteCorretta() {
	        assertEquals("Biblioteca", labirinto.getStanzaVincente().getNome(), "La stanza vincente dovrebbe essere la Biblioteca");
	    }

}
