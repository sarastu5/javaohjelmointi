package list_map_periytyminen;

import java.util.ArrayList;
import java.util.Scanner;

import oliot.Henkilo;
import oliot.Koko;

public class HenkiloListaSovellus {

	Scanner input = new Scanner(System.in);
	Scanner input2 = new Scanner(System.in);
	Scanner input3 = new Scanner(System.in);
	Scanner input4 = new Scanner(System.in);
	ArrayList<Henkilo> henkilot = new ArrayList<Henkilo>();

	public HenkiloListaSovellus() {
		naytaValikko();
	}
	
	private void naytaValikko() {
		System.out.println("1 = Lisää henkilö");
		System.out.println("2 = Näytä henkilön tiedot");
		System.out.println("3 = Muuta henkilön nimi ja osoite");
		System.out.println("4 = Muuta henkilön koko");
		System.out.println("5 = Näytä kaikki henkilöt");
		System.out.println("0 = Lopetus");
		System.out.print("Anna valintasi (0-5): ");
		int valinta = input2.nextInt();
		
		switch (valinta) {
		case 1:
			lisaaHenkilo();
			break;
		case 2:
			naytaHenkilonTiedot();		
			break;
		case 3:
			muutaNimiJaOsoite();
			break;
		case 4:
			muutaKoko();
			break;
		case 5:
			naytaKaikkiHenkilot();
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
	
	private void lisaaHenkilo() {
		System.out.print("Anna nimi: ");
		String nimi = input.nextLine();
		System.out.print("Anna osoite: ");
		String osoite = input.nextLine();
		System.out.print("Anna pituus: ");
		double pituus = input3.nextDouble();
		System.out.println("Anna paino: ");
		int paino = input4.nextInt();
		
		Henkilo uusi = new Henkilo(nimi, osoite);
		Koko koko = new Koko();
		koko.setPituus(pituus);
		koko.setPaino(paino);
		uusi.setKoko(koko);
		
		henkilot.add(uusi);
	}

	private void naytaHenkilonTiedot() {
		System.out.print("Anna näytettävän henkilön nimi: ");
		String nimi = input.nextLine();
		boolean henkiloLoytyi = false; 
		
		for (int i=0; i<henkilot.size(); i++) {
			if (henkilot.get(i).getNimi().equalsIgnoreCase(nimi)) {
				Henkilo tuloste = henkilot.get(i);
				System.out.println("Nimi: " + tuloste.getNimi());
				System.out.println("Osoite: " + tuloste.getOsoite());
				System.out.println("Pituus: " + tuloste.getKoko().getPituus());
				System.out.println("Painoindeksi: " + tuloste.getKoko().getPainoindeksi());
				
				henkiloLoytyi = true;
			}
		}
		if (henkiloLoytyi == false) {
			System.out.println("Henkilöä ei ole.");
		}
	}

	private void muutaNimiJaOsoite() {
		System.out.print("Anna perustietoja muutettavan henkilön nimi: ");
		String nimi = input.nextLine();
		boolean henkiloLoytyi = false; 
		
		for (int i=0; i<henkilot.size(); i++) {
			if (henkilot.get(i).getNimi().equalsIgnoreCase(nimi)) {
				System.out.print("Anna nimi: ");
				String uusiNimi = input.nextLine();
				System.out.print("Anna osoite: ");
				String uusiOsoite = input.nextLine();
				
				henkilot.get(i).setNimi(uusiNimi);
				henkilot.get(i).setOsoite(uusiOsoite);
				
				henkiloLoytyi = true; 
			}
			
			if (henkiloLoytyi == false) {
				System.out.println("Henkilöä ei ole.");
			}
		}	
	}

	private void muutaKoko() {
		System.out.print("Anna kokoa muuttettavan henkilön nimi: ");
		String nimi = input.nextLine();
		boolean henkiloLoytyi = false; 
		
		for (int i=0; i<henkilot.size(); i++) {
			if (henkilot.get(i).getNimi().equalsIgnoreCase(nimi)) {
				System.out.print("Anna pituus: ");
				double uusiPituus = input.nextDouble();
				System.out.print("Anna paino: ");
				int uusiPaino = input.nextInt();
				
				henkilot.get(i).getKoko().setPituus(uusiPituus);
				henkilot.get(i).getKoko().setPaino(uusiPaino);
				
				henkiloLoytyi = true; 
			}
			
			if (henkiloLoytyi == false ) {
				System.out.println("Henkilöä ei ole.");
			}
		}
	}

	private void naytaKaikkiHenkilot() {
		for (int i=0; i<henkilot.size(); i++) {
			Henkilo tiedot = henkilot.get(i);
			System.out.println("Nimi: " + tiedot.getNimi());
			System.out.println("Osoite: " + tiedot.getOsoite());
			System.out.println("Pituus: " + tiedot.getKoko().getPituus());
			System.out.println("Painoindeksi: " + tiedot.getKoko().getPainoindeksi());
		}	
	}

	public static void main(String[] args) {
		new HenkiloListaSovellus();
	}
}
