package oliot;

public class Koko { //ensin attribuutit kasaan, tämä on olio-luokka
	private double pituus;
	private int paino;
	
	public Koko() { //oletuskonstruktori
		super();
		
	}

	public double getPituus() {
		return pituus;
	}

	public void setPituus(double pituus) {
		this.pituus = pituus;
	}

	public int getPaino() {
		return paino;
	}

	public void setPaino(int paino) {
		this.paino = paino;
	}

	@Override
	public String toString() {
		return "Koko [pituus=" + pituus + ", paino=" + paino + "]";
	}
	
	public double getPainoindeksi() {
		return paino / Math.pow(pituus, 2); //laskee eksponentin
	}
	
	
}
