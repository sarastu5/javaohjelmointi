package list_map_periytyminen;

import java.util.ArrayList;
import java.util.Scanner;

public class SanalistaSovellus {
	private Scanner input = new Scanner(System.in);
	private ArrayList<String> sanat = new ArrayList<String>();
	
	public SanalistaSovellus() {
		naytaValikko();
	}
	
	private void naytaValikko() {
		System.out.println("1 = lis‰‰ sana");
		System.out.println("2 = listaa sanat");
		System.out.println("3 = laske sanan esiintymiskerrat");
		System.out.println("4 = poista sana");
		System.out.println("0 = lopeta");
		System.out.print("Anna valintasi: ");
		int valinta = input.nextInt();
		
		switch (valinta) {
		case 1:
			lisaaSana();
			break;
		case 2:
			listaaSanat();		
			break;
		case 3:
			laskeSanat();
			break;
		case 4:
			poistaSana();
			break;
		case 0:
			System.exit(0);
			break;
	
		default:
			System.out.println("Luku ei kelpaa!\n");
			break;
		}
		naytaValikko();
	}
	
	private void lisaaSana() {
		System.out.print("Anna sana: ");
		sanat.add(input.next());
	}
	
	private void listaaSanat() {
		for (int i=0; i<sanat.size(); i++) {
			System.out.println(sanat.get(i));
		}
	}
	
	private void laskeSanat() {
		int lkm = 0;
		System.out.print("Anna sana, mink‰ esiintymiskerrat lasketaan: ");
		String sana = input.next();
		for (int i=0; i<sanat.size(); i++) {
			if (sanat.get(i).equalsIgnoreCase(sana)) {
				lkm++;
			}
		} 
		System.out.println("Sana " + sana + " esiintyi " + lkm + " kertaa.\n");
	}

	private void poistaSana() {
		int lkm = 0; 
		System.out.println("Anna sana, joka poistetaan: ");
		String sana = input.next();
		for (int i=0; i<sanat.size(); i++) {
			if (sanat.get(i).equalsIgnoreCase(sana)) {
				sanat.remove(i);
				i--;
				lkm++;
			}
		}
		
		if (lkm == 0) {
			System.out.println("Sanaa " + sana + " ei ollut listalla.");
		} else {
			System.out.println("Jokainen sana " + sana + " on poistettu listasta.");
		}
	}

	public static void main(String[] args) {
		new SanalistaSovellus();

	}

}
