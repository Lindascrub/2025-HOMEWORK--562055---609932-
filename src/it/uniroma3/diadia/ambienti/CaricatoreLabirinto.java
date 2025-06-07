package it.uniroma3.diadia.ambienti;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CaricatoreLabirinto {

	private String nomeFile;
	private LabirintoBuilder builder;

	public CaricatoreLabirinto(String nomeFile) {
		this.nomeFile = nomeFile;
		this.builder = new LabirintoBuilder();
	}

	public void carica() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(this.nomeFile));
		String linea;

		while ((linea = reader.readLine()) != null) {
			if (linea.startsWith("Stanze:")) {
				String[] stanze = linea.substring(7).trim().split(" ");
				for (String nomeStanza : stanze)
					builder.addStanza(nomeStanza);
			} else if (linea.startsWith("Inizio:")) {
				String stanzaIniziale = linea.substring(7).trim();
				builder.addStanzaIniziale(stanzaIniziale);
			} else if (linea.startsWith("Vincente:")) {
				String stanzaVincente = linea.substring(9).trim();
				builder.addStanzaVincente(stanzaVincente);
			} else if (linea.startsWith("Attrezzi:")) {
				String[] tokens = linea.substring(9).trim().split(" ");
				for (int i = 0; i < tokens.length; i += 3) {
					String nome = tokens[i];
					int peso = Integer.parseInt(tokens[i + 1]);
					String stanza = tokens[i + 2];
					builder.addStanza(stanza); // assicurati che esista
					builder.addAttrezzo(nome, peso);
				}
			} else if (linea.startsWith("Adiacenze:")) {
				String[] tokens = linea.substring(10).trim().split(" ");
				for (int i = 0; i < tokens.length; i += 3) {
					String origine = tokens[i];
					String direzione = tokens[i + 1];
					String destinazione = tokens[i + 2];
					builder.addAdiacenza(origine, destinazione, direzione);
				}
			}
		}
		reader.close();
	}

	public Stanza getStanzaIniziale() {
		return this.builder.getLabirinto().getStanzaIniziale();
	}

	public Stanza getStanzaVincente() {
		return this.builder.getLabirinto().getStanzaVincente();
	}
	
}
