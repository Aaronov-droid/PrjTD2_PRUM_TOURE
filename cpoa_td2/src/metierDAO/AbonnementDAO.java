package metierDAO;

import java.util.ArrayList;

import dao.DAO;
import metier.Abonnement;

public interface AbonnementDAO extends DAO<Abonnement> {

	ArrayList<Abonnement> findAll();
	

}
