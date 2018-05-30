import java.util.Random;
import java.util.Scanner;

public class RandomTest {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int noppa = 0;
		int numerokuusi = 0;
		
		Random r = new Random();
		
		for (int i=0; i<10000; i++) {
			noppa = r.nextInt(6) + 1; //noppa saa arvon 1-6
			if (noppa == 6) {
				numerokuusi++;
			}
		}
		
		if (numerokuusi > 1500 && numerokuusi < 1833) {
			System.out.println("Numero 6 tuli " + numerokuusi + " kertaa.");
			System.out.println("Satunnaisgeneraattori toimii oletetusti.");
		} else {
			System.out.println("Numero 6 tuli " + numerokuusi + " kertaa.");
			System.out.println("Satunnaisgeneraattori ei toimi oletetusti.");
		}
		
	}

}
