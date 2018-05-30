package oliot;

public class Henkilo {
	private String nimi, osoite;
	private Koko koko; //voidaan k‰ytt‰‰ itse tekem‰‰ luokkaa attribuuttina
	//yhteyssuhde, koska miss‰‰n ei sanota t‰‰ll‰ "new Koko"

	public Henkilo() { //new Henkilo(); <- oletuskonstruktori
		//t‰‰ll‰ ei v‰ltt‰m‰tt‰ ole mit‰‰n sis‰ll‰
	}

	public Henkilo(String nimi, String osoite) { //<- parametrillinen konstruktori, new Henkilo("matti", "katu10")
		this.nimi = nimi;
		this.osoite = osoite;
	}
	
	public Henkilo(String nimi) { // <- parametrillinen konstruktori, new Henkilo("matti")
		this.nimi = nimi;
	}

	public String getNimi() {
		return nimi; //voisi lukea return this.nimi;
	}

	public void setNimi(String nimi) { 
		this.nimi = nimi; //j‰lkimm‰inen nimi viittaa parametriin
	}

	public String getOsoite() {
		return osoite;
	}

	public void setOsoite(String osoite) {
		this.osoite = osoite;
	}

	@Override
	public String toString() {
		return "Henkilo [nimi=" + nimi + ", osoite=" + osoite + ", koko=" + koko + "]";
	}

	public Koko getKoko() {
		return koko;
	}

	public void setKoko(Koko koko) { //t‰lle pit‰‰ v‰litt‰‰ Koko-luokan olio
		this.koko = koko;
	}

	public Henkilo(String nimi, String osoite, Koko koko) {
		super();
		this.nimi = nimi;
		this.osoite = osoite;
		this.koko = koko;
	}	
}
