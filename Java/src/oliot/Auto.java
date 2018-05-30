package oliot;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Auto {
	
	private String merkki, malli, rekno;
	private int vuosimalli;
	Date nyt = new Date();
	SimpleDateFormat fdate = new SimpleDateFormat("yyyy");
	private int ika;
	
	public Auto() {
		
	}
	
	public Auto(String merkki, String malli, String rekno, int vuosimalli) {
		this.merkki = merkki;
		this.malli = malli;
		this.rekno = rekno;
		this.vuosimalli = vuosimalli;
	}
	
	public String getMalli() {
		return malli;
	}
	public void setMalli(String malli) {
		this.malli = malli;
	}
	public String getMerkki() {
		return merkki;
	}
	public void setMerkki(String merkki) {
		this.merkki = merkki;
	}
	public String getRekno() {
		return rekno;
	}
	public void setRekno(String rekno) {
		this.rekno = rekno;
	}
	public int getVuosimalli() {
		return vuosimalli;
	}
	public void setVuosimalli(int vuosimalli) {
		this.vuosimalli = vuosimalli;
	}
	
	public int getIka() {
		ika = Integer.parseInt(fdate.format(nyt)) - vuosimalli;
		return ika;
	}
	@Override
	public String toString() {
		return "Auto [malli=" + malli + ", merkki=" + merkki + ", rekno=" + rekno + ", vuosimalli=" + vuosimalli + "]";
	}
	
	

}
