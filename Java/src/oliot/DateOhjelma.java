package oliot;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateOhjelma {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Date nyt = new Date();
		//alla olevalla saadaan muutettua Date-olio Stringiksi
		SimpleDateFormat fdate = new SimpleDateFormat("yyy-MM-dd"); //pieni m tarkoittaa minuuttia
		System.out.println("T‰n‰‰n on " + fdate.format(nyt));
		fdate = new SimpleDateFormat("H");
		int tunnit = Integer.parseInt(fdate.format(nyt));

		if (tunnit < 12) {
			System.out.println("On aamup‰iv‰.");
		} else {
			System.out.println("On iltap‰iv‰.");
		}
		
		System.out.print("Anna syntym‰vuotesi: ");
		int sVuosi = input.nextInt();
		fdate = new SimpleDateFormat("yyy");
		int ika = Integer.parseInt(fdate.format(nyt)) - sVuosi;
		System.out.print("T‰yt‰t/olet t‰ytt‰nyt t‰n‰ vuonna " + ika);
		
		System.out.print("Anna p‰iv‰m‰‰r‰ muodossa pp/kk/vvv: ");
		String pvm = input.nextLine();
		fdate = new SimpleDateFormat("dd/MM/yyy"); //pakottaa virheenhallintaan
		Date uusi = null; 
		try {
			uusi = fdate.parse(pvm);
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		
		System.out.println(uusi);
		
		input.close();
		
	}
}
