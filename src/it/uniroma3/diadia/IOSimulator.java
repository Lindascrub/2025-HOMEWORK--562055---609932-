package it.uniroma3.diadia;

public class IOSimulator implements IO {

	private String[] comandi;
	private String[] messaggi;
	private int comandoCorrente;
	private int messaggioCorrente;
	
	public IOSimulator(String[] inputComandi, String[] output) {
		this.messaggi=output; 
		this.comandi=inputComandi;
		this.comandoCorrente=0;
		this.messaggioCorrente=0;
	}
	
	
	
	public String[] getComandi() {
		return comandi;
	}



	public void setComandi(String[] comandi) {
		this.comandi = comandi;
	}



	public String[] getMessaggi() {
		return messaggi;
	}



	public void setMessaggi(String[] messaggi) {
		this.messaggi = messaggi;
	}



	public int getComandoCorrente() {
		return comandoCorrente;
	}



	public void setComandoCorrente(int comandoCorrente) {
		this.comandoCorrente = comandoCorrente;
	}



	public int getMessaggioCorrente() {
		return messaggioCorrente;
	}



	public void setMessaggioCorrente(int messaggioCorrente) {
		this.messaggioCorrente = messaggioCorrente;
	}



	@Override
	public void mostraMessaggio(String messaggio) {
		// TODO Auto-generated method stub
		if(messaggioCorrente<messaggi.length) {
			messaggi[messaggioCorrente]=messaggio;
			messaggioCorrente++;
		}
		
		
	}

	@Override
	public String leggiRiga() {
		// TODO Auto-generated method stub
		if(comandoCorrente<comandi.length) {
			String riga=comandi[comandoCorrente];
			comandoCorrente++;
			return riga;
		}
		return "fine";
	}

}
