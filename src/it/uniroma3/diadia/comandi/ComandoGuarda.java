package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends AbstractComando {
<<<<<<< HEAD

	private final static String NOME = "guarda";

=======
>>>>>>> Mariella

	private final static String NOME = "guarda";
	
	@Override
	public void esegui(Partita partita) {
		this.getIo().mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		this.getIo().mostraMessaggio("Hai ancora: "+partita.getGiocatore().getCfu()+ "CFU");
		this.getIo().mostraMessaggio(partita.getGiocatore().getBorsa().toString());
<<<<<<< HEAD

	}

	@Override
	public String getNome() {
		return NOME;
	}
}

/*


	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

	@Override
=======
	}
	
>>>>>>> Mariella
	public String getNome() {
		return NOME;
	}

<<<<<<< HEAD
	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}
*/
=======

}
>>>>>>> Mariella
