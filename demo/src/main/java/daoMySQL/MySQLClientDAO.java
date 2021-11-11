package daoMySQL;

import metier.Client;
import metierDAO.ClientDAO;

import java.util.ArrayList;

public class MySQLClientDAO implements ClientDAO {
private static MySQLClientDAO instance;
	
	private MySQLClientDAO() {}
	
	public static MySQLClientDAO getInstance() {
	if (instance==null) {
	instance = new MySQLClientDAO();
	}
	return instance;
	}

	@Override
	public Client getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(Client objet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Client objet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Client objet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Client> findAll() {
		return null;
	}
}
