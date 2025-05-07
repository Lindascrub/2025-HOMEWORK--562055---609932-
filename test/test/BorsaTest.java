
package test;

import static org.junit.jupiter.api.Assertions.*;


import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;


public class BorsaTest {

	Borsa b = new Borsa();
	Attrezzo falce;
	Attrezzo sega;
	
	@Before
	public void setUp() {
		falce = new Attrezzo("falce", 2);
		sega = new Attrezzo("sega", 16);
	}

	@Test
	public void testAddAttrezzoPesoMinoreDiDieci() {
		assertTrue(b.addAttrezzo(falce));

	}
	
	@Test
	public void testAddAttrezzoPesoMaggioreDiDieci() {
		assertFalse(b.addAttrezzo(sega));

	}
	
	@Test
	public void testGetPeso() {
		b.addAttrezzo(falce);
		assertEquals(falce, b.getAttrezzo("falce"));

	}
}
