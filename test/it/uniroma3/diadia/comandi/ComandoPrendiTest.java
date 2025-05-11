package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class ComandoPrendiTest {

	private Partita partita;
	private Comando prendi;
	private Stanza stanza;
	private Attrezzo attrezzo;
	
	private Labirinto labirinto;
	
	@BeforeEach
	public void setUp() {
		this.stanza=new Stanza("stanza di test");
		this.labirinto=new Labirinto(stanza);
		this.partita=new Partita(0, labirinto);
		this.prendi=new ComandoPrendi();
		
		
	}
	
	
	@Test
	void comandoPrendiAttrezzoInesistente() {
		this.prendi.setParametro("osso");
		this.prendi.esegui(partita);
		assertFalse(this.stanza.hasAttrezzo("osso"));
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("osso"));
	}
	
	
	@Test
	void comandoPrendiAttrezzoEsistente() {
		this.attrezzo=new Attrezzo("osso", 0);
		this.stanza.addAttrezzo(attrezzo);
		this.prendi.setParametro("osso");
		this.prendi.esegui(partita);
		assertFalse(this.stanza.hasAttrezzo("osso"));
		assertTrue(this.partita.getGiocatore().getBorsa().hasAttrezzo("osso"));
	}
	
	@Test
	void comandoPrendiAttrezzoEsistenteDueAttrezzi() {
		this.attrezzo=new Attrezzo("osso", 0);
		Attrezzo pala=new Attrezzo("pala", 0);
		this.stanza.addAttrezzo(attrezzo);
		this.stanza.addAttrezzo(pala);
		this.prendi.setParametro("osso");
		this.prendi.esegui(partita);
		assertFalse(this.stanza.hasAttrezzo("osso"));
		assertTrue(this.stanza.hasAttrezzo("pala"));
		assertTrue(this.partita.getGiocatore().getBorsa().hasAttrezzo("osso"));
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("pala"));
	}
}
