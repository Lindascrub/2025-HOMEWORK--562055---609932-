package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};

	
	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub

		String listaComandi = "";
		for(int i=0; i< elencoComandi.length; i++) 
			listaComandi += elencoComandi[i]+ " ";
		partita.getIo().mostraMessaggio(listaComandi);
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "aiuto";
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}

}
