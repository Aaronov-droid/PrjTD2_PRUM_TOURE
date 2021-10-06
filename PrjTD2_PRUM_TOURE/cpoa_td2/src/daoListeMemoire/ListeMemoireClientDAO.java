package daoListeMemoire;

import metier.Client;
import metierDAO.ClientDAO;

public class ListeMemoireClientDAO implements ClientDAO {
	private static ListeMemoireClientDAO instance;
	
	private ListeMemoireClientDAO() {}
	
	public static ListeMemoireClientDAO getInstance() {
	if (instance==null) {
	instance = new ListeMemoireClientDAO();
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

}
