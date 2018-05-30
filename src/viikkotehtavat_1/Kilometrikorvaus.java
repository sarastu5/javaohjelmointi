import java.text.DecimalFormat;
import java.util.Scanner;

public class Kilometrikorvaus {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		DecimalFormat des = new DecimalFormat("0.00");
		
		int kilometrit = 0;
		int syotetytKilometrit = 0;
		double kilometrikorvaus = 0;
		
		do {
			System.out.println("Anna ajetut kilometrit (0 lopettaa): ");
			syotetytKilometrit = input.nextInt();
			
			kilometrit = kilometrit + syotetytKilometrit;
		} while (syotetytKilometrit != 0);
		
		kilometrikorvaus = 0.43 * kilometrit;
		
		System.out.println("Yhteensä " + kilometrit + " kilometriä. \nKorvaus on " + des.format(kilometrikorvaus) + "euroa");
	}

}
