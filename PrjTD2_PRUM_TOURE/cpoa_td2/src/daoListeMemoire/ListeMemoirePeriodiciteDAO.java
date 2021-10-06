package daoListeMemoire;
/*
import metier.Periodicite;
import metierDAO.PeriodiciteDAO;

public class ListeMemoirePeriodiciteDAO implements PeriodiciteDAO {
	private static ListeMemoirePeriodiciteDAO instance;
	
	private ListeMemoirePeriodiciteDAO() {}
	
	public static ListeMemoirePeriodiciteDAO getInstance() {
	if (instance==null) {
	instance = new ListeMemoirePeriodiciteDAO();
	}
	return instance;
	}

	@Override
	public Periodicite getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(Periodicite objet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Periodicite objet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Periodicite objet) {
		// TODO Auto-generated method stub
		return false;
	}*/



//package dao.listememoire;

import java.util.ArrayList;
import java.util.List;

import metier.Periodicite;
import metierDAO.PeriodiciteDAO;

public class ListeMemoirePeriodiciteDAO implements PeriodiciteDAO {

	private static ListeMemoirePeriodiciteDAO instance;

	private List<Periodicite> donnees;


	public static ListeMemoirePeriodiciteDAO getInstance() {

		if (instance == null) {
			instance = new ListeMemoirePeriodiciteDAO();
		}

		return instance;
	}

	private ListeMemoirePeriodiciteDAO() {

		this.donnees = new ArrayList<Periodicite>();

		this.donnees.add(new Periodicite(1, "Mensuel"));
		this.donnees.add(new Periodicite(2, "Quotidien"));
	}


	@Override
	public boolean create(Periodicite objet) {

		objet.setId(3);
		// Ne fonctionne que si l'objet m�tier est bien fait...
		while (this.donnees.contains(objet)) {

			objet.setId(objet.getId() + 1);
		}
		boolean ok = this.donnees.add(objet);
		
		return ok;
	}

	@Override
	public boolean update(Periodicite objet) {
		
		// Ne fonctionne que si l'objet m�tier est bien fait...
		int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
		} else {
			
			this.donnees.set(idx, objet);
		}
		
		return true;
	}

	@Override
	public boolean delete(Periodicite objet) {

		Periodicite supprime;
		
		// Ne fonctionne que si l'objet m�tier est bien fait...
		int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
		} else {
			supprime = this.donnees.remove(idx);
		}
		
		return objet.equals(supprime);
	}

	@Override
	public Periodicite getById(int id) {
		// Ne fonctionne que si l'objet m�tier est bien fait...
		int idx = this.donnees.indexOf(new Periodicite(id, "test"));
		if (idx == -1) {
			throw new IllegalArgumentException("Aucun objet ne poss�de cet identifiant");
		} else {
			return this.donnees.get(idx);
		}
	}

	@Override
	public ArrayList<Periodicite> findAll() {
		return (ArrayList<Periodicite>) this.donnees;
	}
}

