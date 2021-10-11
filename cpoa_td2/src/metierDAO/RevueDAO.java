package metierDAO;

import java.util.ArrayList;

import dao.DAO;
import metier.Revue;

public interface RevueDAO extends DAO<Revue> {

	ArrayList<Revue> findAll();
	
}
