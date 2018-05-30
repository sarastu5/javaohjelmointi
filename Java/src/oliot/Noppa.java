package oliot;

import java.util.Random;

public class Noppa {

		private int silmaluku; //attribuutti
		
		public Noppa() { //konstruktori
			heita();
		}
		
		public void heita() {
			Random r = new Random();
			this.silmaluku = r.nextInt(6)+1;
		}

		public int getSilmaluku() {
			return silmaluku;
		}
}
