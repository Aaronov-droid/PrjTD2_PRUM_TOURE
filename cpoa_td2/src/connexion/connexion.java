package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connexion {
	public Connection creeConnexion() {
		String url= //lien mysql
		url += "?serverTimezone=Europe/Paris";
		String login ="";String pwd = "";
		Connection maConnexion = null;
		try {
			maConnexion = DriverManager.getConnection(url,login,pwd);
		}	catch (SQLException sqle) {
			System.out.println("Erreur connexion" + sqle.getMessage());
		}
		return maConnexion;
	}
}
