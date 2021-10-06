package fabrique;

import daoListeMemoire.ListeMemoireAbonnementDAO;
import daoListeMemoire.ListeMemoireClientDAO;
import daoListeMemoire.ListeMemoirePeriodiciteDAO;
import daoListeMemoire.ListeMemoireRevueDAO;
import metierDAO.AbonnementDAO;
import metierDAO.ClientDAO;
import metierDAO.PeriodiciteDAO;
import metierDAO.RevueDAO;

public class ListeMemoireDAOFactory extends DAOFactory{

	@Override
	public AbonnementDAO getAbonnementDAO() {
		// TODO Auto-generated method stub
		return ListeMemoireAbonnementDAO.getInstance();
	}

	@Override
	public ClientDAO getClientDAO() {
		// TODO Auto-generated method stub
		return ListeMemoireClientDAO.getInstance();
	}

	@Override
	public PeriodiciteDAO getPeriodiciteDAO() {
		// TODO Auto-generated method stub
		return ListeMemoirePeriodiciteDAO.getInstance();
	}

	@Override
	public RevueDAO getRevueDAO() {
		// TODO Auto-generated method stub
		return ListeMemoireRevueDAO.getInstance();
	}

}
