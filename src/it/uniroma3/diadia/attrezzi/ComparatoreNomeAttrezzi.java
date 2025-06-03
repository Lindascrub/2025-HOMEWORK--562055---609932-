package it.uniroma3.diadia.attrezzi;

import java.util.Comparator;

public class ComparatoreNomeAttrezzi implements Comparator<Attrezzo> {

	@Override
	public int compare(Attrezzo o1, Attrezzo o2) {
		// TODO Auto-generated method stub
		return o1.getNome().compareTo(o2.getNome());
	}

}
