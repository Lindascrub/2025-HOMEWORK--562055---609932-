package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando {
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa", "guarda", "borsa"};

	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub

		String listaComandi = "";
		for(int i=0; i< elencoComandi.length; i++) 
			listaComandi += elencoComandi[i]+ " ";
		partita.getIo().mostraMessaggio(listaComandi);
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "aiuto";
	}

}
