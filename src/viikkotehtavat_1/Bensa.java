import java.text.DecimalFormat;
import java.util.Scanner;

public class Bensa {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		DecimalFormat des = new DecimalFormat("0.00");
		
		double litrat = 0;
		int kilometrit = 0;
		double litrahinta = 0;
		double hinta = 0.0;
		
		System.out.print("Anna tankattu määrä: ");
		litrat = input.nextDouble();
		System.out.print("Anna ajetut kilometrit: ");
		kilometrit = input.nextInt();
		System.out.print("Anna litrahinta: ");
		litrahinta = input.nextDouble();

		hinta = (litrahinta*litrat)/kilometrit;
		System.out.println("Ajo per kilometri maksaa " + des.format(hinta));
	}

}
