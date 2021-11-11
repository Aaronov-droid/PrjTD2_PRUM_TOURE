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

		return MySQLAbonnementDAO.getInstance();
	}

	@Override
	public ClientDAO getClientDAO() {

		return MySQLClientDAO.getInstance();
	}

	@Override
	public PeriodiciteDAO getPeriodiciteDAO() {

		return MySQLPeriodiciteDAO.getInstance();
	}

	@Override
	public RevueDAO getRevueDAO() {

		return MySQLRevueDAO.getInstance();
	}

}
