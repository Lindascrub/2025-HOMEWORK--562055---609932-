package it.uniroma3.diadia;

public class IOSimulator implements IO {

	private String[] comandi;
	private String[] messaggi;
	private int comandoCorrente;
	private int messaggioCorrente;
	
	public IOSimulator(String[] inputComandi) {
		this.comandi=inputComandi;
		this.comandoCorrente=0;
	}
	
	@Override
	public void mostraMessaggio(String messaggio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String leggiRiga() {
		// TODO Auto-generated method stub
		String riga=comandi[comandoCorrente];
		comandoCorrente++;
		return riga;
	}

}
