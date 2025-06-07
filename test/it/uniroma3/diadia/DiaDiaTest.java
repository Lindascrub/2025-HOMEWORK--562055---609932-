package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DiaDiaTest {

	private IOSimulator io;
	private DiaDia diadia;
	
	
	@Test
	void test() {
		List<String> output = new ArrayList<String>();
		List<String> comandi = new ArrayList<>();
		comandi.add("aiuto");
		comandi.add("vai sud");
		comandi.add("prendi lanterna");
		this.io=new IOSimulator(comandi,output);
		this.diadia=new DiaDia(this.io);
		this.diadia.gioca();
	    for(int i=0;i<output.size();i++) {
	    	if(output.get(i)!=null)
	    		System.out.println(output.get(i));
	    }
		
	}

}
