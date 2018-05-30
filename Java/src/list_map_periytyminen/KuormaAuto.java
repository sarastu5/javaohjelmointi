package list_map_periytyminen;

public class KuormaAuto extends Auto { //pit‰‰ sis‰ll‰‰n kaiken, mit‰ Auto-luokka pit‰‰ sis‰ll‰‰n
	private int kantavuus;

	public KuormaAuto() {
		super(); //kutsuu Auto-luokan oletuskonstruktoria, jossa on "yleinen yliluokka"
	}

	public KuormaAuto(String merkki, String malli) {
		super(merkki, malli); //kutsutaan Auto-luokan parametrillista konstruktoria
	}

	public KuormaAuto(int kantavuus) {
		super();
		this.kantavuus = kantavuus;
	}

	public KuormaAuto(String merkki, String malli, int kantavuus) {
		super(merkki, malli); //kutsutaan Auto-luokan parametrillista konstruktoria
		this.kantavuus = kantavuus;
	}

	public int getKantavuus() {
		return kantavuus;
	}

	public void setKantavuus(int kantavuus) {
		this.kantavuus = kantavuus;
	}

	@Override
	public String toString() {
		return "KuormaAuto [kantavuus=" + kantavuus + ", toString()=" + super.toString() + "]";
		//super.toString kutsuu suoraan Auto-luokan stringi‰
	}
	
	 
}
