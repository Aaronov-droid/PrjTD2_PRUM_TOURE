package daoListeMemoire;

import metier.Revue;
import metierDAO.RevueDAO;

import java.util.ArrayList;
import java.util.List;

public class ListeMemoireRevueDAO implements RevueDAO {

	private static ListeMemoireRevueDAO instance;

	private List<Revue> donnees;

	public static ListeMemoireRevueDAO getInstance() {

		if (instance == null) {
			instance = new ListeMemoireRevueDAO();
		}

		return instance;
	}

	private ListeMemoireRevueDAO() {

		this.donnees = new ArrayList<>();

		this.donnees.add(new Revue(1,"Obéron","Un elfes vénère",15,"Roi des Elfes",1));
		this.donnees.add(new Revue(2,"Titiana","Une fée enchantresse",15,"Reine des fées",2));
	}


	@Override
	public boolean create(Revue objet) {

		objet.setId_revue(3);

		while (this.donnees.contains(objet))
		{
			objet.setId_revue(objet.getId_revue() + 1);
		}
		return this.donnees.add(objet);
	}

	@Override
	public boolean update(Revue objet) {

		int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de modification d'une revue inexistante");
		} else {
			this.donnees.set(idx, objet);
		}
		return true;
	}

	@Override
	public boolean delete(Revue objet) {

		Revue supprime;

		int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de suppression d'une revue inexistante");
		} else {
			supprime = this.donnees.remove(idx);
		}

		return objet.equals(supprime);
	}

	@Override
	public Revue getById(int id) {
		//float tarif_numero = 0;

		int idx = this.donnees.indexOf(new Revue(id,"titre","description", 15,"visuel",id));
		if (idx == -1)
		{
			throw new IllegalArgumentException("Aucune revue ne possède cet identifiant");
		}
		else
		{
			return this.donnees.get(idx);
		}
	}

	@Override
	public ArrayList<Revue> findAll() { return (ArrayList<Revue>) this.donnees; }

}