package it.uniroma3.diadia;

import java.util.Scanner;

public class IOConsole {
	
	private static IOConsole ioConsole;
	
	public void mostraMessaggio(String msg) {
		System.out.println(msg);
	}
	
	public String leggiRiga() {
		Scanner scannerDiLinee = new Scanner(System.in);
		String riga = scannerDiLinee.nextLine();
		//scannerDiLinee.close();
		return riga;
	}
	
	public static IOConsole getIOConsole() {
		if (ioConsole == null) {
			ioConsole = new IOConsole();
		}
		return ioConsole;
	}
	
}
