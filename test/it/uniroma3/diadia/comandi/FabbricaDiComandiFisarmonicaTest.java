package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FabbricaDiComandiFisarmonicaTest {

	private FabbricaDiComandiFisarmonica fabbrica;
	
	@BeforeEach
	public void setUp() {
		this.fabbrica=new FabbricaDiComandiFisarmonica();
	}
	
	@Test
	void comandoVuoto() {
		Comando comandoVuoto=this.fabbrica.costruisciComando("");
		assertNotNull(comandoVuoto);
		assertNull(comandoVuoto.getNome());
		assertNull(comandoVuoto.getParametro());
	}
	
	@Test
	void comandoPosaSenzaParametro() {
		Comando comando=this.fabbrica.costruisciComando("posa");
		assertNotNull(comando);
		assertEquals("posa",comando.getNome());
		assertNull(comando.getParametro());
	}
	
	@Test
	void comandoPosaConParametro() {
		Comando comando=this.fabbrica.costruisciComando("posa osso");
		assertNotNull(comando);
		assertEquals("posa",comando.getNome());
		assertEquals("osso",comando.getParametro());
	}
	
}
