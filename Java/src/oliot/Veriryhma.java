package oliot;

import java.util.Scanner;

public class Veriryhma {
	
	private Scanner input = new Scanner(System.in);
	
	public Veriryhma() {
		String[] veriryhmat = kysyVeriryhma();
		tulostaVeriryhma(veriryhmat);
	}
	
	private String[] kysyVeriryhma() {
		//A+, A-, O-, O+, AB+, AB-, B- ja B+
		String[] veriryhmat = new String[1000];
		String veriryhma = "";
	
		for (int i=0; i<veriryhmat.length; i++) {
			System.out.print("Anna veriryhm� (- lopettaa): ");
			veriryhma = input.nextLine();
			veriryhmat[i] = veriryhma;
			
			if (veriryhma.equals("-")) {
				break;
			} 
		}
		return veriryhmat;
	}
	
	private void tulostaVeriryhma(String[] veriryhmat) {
		int lkm = 0;
		int kaikki = 0;
		System.out.print("Mink� veriryhm�n luovutusten m��r�n haluat tiet��?: ");
		String vastaus = input.nextLine();
		
		for (int i=0; i<veriryhmat.length; i++) {
			if (vastaus.equalsIgnoreCase(veriryhmat[i])) {
				lkm++;
			}
		}
		
		for (int i=0; i<veriryhmat.length; i++) {
			if (veriryhmat[i].equals("-")) {
				kaikki = i;
				break;
			}
		}
		
		System.out.println("Luovutuksia oli yhteens� " + kaikki + ".");
		System.out.println("Veriryhm�n " + vastaus.toUpperCase() + " luovutuksia oli " + lkm + ".");
	}

	public static void main(String[] args) {
		new Veriryhma();

	}
}
