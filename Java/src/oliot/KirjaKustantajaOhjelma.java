package oliot;

public class KirjaKustantajaOhjelma {

	public static void main(String[] args) {
		
		Kustantaja kustantaja = new Kustantaja("HH Kustannus", "Helsinki", "050-1234567");
		Kirja kirja = new Kirja("Javaa helposti", "1234567-1", 12.90);
		
		System.out.println("Kirjan nimi: " + kirja.getNimi());
		System.out.println("Kirjan ISBN: " + kirja.getIsbn());
		System.out.println("Kirjan hinta: " + kirja.getHinta());
		System.out.println("Kustantajan nimi: " + kustantaja.getNimi());
		System.out.println("Kustantajan osoite: " + kustantaja.getOsoite());
		System.out.println("Kustantajan puhelin: " + kustantaja.getPuhelin());
		System.out.println("Kirjan " + kirja.getNimi() + " kustantaja on " + kustantaja.getNimi());
	}

}
