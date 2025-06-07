package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.io.StringReader;

class CaricatoreLabirintoTest {
	
	@Test
	public void testLabirintoMonolocale() throws Exception {
        String monolocale = 
                "Stanze:\n" +
                "N10\n" +
                "Estremi:\n" +
                "N10\n" +
                "N10\n";

        CaricatoreLabirinto caricatore = new CaricatoreLabirinto(new StringReader(monolocale));
        caricatore.carica();
        Labirinto labirinto = caricatore.getLabirinto();

        assertEquals("N10", labirinto.getStanzaIniziale().getNome());
        assertEquals("N10", labirinto.getStanzaVincente().getNome());
    }

	@Test
    public void testLabirintoBilocaleConAdiacenza() throws Exception {
        String bilocale = 
                "Stanze:\n" +
                "N10 Biblioteca\n" +
                "Estremi:\n" +
                "N10\n" +
                "Biblioteca\n" +
                "Uscite:\n" +
                "N10 nord Biblioteca\n" +
                "Biblioteca sud N10\n";

        CaricatoreLabirinto caricatore = new CaricatoreLabirinto(new StringReader(bilocale));
        caricatore.carica();
        Labirinto labirinto = caricatore.getLabirinto();

        Stanza n10 = labirinto.getStanzaIniziale();
        assertEquals("Biblioteca", n10.getStanzaAdiacente("nord").getNome());

        Stanza biblioteca = labirinto.getStanzaVincente();
        assertEquals("N10", biblioteca.getStanzaAdiacente("sud").getNome());
    }

    @Test
    public void testAttrezzoPresente() throws Exception {
        String input = 
                "Stanze:\n" +
                "N10\n" +
                "Estremi:\n" +
                "N10\n" +
                "N10\n" +
                "Attrezzi:\n" +
                "Osso 5 N10\n";

        CaricatoreLabirinto caricatore = new CaricatoreLabirinto(new StringReader(input));
        caricatore.carica();
        Labirinto labirinto = caricatore.getLabirinto();

        Stanza n10 = labirinto.getStanzaIniziale();
        assertTrue(n10.hasAttrezzo("Osso"));
        assertEquals(5, n10.getAttrezzo("Osso").getPeso());
    }
	
}
