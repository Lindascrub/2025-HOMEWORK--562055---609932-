package it.uniroma3.diadia.comandi;

<<<<<<< HEAD
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
// es 12
=======
import it.uniroma3.diadia.*;

import it.uniroma3.diadia.Partita;

>>>>>>> Mariella
public abstract class AbstractComando implements Comando{

	private IO io;
	private String parametro;
	private final static String NOME = "AbstractComando";


	abstract public void esegui(Partita partita);

	@Override
	public String getParametro() {
		return this.parametro;
	}
	
	@Override
	public void setParametro(String parametro) {
		this.parametro  = parametro;
	}

	public void setIo(IO io) {
		this.io = io;
	}

	public IO getIo() {
		return io;
	}

	//for testing purposes
	@Override
	public String getNome() {
		return NOME;
	}
}
<<<<<<< HEAD
=======

>>>>>>> Mariella
