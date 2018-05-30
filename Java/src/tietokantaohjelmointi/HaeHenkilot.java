package tietokantaohjelmointi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HaeHenkilot {	
	private Lukija lukija = new Lukija();
	private Connection con=null; //yhteysobjekti
	private ResultSet rs = null; //tietueobjekti
	private PreparedStatement stmtPrep=null; //k�ytet��n sql-lauseen rakentamiseen
	private String sql; //varsinainen sql-lause
	
	public HaeHenkilot(){
		naytaValikko();
	}
	
	private void naytaValikko() {
		System.out.println("1. N�yt� kaikki henkil�t");
		System.out.println("2. Lis�� henkil�");
		System.out.println("3. Muuta henkil�");
		System.out.println("4. Poista henkil�");
		System.out.println("0. Lopeta");
		switch (lukija.lueKokonaisluku("Valintasi: ")) {
		case 1:
			listaaHenkilot();
			break;
		case 2:
			lisaaHenkilo();
			break;
		case 3:
			muutaHenkilo();
			break;
		case 4:
			poistaHenkilo();
			break;
		case 0:
			System.exit(0);
			break;
		default:
			System.out.println("V��r� valinta!");
			break;
		}
		naytaValikko();		
	}
	
	private void listaaHenkilot() {
		sql = "SELECT * FROM henkilot";       
		try {
			con=yhdista(); //yhdista() on metodi alempana
			if(con!=null) { //jos yhteys onnistui
				stmtPrep = con.prepareStatement(sql);        		
        		rs = stmtPrep.executeQuery(); //toteuttaa tietokantakyselyn  
				if(rs!=null) { //jos kysely onnistui
					con.close(); //yhteys kiinni, koska yhteytt� ei en�� tarvita
					System.out.println();
					while(rs.next()) { //tee niin kauan kuin result setist� l�ytyy tavaraa
						System.out.print(rs.getString(1) +"\t"); //numero vastaa sarakkeen id:t�
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
	
	private void lisaaHenkilo() {
		int id = lukija.lueKokonaisluku("Anna uuden henkil�n id: ");
		String etunimi = lukija.lueTeksti("Anna uuden henkil�n etunimi: ");
		String sukunimi = lukija.lueTeksti("Anna uuden henkil�n sukunimi: ");
		if (etunimi.length()>1 && sukunimi.length()>1) {
			sql="INSERT INTO henkilot VALUES(?,?,?)"; //ajaa sql:n insert-lausekkeen
			//kysymysmerkit vastaa alla olevia numeroita 1, 2 ja 3
			try {
				con = yhdista();
				stmtPrep=con.prepareStatement(sql); 
				stmtPrep.setInt(1, id);
				stmtPrep.setString(2, etunimi);
				stmtPrep.setString(3, sukunimi);
				stmtPrep.executeUpdate(); //ajaa tietokantap�ivityksen
		        con.close(); //sulkee yhteyden
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}		
	}
	
	private void muutaHenkilo() {
		listaaHenkilot();
		int id = lukija.lueKokonaisluku("Anna muutettavan henkil�n id: ");
		sql = "SELECT * FROM henkilot WHERE id=?";       
		try {
			con=yhdista();
			if(con != null) { //jos yhteys onnistui
				stmtPrep = con.prepareStatement(sql); 
				stmtPrep.setInt(1, id);
        		rs = stmtPrep.executeQuery(); //ajaa kyselyn
        		if(rs.isBeforeFirst()) { //jos kysely tuotti dataa, eli id on k�yt�ss�
        			String etunimi = lukija.lueTeksti("Anna henkil�n uusi etunimi: ");
        			String sukunimi = lukija.lueTeksti("Anna henkil�n uusi sukunimi: ");
        			if(etunimi.length()>1 && sukunimi.length()>1) {
        				sql="UPDATE henkilot SET etunimi=?, sukunimi=? WHERE id=?";	//update-lauseke        				
    					stmtPrep=con.prepareStatement(sql); 
    					stmtPrep.setString(1, etunimi);
    					stmtPrep.setString(2, sukunimi);
    					stmtPrep.setInt(3, id);
    					stmtPrep.executeUpdate(); 
        			}
        			con.close();
        			listaaHenkilot();
				} else {
					System.out.println("Antamasi id ei ole k�yt�ss�!\n");
				}				
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	private void poistaHenkilo() {
		listaaHenkilot();
		int id = lukija.lueKokonaisluku("Anna poistettavan henkil�n id: ");
		sql = "SELECT * FROM henkilot WHERE id=?";       
		try {
			con=yhdista();
			if(con!=null) { //jos yhteys onnistui
				stmtPrep = con.prepareStatement(sql); 
				stmtPrep.setInt(1, id);
        		rs = stmtPrep.executeQuery();  
        		if(rs.isBeforeFirst()) { //jos kysely tuotti dataa, eli id on k�yt�ss�
        			rs.next(); //siirryt��n 1. tietueriville
        			if(lukija.lueTeksti("Haluatko varmasti poistaa henkil�n "
        					+rs.getString("etunimi")+" "+rs.getString("sukunimi")
        					+ "(k/e): ").equalsIgnoreCase("k")) {
        				sql="DELETE FROM henkilot WHERE id=?";	        				
    					stmtPrep=con.prepareStatement(sql);     					
    					stmtPrep.setInt(1, id);
    					stmtPrep.executeUpdate(); 
        			}       			
        			con.close();
        			listaaHenkilot();
				} else {
					System.out.println("Antamasi id ei ole k�yt�ss�!\n");
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
		new HaeHenkilot();		
    }	
}
