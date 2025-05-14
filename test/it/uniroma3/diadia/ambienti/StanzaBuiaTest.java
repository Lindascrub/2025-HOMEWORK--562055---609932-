package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {

	private Stanza stanzaBuia;
	private Attrezzo attrezzoNecessario;
	
	
	@BeforeEach
	void setUp() {
		this.stanzaBuia = new StanzaBuia("stanza buia", "torcia");
	}
	
	@Test
	void stanzaBuiaSenzaAttrezzoNecessario() {
		assertEquals("qui c'è buio pesto",this.stanzaBuia.getDescrizione());
	}
	
	@Test
	void stanzaBuiaConAttrezzoNecessario() {
		this.stanzaBuia.addAttrezzo(attrezzoNecessario);
		String res=this.stanzaBuia.toString();
		assertEquals(res,this.stanzaBuia.toString());
	}

}
