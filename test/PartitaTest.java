import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Giocatore;
import it.uniroma3.diadia.Labirinto;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.Stanza;

class PartitaTest {

	private Partita partita;

	@BeforeEach
	void setUp() {
		partita = new Partita();
	}

	@Test
	void testPartitaNonFinitaAllInizio() {
		assertFalse(partita.isFinita());
	}

	@Test
	void testSetStanzaCorrente() {
		Stanza nuovaStanza = new Stanza("Biblioteca");
		partita.setStanzaCorrente(nuovaStanza);
		assertEquals(nuovaStanza, partita.getStanzaCorrente());
	}

	@Test
	void testPartitaFinitaQuandoSetFinita() {
		partita.setFinita();
		assertTrue(partita.isFinita());
	}

}
