package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando {

		static final public String[] ELENCO_COMANDI = {"vai", "aiuto", "fine","prendi", "posa", "guarda","saluta","interagisci","regala"};
		
		private final static String NOME = "aiuto";

		@Override
		public void esegui(Partita partita) {
			for(int i=0; i< ELENCO_COMANDI.length; i++) 
				this.getIo().mostraMessaggio(ELENCO_COMANDI[i]+" ");
			this.getIo().mostraMessaggio("");
		}

		@Override
		public String getNome() {
			return NOME;
		}


/*

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
*/
}
