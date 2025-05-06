package it.uniroma3.diadia.IO;

public class IOSimulator implements IO {

	private String[] righeLette;
	private int indexRigheLette;

	public String[] getMessaggiProdotti() {
		return messaggiProdotti;
	}

	public void setMessaggiProdotti(String[] messaggiProdotti) {
		this.messaggiProdotti = messaggiProdotti;
	}

	private String[] messaggiProdotti;
	private int indexMessaggiProdotti;
	private int indexMessaggiMostrati;

	public IOSimulator(String[] righeDaLeggere) {
		this.righeLette = righeDaLeggere;
		this.indexRigheLette = 0;
		this.indexMessaggiMostrati = 0;
		this.messaggiProdotti = new String[42*23];
	}

	@Override
	public String leggiRiga() {
		String riga = null;
		riga = this.righeLette[indexRigheLette];
		this.indexRigheLette++;
		return riga;
	}

	@Override
	public void mostraMessaggio(String msg) {
		this.messaggiProdotti[indexMessaggiProdotti] = msg;
		this.indexMessaggiProdotti++;
	}

	public String nextMessaggio() {
		String next = this.messaggiProdotti[this.indexMessaggiMostrati];
		this.indexMessaggiMostrati++;
		return next;
	}

	public boolean hasNextMessaggio() {
		return (this.indexMessaggiMostrati < this.indexMessaggiProdotti);
	}

}

