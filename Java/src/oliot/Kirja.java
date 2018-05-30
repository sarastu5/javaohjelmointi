package oliot;

public class Kirja {

	private String nimi, isbn;
	private double hinta;
	private Kustantaja kustantaja;
	
	public Kirja(String nimi, String isbn, double hinta) {
		super();
		this.nimi = nimi;
		this.isbn = isbn;
		this.hinta = hinta;
	}

	public Kirja() {
	
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getHinta() {
		return hinta;
	}

	public void setHinta(double hinta) {
		this.hinta = hinta;
	}

	public Kirja(Kustantaja kustantaja) {
		super();
		this.kustantaja = kustantaja;
	}

	public Kustantaja getKustantaja() {
		return kustantaja;
	}

	public void setKustantaja(Kustantaja kustantaja) {
		this.kustantaja = kustantaja;
	}
	
	@Override
	public String toString() {
		return "Kirja [kustantaja=" + kustantaja + "]";
	}
}
