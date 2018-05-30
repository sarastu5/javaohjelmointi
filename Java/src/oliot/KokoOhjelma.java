package oliot;

import java.text.DecimalFormat;
import java.util.Scanner;

public class KokoOhjelma { //käyttää olio-luokkaa hyödykseen

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		DecimalFormat des = new DecimalFormat("0.00");

		Koko koko = new Koko(); //olion luonti parametrittomalla konstruktorilla
		
		System.out.print("Anna pituus metreinä: ");
		koko.setPituus(input.nextDouble());
		System.out.print("Anna paino kiloina: ");
		koko.setPaino(input.nextInt());
		System.out.println("Pituus: " + koko.getPituus());
		System.out.println("Paino: " + koko.getPaino());
		System.out.println("Painoideksi: " + des.format(koko.getPainoindeksi()));
		
		input.close();
	}

}
