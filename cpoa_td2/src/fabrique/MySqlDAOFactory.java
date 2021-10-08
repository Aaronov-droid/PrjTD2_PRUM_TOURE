package fabrique;

import daoMySQL.MySQLAbonnementDAO;
import daoMySQL.MySQLClientDAO;
import daoMySQL.MySQLPeriodiciteDAO;
import daoMySQL.MySQLRevueDAO;
import metierDAO.AbonnementDAO;
import metierDAO.ClientDAO;
import metierDAO.PeriodiciteDAO;
import metierDAO.RevueDAO;

public class MySqlDAOFactory extends DAOFactory{

	@Override
	public AbonnementDAO getAbonnementDAO() {
		// TODO Auto-generated method stub
		return MySQLAbonnementDAO.getInstance();
	}

	@Override
	public ClientDAO getClientDAO() {
		// TODO Auto-generated method stub
		return MySQLClientDAO.getInstance();
	}

	@Override
	public PeriodiciteDAO getPeriodiciteDAO() {
		// TODO Auto-generated method stub
		return MySQLPeriodiciteDAO.getInstance();
	}

	@Override
	public RevueDAO getRevueDAO() {
		// TODO Auto-generated method stub
		return MySQLRevueDAO.getInstance();
	}

}
