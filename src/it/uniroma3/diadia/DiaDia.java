package it.uniroma3.diadia;

import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

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

	public DiaDia(IOConsole ioConsole) {
		this.partita = new Partita();
		this.ioConsole = ioConsole;
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
		Comando comandoDaEseguire;

		FabbricaDiComandiFisarmonica factory= new FabbricaDiComandiFisarmonica();
		
		comandoDaEseguire=factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita);
		if(this.partita.vinta()) {
			System.out.println("Hai vinto!");
		}
		if(!this.partita.giocatoreIsVivo()) {
			System.out.println("Hai esaurito i CFU...");
		}
		return this.partita.isFinita();
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		String listaComandi = "";
		for(int i=0; i< elencoComandi.length; i++) 
			listaComandi += elencoComandi[i]+ " ";
		this.ioConsole.mostraMessaggio(listaComandi);
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			this.ioConsole.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			this.ioConsole.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu--);
		}
		this.ioConsole.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		this.ioConsole.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	private void prendi(String nomeAttrezzo) {
		if( nomeAttrezzo == null) {
			this.ioConsole.mostraMessaggio("Che attrezzo vuoi prendere?\nAttrezzo inesistente!\n");
		}
		//se {
		Stanza stanzaCorrente = this.partita.getStanzaCorrente();
		if (!stanzaCorrente.hasAttrezzo(nomeAttrezzo)) {
			this.ioConsole.mostraMessaggio("Che attrezzo vuoi prendere?\n");
		}
		else {
			Attrezzo attrezzoPreso = stanzaCorrente.getAttrezzo(nomeAttrezzo);
			if(this.partita.getGiocatore().prendereAttrezzo(attrezzoPreso)) {
				stanzaCorrente.removeAttrezzo(attrezzoPreso);

			}
			else {
				this.ioConsole.mostraMessaggio("La borsa è piena!");
			}
		}


		this.ioConsole.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}

	private void posa(String nomeAttrezzo) {
		if( nomeAttrezzo == null) {
			this.ioConsole.mostraMessaggio("Che attrezzo vuoi posare?\nAttrezzo inesistente!\n");
		}
		else {
			Stanza stanzaCorrente = this.partita.getStanzaCorrente();
			if (!this.partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
				this.ioConsole.mostraMessaggio("Che attrezzo vuoi posare?\n");
			}
			else {
				Attrezzo attrezzoPosato = this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
				if(attrezzoPosato != null) {
					this.partita.getGiocatore().getBorsa().removeAttrezzoBorsa(nomeAttrezzo);
					stanzaCorrente.addAttrezzo(attrezzoPosato);

				}
				else {
					this.ioConsole.mostraMessaggio("La borsa è vuota!");
				}
			}
		}
		this.ioConsole.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}






	public static void main(String[] argc) {
		IOConsole ioConsole = new IOConsole();
		DiaDia gioco = new DiaDia(ioConsole);
		gioco.gioca();
		
	}
}