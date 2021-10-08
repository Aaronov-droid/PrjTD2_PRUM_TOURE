package connexion;

import java.sql.*;

public class Connexion {
	
	public Connection creeConnexion(/*String url, String login, String pwd*/) throws Exception {
		
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
	System.out.printf("Connection réussie à la base : " + url);
	
	return maConnexion;

	}
	

}
