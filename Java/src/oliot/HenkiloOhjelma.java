package oliot;

import java.util.Scanner;

public class HenkiloOhjelma {

	public static void main(String[] args) {
		Henkilo ekaHlo = new Henkilo();

		Scanner input = new Scanner(System.in);
		// a)
		System.out.print("Anna nimi: ");
		ekaHlo.setNimi(input.nextLine());
		System.out.print("Anna osoite: ");
		ekaHlo.setOsoite(input.nextLine());
		
		System.out.println("Nimi:" + ekaHlo.getNimi());
		System.out.println("Osoite: " + ekaHlo.getOsoite());
		
		// b)
		System.out.print("Anna nimi: ");
		String nimi = input.nextLine();
		System.out.print("Anna osoite: ");
		String osoite = input.nextLine();
		Henkilo tokaHlo = new Henkilo(nimi, osoite);
		System.out.println(tokaHlo);
		
		/*
		ekaHlo.setKoko(new Koko(1.65,58)); //luodaan suoraan uusi luokka parametriin
		System.out.println(ekaHlo.getKoko().getPaino());
		*/
		
		Koko toka = new Koko();
		System.out.print("Anna pituus: ");
		toka.setPituus(Double.parseDouble(input.nextLine()));
		System.out.print("Anna paino: ");
		toka.setPaino(Integer.parseInt(input.nextLine()));
		tokaHlo.setKoko(toka);
		System.out.println(tokaHlo.getKoko());
	}

}
