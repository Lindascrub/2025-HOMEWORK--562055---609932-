package it.uniroma3.diadia;




import java.util.Scanner;

/**
 * Questa classe modella un comando.
 * Un comando consiste al piu' di due parole:
 * il nome del comando ed un parametro
 * su cui si applica il comando.
 * (Ad es. alla riga digitata dall'utente "vai nord"
 *  corrisponde un comando di nome "vai" e parametro "nord").
 *
 * @author  docente di POO
 * @version base
 */

public interface Comando {

	public void esegui(Partita partita);
	public void setParametro(String parametro);
   /* private String nome;
    private String parametro;
	private Scanner scannerDiParole;
	

    public Comando(String istruzione) {
		scannerDiParole = new Scanner(istruzione);

		// prima parola: nome del comando
		if (scannerDiParole.hasNext())
			this.nome = scannerDiParole.next(); 

		// seconda parola: eventuale parametro
		if (scannerDiParole.hasNext())
			this.parametro = scannerDiParole.next();
	
    }

    public String getNome() {
        return this.nome;
    }

    public String getParametro() {
        return parametro;
    }


    public boolean sconosciuto() {
        return (this.nome == null);
    }*/
}