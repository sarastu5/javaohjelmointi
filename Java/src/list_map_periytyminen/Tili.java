package list_map_periytyminen;

public class Tili {

	private static double korkoprosentti = 0.2;
	private String numero;
	private double saldo;
	
	public Tili() {
		numero = "";
		saldo = 0.0;
	}

	public Tili(String numero, double saldo) {
		super();
		this.numero = numero;
		this.saldo = saldo;
	}

	public static double getKorkoprosentti() {
		return korkoprosentti;
	}

	public static void setKorkoprosentti(double korkoprosentti) {
		Tili.korkoprosentti = korkoprosentti;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
}
