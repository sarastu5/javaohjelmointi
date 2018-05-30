package tietokantaohjelmointi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HaeAutot {	
	private Lukija lukija = new Lukija();
	private Connection con=null; //yhteysobjekti
	private ResultSet rs = null; //tietueobjekti
	private PreparedStatement stmtPrep=null; //käytetään sql-lauseen rakentamiseen
	private String sql; //varsinainen sql-lause
	
	public HaeAutot(){
		naytaValikko();
	}
	
	private void naytaValikko() {
		System.out.println("1. Näytä kaikki autot");
		System.out.println("2. Lisää auto");
		System.out.println("3. Muuta auto");
		System.out.println("4. Poista auto");
		System.out.println("0. Lopeta");
		switch (lukija.lueKokonaisluku("Valintasi: ")) {
		case 1:
			listaaAutot();
			break;
		case 2:
			lisaaAuto();
			break;
		case 3:
			muutaAuto();
			break;
		case 4:
			poistaAuto();
			break;
		case 0:
			System.exit(0);
			break;
		default:
			System.out.println("Väärä valinta!");
			break;
		}
		naytaValikko();		
	}
	
	private void listaaAutot() {
		sql = "SELECT * FROM autot";       
		try {
			con=yhdista(); //yhdista() on metodi alempana
			if(con!=null) { //jos yhteys onnistui
				stmtPrep = con.prepareStatement(sql);        		
        		rs = stmtPrep.executeQuery(); //toteuttaa tietokantakyselyn  
				if(rs!=null) { //jos kysely onnistui
					con.close(); //yhteys kiinni, koska yhteyttä ei enää tarvita
					System.out.println();
					while(rs.next()) { //tee niin kauan kuin result setistä löytyy tavaraa
						System.out.print(rs.getString(1) +"\t"); 
						System.out.print(rs.getString(2)+"\t");
						System.out.print(rs.getString(3)+"\t");	
						System.out.println();
					}
					System.out.println();
				}				
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}

	private void lisaaAuto() {
		String rekisterinumero = lukija.lueTeksti("Anna uuden auton rekisterinumero: ");
		String merkki = lukija.lueTeksti("Anna uuden auton merkki: ");
		String malli = lukija.lueTeksti("Anna uuden auton malli: ");
		String vuosimalli = lukija.lueTeksti("Anna uuden auton vuosimalli: ");
		if (rekisterinumero.length()>1 && merkki.length()>1 && malli.length()>1 && vuosimalli.length()>1) {
			sql="INSERT INTO autot VALUES(?,?,?,?)"; //ajaa sql:n insert-lausekkeen
			try {
				con = yhdista();
				stmtPrep=con.prepareStatement(sql); 
				stmtPrep.setString(1, rekisterinumero);
				stmtPrep.setString(2, merkki);
				stmtPrep.setString(3, malli);
				stmtPrep.setString(4, vuosimalli);
				stmtPrep.executeUpdate(); //ajaa tietokantapäivityksen
		        con.close(); //sulkee yhteyden
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}		
		
	}

	private void muutaAuto() {
		listaaAutot();
		String rekisterinumero = lukija.lueTeksti("Anna muutettavan auton rekisterinumero: ");
		sql = "SELECT * FROM autot WHERE rekno=?";       
		try {
			con=yhdista();
			if(con != null) { //jos yhteys onnistui
				stmtPrep = con.prepareStatement(sql); 
				stmtPrep.setString(1, rekisterinumero);
        		rs = stmtPrep.executeQuery(); //ajaa kyselyn
        		if(rs.isBeforeFirst()) { //jos kysely tuotti dataa, eli id on käytössä
        			String merkki = lukija.lueTeksti("Anna uuden auton merkki: ");
        			String malli = lukija.lueTeksti("Anna uuden auton malli: ");
        			String vuosimalli = lukija.lueTeksti("Anna uuden auton vuosimalli: ");
        			if(merkki.length()>1 && malli.length()>1 && vuosimalli.length()>1) {
        				sql="UPDATE autot SET merkki=?, malli=?, vuosi=? WHERE rekno=?";	//update-lauseke        				
    					stmtPrep=con.prepareStatement(sql); 
    					stmtPrep.setString(1, merkki);
    					stmtPrep.setString(2, malli);
    					stmtPrep.setString(3, vuosimalli);
    					stmtPrep.setString(4, rekisterinumero);
    					stmtPrep.executeUpdate(); 
        			}
        			con.close();
        			listaaAutot();
				} else {
					System.out.println("Antamasi rekisterinumero ei ole käytössä!\n");
				}				
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
	}
	
	private void poistaAuto() {
		listaaAutot();
		String rekisterinumero = lukija.lueTeksti("Anna poistettavan auton rekisterinumero: ");
		sql = "SELECT * FROM autot WHERE rekno=?";       
		try {
			con=yhdista();
			if(con!=null) { //jos yhteys onnistui
				stmtPrep = con.prepareStatement(sql); 
				stmtPrep.setString(1, rekisterinumero);
        		rs = stmtPrep.executeQuery();  
        		if(rs.isBeforeFirst()) { //jos kysely tuotti dataa, eli id on käytössä
        			rs.next(); //siirrytään 1. tietueriville
        			if(lukija.lueTeksti("Haluatko varmasti poistaa auton "
        					+ rs.getString("rekno") + " " + rs.getString("merkki") + " " + rs.getString("malli") + " " + rs.getString("vuosi")
        					+ "(k/e): ").equalsIgnoreCase("k")) {
        				sql="DELETE FROM autot WHERE rekno=?";	        				
    					stmtPrep=con.prepareStatement(sql);     					
    					stmtPrep.setString(1, rekisterinumero);
    					stmtPrep.executeUpdate(); 
        			}       			
        			con.close();
        			listaaAutot();
				} else {
					System.out.println("Antamasi id ei ole käytössä!\n");
				}				
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	private Connection yhdista(){ //piuha kiinni!
    	Connection tietokantayhteys = null;    	        	
    	String JDBCAjuri = "org.mariadb.jdbc.Driver";
    	String url = "jdbc:mariadb://localhost:15001/a1602823";   	
    	try {
	         Class.forName(JDBCAjuri);
	         tietokantayhteys = DriverManager.getConnection(url,"a1602823", "doVEn057e");	        
	     }catch (Exception e){
	    	 e.printStackTrace();	
	     }
	     return tietokantayhteys; //palauttaa onnistuneen tietokantayhteyden tai null
	}
	
	public static void main(String[] args) {		
		new HaeAutot();		
    }	
}
