package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {

	private Stanza stanzaBloccata;
	private String direzioneBloccata;
	private Attrezzo attrezzoSbloccante;
	private Stanza stanzaAdiacenteAllaDirBloccata;
	
	
	@BeforeEach
	void setUp() {
		this.direzioneBloccata="sud";
		this.attrezzoSbloccante=new Attrezzo("piede di porco", 0);
		this.stanzaBloccata=new StanzaBloccata("stanza bloccata", attrezzoSbloccante.getNome(), direzioneBloccata);
		this.stanzaAdiacenteAllaDirBloccata=new Stanza("stanza adiacente");
		this.stanzaBloccata.impostaStanzaAdiacente(direzioneBloccata, stanzaAdiacenteAllaDirBloccata);
	}
	
	@Test
	void getStanzaAdiacenteSenzaAttrezzoSbloccante() {
		assertEquals(stanzaBloccata,this.stanzaBloccata.getStanzaAdiacente("sud"));
	}
	
	@Test
	void getStanzaAdiacenteConAttrezzoSbloccante() {
		this.stanzaBloccata.addAttrezzo(attrezzoSbloccante);
		assertEquals(stanzaAdiacenteAllaDirBloccata,this.stanzaBloccata.getStanzaAdiacente(direzioneBloccata));
	}

}
