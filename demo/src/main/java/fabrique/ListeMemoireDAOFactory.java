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

            return ListeMemoireAbonnementDAO.getInstance();
        }

        @Override
        public ClientDAO getClientDAO() {

            return ListeMemoireClientDAO.getInstance();
        }

        @Override
        public PeriodiciteDAO getPeriodiciteDAO() {

            return ListeMemoirePeriodiciteDAO.getInstance();
        }

        @Override
        public RevueDAO getRevueDAO() {

            return ListeMemoireRevueDAO.getInstance();
        }

    }