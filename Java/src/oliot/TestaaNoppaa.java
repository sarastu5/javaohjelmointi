package oliot;

public class TestaaNoppaa {

	public static void main(String[] args) {
		
		Noppa ekaNoppa = new Noppa();
		
		System.out.println(ekaNoppa.getSilmaluku());
		ekaNoppa.heita();
		System.out.println(ekaNoppa.getSilmaluku());
		
		Noppa tokaNoppa = new Noppa(); //ei ole mit‰‰n tekemist‰ ekaNopan kanssa
		System.out.println(tokaNoppa.lueSilmaluku());
	}

}
