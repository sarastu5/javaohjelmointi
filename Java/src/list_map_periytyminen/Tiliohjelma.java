package list_map_periytyminen;

import java.util.ArrayList;

public class Tiliohjelma {

	public static void main(String[] args) {
		ArrayList<Tili> tilit = new ArrayList<Tili>();
		
		Tili eka = new Tili("FI123", 1000);
		tilit.add(eka);
		tilit.add(new Tili("FI234", 2000));
		Tili joku = new Tili();
		joku.setNumero("FI345");
		joku.setSaldo(3000);
		tilit.add(joku);
		
		for (int i=0; i<tilit.size(); i++) {
			System.out.println(tilit.get(i));
		}
		Tili.setKorkoprosentti(0.3);
		
		for (int i=0; i<tilit.size(); i++) {
			System.out.println(tilit.get(i));
		}
		System.out.println(tilit.get(1).getSaldo());
	}

}
