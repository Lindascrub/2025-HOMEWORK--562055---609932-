package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;

public class Strega extends AbstractPersonaggio {

	/*se interagiamo con una strega, questa ci "trasferisce" in una stanza
	 * tra quelle adiacenti. Siccome è permalosa: 
	 * 	-se non l'abbiamo ancora salutata, ci trasferisce nella stanza adiacente
	 * 	che contiene meno attrezzi
	 * 	-altrimenti in quella che contiene più attrezzi
	 */
	
	public Strega(String nome, String presentaz) {
		super(nome, presentaz);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String agisci(Partita partita) {
		// TODO Auto-generated method stub
		return null;
	}

}
