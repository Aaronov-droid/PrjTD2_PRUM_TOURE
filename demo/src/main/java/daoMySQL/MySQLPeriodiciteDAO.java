package daoMySQL;

import connexion.Connexion;
import metier.Periodicite;
import metierDAO.PeriodiciteDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MySQLPeriodiciteDAO implements PeriodiciteDAO {
	private static MySQLPeriodiciteDAO instance;
	
	private MySQLPeriodiciteDAO() {}
	
	public static MySQLPeriodiciteDAO getInstance() {
	if (instance==null) {
	instance = new MySQLPeriodiciteDAO();
	}
	return instance;
	}

	@Override
	public Periodicite getById(int id) {
		Periodicite periodicite=null;
		try {
			Connexion c1 =new Connexion();
			Connection connect =c1.creeConnexion();
			
			PreparedStatement stmt = null;

			ResultSet rset = null;
			
			//stmt = connect.createStatement();
				
				while (rset.next()) {

				}
				
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean create(Periodicite objet) {
		Periodicite periodicite=null;
		try {
			Connexion c1 =new Connexion();
			Connection connect =c1.creeConnexion();
			
			PreparedStatement stmt = null;

				stmt = connect.prepareStatement("Insert Into Periodicite Values (?, ?)");
				
				stmt.setLong(1, objet.getId_periodicite());
				stmt.setString(2, objet.getLibelle());
				
				stmt.executeUpdate();			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Periodicite objet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Periodicite objet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Periodicite> findAll() {
		return null;
	}
}
