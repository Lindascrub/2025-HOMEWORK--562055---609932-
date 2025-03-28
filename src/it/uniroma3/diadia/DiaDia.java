package it.uniroma3.diadia;


/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */



public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};

	private Partita partita;
	private IOConsole ioConsole; 
	
	public DiaDia() {
		this.partita = new Partita();
		this.ioConsole = new IOConsole();
	}
	
	
	public void gioca() {
		String istruzione; 
		ioConsole.mostraMessaggio(MESSAGGIO_BENVENUTO);		
		do		
			istruzione = ioConsole.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
		
		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if (comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else
			ioConsole.mostraMessaggio("Comando sconosciuto");
		if (this.partita.vinta()) {
			ioConsole.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:
	
	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			ioConsole.mostraMessaggio(elencoComandi[i]);
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			ioConsole.mostraMessaggio("Dove vuoi andare ?");	//considera le opzioni
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			ioConsole.mostraMessaggio("Direzione inesistente! ");		//se non esiste la direzione
		else {
			this.partita.setStanzaCorrente(prossimaStanza);				//esiste la direzione si muove
			int cfu = this.partita.getCfu();
			this.partita.setCfu(cfu--);
		}
		ioConsole.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());		//descrizione
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		ioConsole.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}
	/* 
	 * Comando "Prendi".
	 */
	private void prendi(String nomeAttrezzo) {
		if( nomeAttrezzo == null) {
			ioConsole.mostraMessaggio("Che attrezzo vuoi prendere? ");	//considerazione delle opzioni
		}
		else {
			Stanza stanzaCorrente = this.partita.getStanzaCorrente();	
				if (!stanzaCorrente.hasAttrezzo(nomeAttrezzo)) {
					ioConsole.mostraMessaggio("Che attrezzo vuoi prendere?\nAttrezzo non presente nella stanza!");	//attrezzo sbagliato o non esistente nella stanza
		 }
		 else {
			 Attrezzo attrezzoPreso = stanzaCorrente.getAttrezzo(nomeAttrezzo);
			 if(this.partita.getGiocatore().prendereAttrezzo(attrezzoPreso)) {
				 stanzaCorrente.removeAttrezzo(attrezzoPreso);			
				 ioConsole.mostraMessaggio("Hai preso " + attrezzoPreso);			//attrezzo preso
		}
		else {
			ioConsole.mostraMessaggio("La borsa è piena!");
				}
		}
		ioConsole.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());	//descrizione
		}
	
	
	/*
	 * Comando "Posa"
	 */
	
	
	private void posa(String nomeAttrezzo) {
		if( nomeAttrezzo == null) {
			ioConsole.mostraMessaggio("Che attrezzo vuoi posare?\nAttrezzo inesistente!\n");	// attrezzo inesistente
		}
		else {
			Stanza stanzaCorrente = this.partita.getStanzaCorrente();
		 if (!this.partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
			 ioConsole.mostraMessaggio("Che attrezzo vuoi posare?\n");				//scelta delle opzioni ++metti opzioni 
			 
		 }
		 else {
		 Attrezzo attrezzoPosato = this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		if(attrezzoPosato != null) {
			this.partita.getGiocatore().getBorsa().removeAttrezzoBorsa(nomeAttrezzo);
			stanzaCorrente.addAttrezzo(attrezzoPosato);
			ioConsole.mostraMessaggio("Hai posato " + nomeAttrezzo);
			
		}
		else {
			ioConsole.mostraMessaggio("La borsa è vuota!");							//priva di oggetti
				}
		 	}
		}
		ioConsole.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		}

			
		
	
	
	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}