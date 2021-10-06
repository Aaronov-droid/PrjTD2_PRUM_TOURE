package daoListeMemoire;

import metier.Abonnement;
import metierDAO.AbonnementDAO;

public class ListeMemoireAbonnementDAO implements AbonnementDAO{
	private static ListeMemoireAbonnementDAO instance;

	private ListeMemoireAbonnementDAO() {}
	
	public static ListeMemoireAbonnementDAO getInstance() {
	if (instance==null) {
	instance = new ListeMemoireAbonnementDAO();
	}
	return instance;
	}

	@Override
	public Abonnement getById(int id) {
		// TODO Auto-generated method stub
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

}
