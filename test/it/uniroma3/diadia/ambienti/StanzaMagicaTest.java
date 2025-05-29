package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaMagicaTest {

	private Stanza stanzaMagica;
	private Attrezzo pala;
	private Attrezzo lanterna;
	private Attrezzo lanternaInvertita;
	
	@BeforeEach
	void setUp() {
		this.stanzaMagica = new StanzaMagica("stanza magica", 1);
		this.pala=new Attrezzo("pala", 1);
		this.lanterna=new Attrezzo("lanterna", 2);
		this.lanternaInvertita=new Attrezzo("anretnal", 4);
	}
	
	
	@Test
	void modificaAttrezzoTestConUnsoloAttrezzoAggiunto() {
		this.stanzaMagica.addAttrezzo(this.lanterna);
		assertEquals(this.lanterna,this.stanzaMagica.getAttrezzi().get(0));
	}

	
	@Test
	void modificaAttrezzoTestConDueAttrezziAggiunti() {
		this.stanzaMagica.addAttrezzo(pala);
		this.stanzaMagica.addAttrezzo(lanterna);
		assertEquals(this.pala,this.stanzaMagica.getAttrezzi().get(0));
		assertEquals(this.lanternaInvertita,this.stanzaMagica.getAttrezzi().get(1));
	}
}
