import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Labirinto;
import it.uniroma3.diadia.Stanza;

class StanzaTest {

		Stanza stanza = new Stanza("aula");
		Stanza stanza1 = new Stanza("aula a nord");
		String direzione = "nord";
		Stanza stanzaNulla = null;
	
	
	
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

	
	
	
	
}
