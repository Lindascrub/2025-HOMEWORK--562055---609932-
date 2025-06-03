package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DiaDiaTest {

	private IOSimulator io;
	private DiaDia diadia;
	
	
	@Test
	void test() {
		String[] output=new String[1024];
		String[] comandi= {"aiuto", "vai sud", "prendi lanterna"};
		this.io=new IOSimulator(comandi,output);
		this.diadia=new DiaDia(this.io);
		this.diadia.gioca();
	    for(int i=0;i<output.length;i++) {
	    	if(output[i]!=null)
	    		System.out.println(output[i]);
	    }
		
	}

}
