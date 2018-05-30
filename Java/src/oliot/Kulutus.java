package oliot;

import java.util.Scanner;

public class Kulutus {
	
	private Scanner input = new Scanner(System.in);
	
	public Kulutus() {
		int kilometrit = kysyKilometrit();
		int litrat = kysyLitrat();
		double kulutus = laskeKulutus(kilometrit, litrat);
		naytaKulutus(kulutus);
	}
	
	public int kysyKilometrit() {
		System.out.print("Anna ajetut kilometrit: ");
		int kilometrit = input.nextInt();
		return kilometrit;
	}
	
	public int kysyLitrat() {
		System.out.print("Anna kulunut polttoainem‰‰r‰: ");
		int litrat = input.nextInt();
		return litrat;
	}
	
	public double laskeKulutus(int km, int litrat) {
		double kokonaiskulutus = (litrat*1.0/km)*100;
		return kokonaiskulutus;
	}
	
	public void naytaKulutus(double kulutus) {
		System.out.println("Kulutus /100 km on " + kulutus + " litraa.");
	}

	public static void main(String[] args) {
		new Kulutus();

	}
	
	

}
