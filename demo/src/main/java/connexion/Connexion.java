package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
	
	public Connection creeConnexion() {
		
	String url = "jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/toure64u_Projet\"";
	url += "?serverTimezone=Europe/Paris";
	String login = "toure64u_appli";
	String pwd = "32005231";
	Connection maConnexion = null;
		
	try { 
		maConnexion = DriverManager.getConnection(url, login, pwd);
	} catch (SQLException sqle) {
		System.out.println("Erreur connexion" + sqle.getMessage());
	}

	return maConnexion;

	}
	

}
