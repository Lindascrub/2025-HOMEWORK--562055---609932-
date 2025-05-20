package it.uniroma3.diadia;

public class IOSimulator implements IO {

	private String[] inputDaLeggere;
	private String[] messaggiStampati;
	private int contatore;
	
	public IOSimulator(String[] input) {
		this.inputDaLeggere=input;
		this.messaggiStampati=new String[6];
	}
	
	@Override
	public void mostraMessaggio(String messaggio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String leggiRiga() {
		// TODO Auto-generated method stub
		return null;
	}

}
