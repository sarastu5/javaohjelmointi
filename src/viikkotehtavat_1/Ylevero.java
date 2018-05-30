import java.text.DecimalFormat;
import java.util.Scanner;

public class Ylevero {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		DecimalFormat des = new DecimalFormat("0.00");
		
		int vuositulo = 0;
		int ika = 0;
		double ylevero = 0.0068;
		double tulos = 0.00;
		
		System.out.print("Anna vuositulosi: ");
		vuositulo = input.nextInt();
		System.out.print("Anna ikäsi: ");
		ika = input.nextInt();
		
		if (vuositulo <= 7353 || ika < 18) {
			System.out.println("Ylevero on 0,00.");
		} else {
			tulos = vuositulo * ylevero;
			if (tulos > 140){
				System.out.println("Ylevero on 140,00.");
			} else {
				System.out.println("Ylevero on " + des.format(tulos));
			}
		}
	}

}
