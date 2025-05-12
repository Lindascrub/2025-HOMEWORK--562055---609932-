package it.uniroma3.diadia.comandi;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosaTest {

	private Partita partita;
	private Comando posa;
	private Stanza stanza;
	private Attrezzo osso;
	
	private Labirinto labirinto;
	
	@BeforeEach
	public void setUp() {
		this.stanza=new Stanza("stanza di test");
		this.labirinto=new Labirinto(stanza);
		this.partita=new Partita(new IOConsole(), 0, labirinto);
		this.posa=new ComandoPosa();
		
		
	}
	
	@Test
	void comandoPosaAttrezzoNonCorrispondente() {
		this.osso=new Attrezzo("osso", 0);
		this.partita.getGiocatore().getBorsa().addAttrezzo(osso);
		this.posa.setParametro("lanterna");
		this.posa.esegui(partita);
		assertFalse(this.stanza.hasAttrezzo("osso"));
		assertFalse(this.stanza.hasAttrezzo("lanterna"));
		assertTrue(this.partita.getGiocatore().getBorsa().hasAttrezzo("osso"));
	}

	
	@Test
	void comandoPosaAttrezzoConUnSoloAttrezzo() {
		this.osso=new Attrezzo("osso", 0);
		this.partita.getGiocatore().getBorsa().addAttrezzo(osso);
		this.posa.setParametro("osso");
		this.posa.esegui(partita);
		assertTrue(this.stanza.hasAttrezzo("osso"));
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("osso"));
	}
	
	@Test
	void comandoPosaAttrezzoInesistente() {
		this.posa.setParametro("lanterna");
		this.posa.esegui(partita);
		assertFalse(this.stanza.hasAttrezzo("lanterna"));
	}
}
