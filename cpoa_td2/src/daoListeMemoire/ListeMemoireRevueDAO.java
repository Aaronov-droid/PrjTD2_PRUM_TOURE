package daoListeMemoire;

import metier.Revue;
import metierDAO.RevueDAO;

public class ListeMemoireRevueDAO implements RevueDAO {
	private static ListeMemoireRevueDAO instance;
	
	private ListeMemoireRevueDAO() {}
	
	public static ListeMemoireRevueDAO getInstance() {
	if (instance==null) {
	instance = new ListeMemoireRevueDAO();
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

}
