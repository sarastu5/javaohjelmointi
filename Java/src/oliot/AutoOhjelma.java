package oliot;

import java.util.Scanner;

public class AutoOhjelma {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		Auto ekaAuto = new Auto();

		System.out.print("Anna merkki: ");
		ekaAuto.setMerkki(input.nextLine());
		System.out.print("Anna malli: ");
		ekaAuto.setMalli(input.nextLine());
		System.out.print("Anna rekisterinumero: ");
		ekaAuto.setRekno(input.nextLine());
		System.out.print("Anna vuosimalli: ");
		ekaAuto.setVuosimalli(input.nextInt());
		
		System.out.println("Autosi merkki ja malli ovat: " + ekaAuto.getMerkki() + " " + ekaAuto.getMalli());
		System.out.println("Autosi rekisterinumero on: " + ekaAuto.getRekno());
		System.out.println("Autosi ikä on: " + ekaAuto.getIka() + " vuotta");
		
		input.close();
	}
}
