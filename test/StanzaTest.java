import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Attrezzo;
import it.uniroma3.diadia.Labirinto;
import it.uniroma3.diadia.Stanza;

class StanzaTest {

		Stanza stanza = new Stanza("aula");
		Stanza stanza1 = new Stanza("aula a nord");
		String direzione = "nord";
		Stanza stanzaNulla = null;
		Attrezzo[] attrezzi; //serve?
		int numeroAttrezzi;
		int NUMERO_MASSIMO_ATTREZZI=3;
		Attrezzo sasso=new Attrezzo("sasso", 1);
		Attrezzo forbici=new Attrezzo("forbici", 1);
		Attrezzo carta=new Attrezzo("carta", 1);
		Attrezzo lanterna=new Attrezzo("lanterna", 1);
		Attrezzo osso=new Attrezzo("osso", 1);
	
	
	@Test
	void impostaStanzaAdiacenteDirezioneInesistente() {
		stanza.impostaStanzaAdiacente(direzione, stanza1);
		assertNull(stanza.getStanzaAdiacente("west"));
	}

	@Test
	void impostaStanzaAdiacenteNulla() {
		stanza.impostaStanzaAdiacente(direzione, stanzaNulla);
		assertNull(stanza.getStanzaAdiacente(direzione));
	}

	@Test
	void impostaStanzaAdiacenteNord() {
		stanza.impostaStanzaAdiacente(direzione, stanza1);
		assertEquals(stanza1,stanza.getStanzaAdiacente(direzione));
	}

	
	
	@Test
	void addAttrezzoNumeroMassimoAttrezzi() {
		stanza.addAttrezzo(carta);
		stanza.addAttrezzo(forbici);
		stanza.addAttrezzo(sasso);
		stanza.addAttrezzo(lanterna);
		stanza.addAttrezzo(carta);
		stanza.addAttrezzo(forbici);
		stanza.addAttrezzo(sasso);
		stanza.addAttrezzo(lanterna);
		stanza.addAttrezzo(carta);
		stanza.addAttrezzo(forbici);
		
		assertFalse(stanza.addAttrezzo(osso));
		
	}
	
	@Test
	void addAttrezzoTest() {
		stanza.addAttrezzo(carta);
		assertTrue(stanza.addAttrezzo(osso));
	}
	
	@Test
	void addAttrezzoArrayNullo() {
		assertTrue(stanza.addAttrezzo(osso));
	}
	
	
	
	@Test
	void hasAttrezzoNonPresente() {
		assertFalse(stanza.hasAttrezzo("osso"));
	}
	
	@Test
	void hasAttrezzoUnicoPresente() {
		stanza.addAttrezzo(osso);
		assertTrue(stanza.hasAttrezzo("osso"));
	}
	
	@Test
	void hasAttrezzoGenerico() {
		stanza.addAttrezzo(carta);
		stanza.addAttrezzo(forbici);
		stanza.addAttrezzo(sasso);
		assertTrue(stanza.hasAttrezzo("carta"));
		assertFalse(stanza.hasAttrezzo("osso"));
	}
	
	
	//getAttrezzo
	//removeAttrezzo
	
}
