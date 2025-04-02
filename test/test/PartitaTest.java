
package test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;



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

