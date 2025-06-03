package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.*;
import java.util.Scanner;
//19-20 18-18

		public class FabbricaDiComandiRiflessiva implements FabbricaDiComandi {
			public FabbricaDiComandiRiflessiva(IO io) {
				// TODO Auto-generated constructor stub
			}

			public Comando costruisciComando(String istruzione) throws Exception {
			Scanner scannerDiParole = new Scanner(istruzione); // es. ‘vai sud’
			String nomeComando = null; // es. ‘vai’
			String parametro = null; // es. ‘sud’
			Comando comando = null;
			if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next();//prima parola: nome del comando
			if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next();//seconda parola: eventuale parametro
			StringBuilder nomeClasse

			= new StringBuilder("it.uniroma3.diadia.comandi.Comando");
			nomeClasse.append( Character.toUpperCase(nomeComando.charAt(0)) );
			// es. nomeClasse: ‘it.uniroma3.diadia.comandi.ComandoV’
			nomeClasse.append( nomeComando.substring(1) ) ;
			// es. nomeClasse: ‘it.uniroma3.diadia.comandi.ComandoVai’
			comando = (Comando)Class.forName(nomeClasse.toString()).newInstance();
			// POSSIBILE ALTERNATIVA basata sul rendere il tipo Class<Comando> esplicito:
			// comando = ((Class<Comando>)Class.forName(nomeClasse.toString())).newInstance();
			comando.setParametro(parametro);
			return comando;
			}