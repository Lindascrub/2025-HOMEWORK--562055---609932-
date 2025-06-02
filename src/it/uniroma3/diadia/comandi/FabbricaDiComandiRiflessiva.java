package it.uniroma3.diadia.comandi;

import java.util.Scanner;

public class FabbricaDiComandiRiflessiva implements FabbricaDiComandi {
	
	@SuppressWarnings("unchecked")
	public Comando costruisciComando(String istruzione) throws Exception {
		
		Scanner scannerDiParole=new Scanner(istruzione);
		String nomeComando=null;
		String parametro=null;
		Comando comando=null;
		
		if(scannerDiParole.hasNext())
			nomeComando=scannerDiParole.next();
		if(scannerDiParole.hasNext())
			parametro=scannerDiParole.next();
		
		StringBuilder nomeClasse=new StringBuilder("it.uniroma3.diadia.comandi.Comando");
		nomeClasse.append(Character.toUpperCase(nomeComando.charAt(0)));
		nomeClasse.append(nomeComando.substring(1));
		comando=((Class<Comando>)Class.forName(nomeClasse.toString())).newInstance();
		comando.setParametro(parametro);
		return comando;
	}

}
