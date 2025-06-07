package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public abstract class AbstractComando implements Comando {

	private String parametro;
	protected IO io;
	
	 /*per eliminare i metodi replicati
	 nelle implementazioni dell’interface Comando e relativi alla
	 gestione del nome e del parametro del comando
	 Utilizzarla anche per ospitare l’oggetto IO per la gestione
	 dell’input/output. Come offrire l’accesso alle sottoclassi?*/
	
	public void setParametro(String parametro) {
		this.parametro=parametro;
	}
	
	public String getParametro() {
		return this.parametro;
	}
	
	public void setIo(IO io) {
		this.io=io;
	}
	
	public IO getIo() {
		return this.io;
	}
	
	@Override
	public abstract void esegui(Partita partita);
	
	public abstract String getNome();
	
}
