package daoListeMemoire;

import metier.Client;
import metier.Periodicite;
import metierDAO.ClientDAO;

import java.util.ArrayList;

public class ListeMemoireClientDAO implements ClientDAO {
	private static ListeMemoireClientDAO instance;
	private ArrayList<Client> donnees;

	private ListeMemoireClientDAO()
	{
		this.donnees = new ArrayList<>();

		this.donnees.add(new Client("54800",1,"PRUM","Lucas","31","Rue des Ormes","Jarny","France"));
		this.donnees.add(new Client("57000",2,"TOURE","Matis","7","Saulcy","Metz","France"));
	}

	public static ListeMemoireClientDAO getInstance() {
		if (instance==null) {
			instance = new ListeMemoireClientDAO();
		}
		return instance;
	}




	@Override
	public Client getById(int id) {
		// TODO Auto-generated method stub
		int idx = this.donnees.indexOf(new Client("code_postal", id, "nom", "prenom", "N°rue", "voie", "ville", "pays"));
		if (idx == -1)
		{
			throw new IllegalArgumentException("Aucun client ne possède cet identifiant");
		}
		else
		{
			return this.donnees.get(idx);
		}
	}

	@Override
	public boolean create(Client objet) {
		// TODO Auto-generated method stub
		objet.setId_client(3);
		while (this.donnees.contains(objet))
		{
			objet.setId_client(objet.getId_client() + 1);
		}
		return this.donnees.add(objet);
	}

	@Override
	public boolean update(Client objet) {
		// TODO Auto-generated method stub
		int idx = this.donnees.indexOf(objet);
		if (idx == -1)
		{
			throw new IllegalArgumentException("Tentative de modification d'un client inexistant");
		}
		else
		{
			this.donnees.set(idx, objet);
		}
		return true;
	}

	@Override
	public boolean delete(Client objet) {
		// TODO Auto-generated method stub
		Client supprime;

		int idx = this.donnees.indexOf(objet);
		if (idx == -1)
		{
			throw new IllegalArgumentException("Tentative de suppression d'un client inexistant");
		}
		else
		{
			supprime=this.donnees.remove(idx);
		}
		return objet.equals(supprime);
	}

	@Override
	public ArrayList<Client> findAll() {
		return (ArrayList<Client>) this.donnees;
	}

}