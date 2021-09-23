package fabrique;

import dao.Persistance;

public abstract class DAOFactory {
	public static DAOFactory getDAOFactory(Persistance cible) {
		DAOFactory daof = null;
		
		switch (cible) {
		case MySQL :
			daoF = new MySqlDAOFactory();
			break;
		case LISTE_MEMOIRE:
			daoF = new ListeMemoireDAOFactory();
			break;
		}
		return daof;
	}
	
	public abstract AbonnementDAO getAbonnementDAO();
	public abstract ClientDAO getClientDAO();
	public abstract PeriodiciteDAO getPeriodiciteDAO();
	public abstract RevueDAO getRevueDAO();
}
