package daoMySQL;

import connexion.Connexion;
import metier.Abonnement;
import metierDAO.AbonnementDAO;

import java.sql.Connection;
import java.util.ArrayList;

public class MySQLAbonnementDAO implements AbonnementDAO {
	
	
	private static MySQLAbonnementDAO instance;
	
	private MySQLAbonnementDAO() {}
	
	public static MySQLAbonnementDAO getInstance() {
	if (instance==null) {
	instance = new MySQLAbonnementDAO();
	}
	return instance;
	}

	@Override
	public Abonnement getById(int id) {
		Abonnement abonnement = null;
	try {
		Connexion c1 =new Connexion();
		Connection connect =c1.creeConnexion();
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return null;
	}
	@Override
	public boolean create(Abonnement objet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Abonnement objet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Abonnement objet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Abonnement> findAll() {
		return null;
	}
}
