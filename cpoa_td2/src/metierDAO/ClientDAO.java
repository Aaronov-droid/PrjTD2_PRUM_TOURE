package metierDAO;

import java.util.ArrayList;

import dao.DAO;
import metier.Client;

public interface ClientDAO extends DAO<Client> {

	ArrayList<Client> findAll();

}
