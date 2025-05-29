package it.uniroma3.diadia.giocatore;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;

class GiocatoreTest {

	 	private Giocatore giocatore;
	    private Attrezzo attrezzo;
	    static final private int CFU_INIZIALI = 3;
		
	   
	    
	    @BeforeEach
	    void setUp() {
	        attrezzo = new Attrezzo("Spada", 3);
	        giocatore=new Giocatore();
	        this.giocatore.setCfu(CFU_INIZIALI);
	    }
	    
	    @Test
	    void testCfuIniziali() {
	        assertEquals(CFU_INIZIALI, giocatore.getCfu());
	    }
	

}
