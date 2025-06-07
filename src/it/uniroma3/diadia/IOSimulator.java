package it.uniroma3.diadia;

import java.util.List;

public class IOSimulator implements IO {

	private List<String> comandi;
	private List<String> messaggi;
	private int comandoCorrente;
	private int messaggioCorrente;
	
	public IOSimulator(List<String> inputComandi, List<String> output) {
		this.messaggi=output; 
		this.comandi=inputComandi;
		this.comandoCorrente=0;
		this.messaggioCorrente=0;
	}
	
	
	
	public List<String> getComandi() {
		return comandi;
	}



	public void setComandi(List<String> comandi) {
		this.comandi = comandi;
	}



	public List<String> getMessaggi() {
		return messaggi;
	}



	public void setMessaggi(List<String> messaggi) {
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
		if(messaggioCorrente<messaggi.size()) {
			messaggi.set(messaggioCorrente, messaggio);
			messaggioCorrente++;
		}
		
		
	}

	@Override
	public String leggiRiga() {
		// TODO Auto-generated method stub
		if(comandoCorrente<comandi.size()) {
			String riga=comandi.get(comandoCorrente);
			comandoCorrente++;
			return riga;
		}
		return "fine";
	}

}
