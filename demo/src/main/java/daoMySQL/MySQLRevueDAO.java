package daoMySQL;

import metier.Revue;
import metierDAO.RevueDAO;

import java.util.ArrayList;

public class MySQLRevueDAO implements RevueDAO {
	private static MySQLRevueDAO instance;
	
	private MySQLRevueDAO() {}
	
	public static MySQLRevueDAO getInstance() {
	if (instance==null) {
	instance = new MySQLRevueDAO();
	}
	return instance;
	}

	@Override
	public Revue getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(Revue objet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Revue objet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Revue objet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Revue> findAll() {
		return null;
	}
}
