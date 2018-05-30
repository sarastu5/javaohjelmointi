package oliot;

public class Kustantaja {
	
	private String nimi, osoite, puhelin;

	public Kustantaja() {

	}

	public Kustantaja(String nimi, String osoite, String puhelin) {
		this.nimi = nimi;
		this.osoite = osoite;
		this.puhelin = puhelin;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getOsoite() {
		return osoite;
	}

	public void setOsoite(String osoite) {
		this.osoite = osoite;
	}

	public String getPuhelin() {
		return puhelin;
	}

	public void setPuhelin(String puhelin) {
		this.puhelin = puhelin;
	}

	@Override
	public String toString() {
		return "Kustantaja [nimi=" + nimi + ", osoite=" + osoite + ", puhelin=" + puhelin + "]";
	}
}
