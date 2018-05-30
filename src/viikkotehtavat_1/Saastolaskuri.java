import java.text.DecimalFormat;
import java.util.Scanner;

public class Saastolaskuri {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		DecimalFormat des = new DecimalFormat("0.00");
		
		double saastotavoite = 0;
		int kuukaudet = 0;
		double kuukausisaasto = 0.00;
		double kokonaissaasto = 0.00;
		
		System.out.print("Anna säästötavoite: ");
		saastotavoite = input.nextDouble();
		System.out.print("Anna kuukausien lukumäärä: ");
		kuukaudet = input.nextInt();
		
		kuukausisaasto = saastotavoite/(double)kuukaudet;
		
		for (int i=0; i<kuukaudet; i++ ) {
			kokonaissaasto += kuukausisaasto;
			System.out.print((i+1) + ". kuukausi " + des.format(kuukausisaasto) + " euroa");
			System.out.print(", säästösumma " + des.format(kokonaissaasto) + " euroa.\n");
		}
		input.close();
	}

}