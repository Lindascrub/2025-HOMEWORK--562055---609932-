package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IO.IO;

public class ComandoNonValido implements Comando {

	private IO io;
	private final static String MSG = "non valido";

	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio("Comando non valido");
	}


	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setIo(IO io) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return MSG;
	}

}
