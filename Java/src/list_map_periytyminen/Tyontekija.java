package list_map_periytyminen;

import oliot.Henkilo;
import oliot.Koko;

public class Tyontekija extends Henkilo {
	
	private String nimi, osoite;
	private double tuntipalkka;

	public Tyontekija() {
		super();
	}

	public Tyontekija(String nimi, String osoite, double tuntipalkka) {
		super();
		this.nimi = nimi;
		this.osoite = osoite;
		this.tuntipalkka = tuntipalkka;
	}

	public double getTuntipalkka() {
		return tuntipalkka;
	}

	public void setTuntipalkka(double tuntipalkka) {
		this.tuntipalkka = tuntipalkka;
	}

	@Override
	public String toString() {
		return "Tyontekija [tuntipalkka=" + tuntipalkka + "]";
	}
	
	

}
