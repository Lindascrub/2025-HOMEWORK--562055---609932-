package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IO.IO;

public class ComandoFine implements Comando {

	private IO io;
	private final static String MSG = "fine";
	public final static String MSG_FINE = "Grazie di aver giocato!";


	@Override
	public void esegui(Partita partita) {
		partita.setFinita();
		io.mostraMessaggio(MSG_FINE);  // si desidera smettere

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
