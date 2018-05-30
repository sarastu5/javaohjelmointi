package list_map_periytyminen;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import oliot.Henkilo;
import oliot.Koko;

public class HenkiloMapSovellus {
	
	Scanner input = new Scanner(System.in);
	Scanner input2 = new Scanner(System.in);
	Scanner input3 = new Scanner(System.in);
	Scanner input4 = new Scanner(System.in);
	
	HashMap<String, Henkilo> henkilot = new HashMap<String, Henkilo>();
	
	public HenkiloMapSovellus() {
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
		
		henkilot.put(nimi, uusi);
	}

	private void naytaHenkilonTiedot() {
		System.out.print("Anna näytettävän henkilön nimi: ");
		String nimi = input.nextLine();
		boolean henkiloLoytyi = false; 

		Set<String> hlot = henkilot.keySet();
		
		Iterator<String> i = hlot.iterator();
		
		String seurHlo = null;
		Henkilo seuraavaHlo = null;
		
		while (i.hasNext()) {
			seurHlo = i.next(); //avain hashmapiin
			seuraavaHlo = henkilot.get(seurHlo); //haetaan henkilö avaimen perusteella
			
			if (seuraavaHlo.getNimi().equalsIgnoreCase(nimi)) {
				System.out.println("Nimi: " + seuraavaHlo.getNimi());
				System.out.println("Osoite: " + seuraavaHlo.getOsoite());
				System.out.println("Pituus: " + seuraavaHlo.getKoko().getPituus());
				System.out.println("Painoindeksi: " + seuraavaHlo.getKoko().getPainoindeksi());
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
		
		Set<String> hlot = henkilot.keySet();
		
		Iterator<String> i = hlot.iterator();
		
		String seurHlo = null;
		Henkilo seuraavaHlo = null;
		
		while (i.hasNext()) {
			seurHlo = i.next(); //avain hashmapiin
			seuraavaHlo = henkilot.get(seurHlo); //haetaan henkilö avaimen perusteella
			
			if (seuraavaHlo.getNimi().equalsIgnoreCase(nimi)) {
				System.out.print("Anna nimi: ");
				String uusiNimi = input.nextLine();
				System.out.print("Anna osoite: ");
				String uusiOsoite = input.nextLine();
				
				seuraavaHlo.setNimi(uusiNimi);
				seuraavaHlo.setOsoite(uusiOsoite);
				
				henkiloLoytyi = true; 
			}
		}	
			
		if (henkiloLoytyi == false) {
			System.out.println("Henkilöä ei ole.");
		}	
	}

	private void muutaKoko() {
		System.out.print("Anna kokoa muuttettavan henkilön nimi: ");
		String nimi = input.nextLine();
		boolean henkiloLoytyi = false;
		
		Set<String> hlot = henkilot.keySet();
		
		Iterator<String> i = hlot.iterator();
		
		String seurHlo = null;
		Henkilo seuraavaHlo = null;
		
		while (i.hasNext()) {
			seurHlo = i.next(); //avain hashmapiin
			seuraavaHlo = henkilot.get(seurHlo); //haetaan henkilö avaimen perusteella
			
			if (seuraavaHlo.getNimi().equalsIgnoreCase(nimi)) {
				System.out.print("Anna pituus: ");
				double uusiPituus = input.nextDouble();
				System.out.print("Anna paino: ");
				int uusiPaino = input.nextInt();
				
				seuraavaHlo.getKoko().setPituus(uusiPituus);
				seuraavaHlo.getKoko().setPaino(uusiPaino);
				
				henkiloLoytyi = true; 
			}
		}	
		
		if (henkiloLoytyi == false ) {
			System.out.println("Henkilöä ei ole.");
		}
	}

	private void naytaKaikkiHenkilot() {
		
		Set<String> hlot = henkilot.keySet();
		
		Iterator<String> i = hlot.iterator();
		
		String seurHlo = null;
		Henkilo seuraavaHlo = null;
		
		while (i.hasNext()) {
			seurHlo = i.next(); //avain hashmapiin
			seuraavaHlo = henkilot.get(seurHlo); //haetaan henkilö avaimen perusteella
			
			System.out.println("Nimi: " + seuraavaHlo.getNimi());
			System.out.println("Osoite: " + seuraavaHlo.getOsoite());
			System.out.println("Pituus: " + seuraavaHlo.getKoko().getPituus());
			System.out.println("Painoindeksi: " + seuraavaHlo.getKoko().getPainoindeksi());
		}
	}

	public static void main(String[] args) {
		new HenkiloListaSovellus();

	}
}
