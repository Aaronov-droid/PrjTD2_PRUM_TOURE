package fabrique;

import dao.Persistance;
import metierDAO.AbonnementDAO;
import metierDAO.ClientDAO;
import metierDAO.PeriodiciteDAO;
import metierDAO.RevueDAO;


public abstract class DAOFactory {
	public static DAOFactory getDAOFactory(Persistance cible) {
		DAOFactory daoF = null;
		
		switch (cible) {
		case MySQL :
			daoF = new MySqlDAOFactory();
			break;
		case LISTE_MEMOIRE:
			daoF = new ListeMemoireDAOFactory();
			break;
		}
		return daoF;
	}
	
	public abstract AbonnementDAO getAbonnementDAO();
	public abstract ClientDAO getClientDAO();
	public abstract PeriodiciteDAO getPeriodiciteDAO();
	public abstract RevueDAO getRevueDAO();
}
