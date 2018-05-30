package list_map_periytyminen;

import java.util.Scanner;

public class TyontekijaOhjelma {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
	
		Tyontekija tyontekija = new Tyontekija();
		
		System.out.print("Anna nimi: ");
		String nimi = input.nextLine();
		tyontekija.setNimi(nimi);
		System.out.print("Anna osoite: ");
		String osoite = input.nextLine();
		tyontekija.setOsoite(osoite);
		System.out.print("Anna tuntipalkka: ");
		double tuntipalkka = input.nextDouble();
		tyontekija.setTuntipalkka(tuntipalkka);
		System.out.println("");
		
		System.out.println("Nimi: " + tyontekija.getNimi());
		System.out.println("Osoite: " + tyontekija.getOsoite());
		System.out.println("Tuntipalkka: " + tyontekija.getTuntipalkka());
		
		input.close();
	}

}
