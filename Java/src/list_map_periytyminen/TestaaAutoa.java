package list_map_periytyminen;

public class TestaaAutoa {

	public static void main(String[] args) {
		Auto auto = new Auto();
		auto.setMerkki("BMW");
		auto.setMalli("X3");
		System.out.println(auto);
		
		KuormaAuto kAuto = new KuormaAuto();
		kAuto.setMerkki("Volvo");
		kAuto.setMalli("F75");
		kAuto.setKantavuus(15000);
		System.out.println(kAuto);
	}

}
