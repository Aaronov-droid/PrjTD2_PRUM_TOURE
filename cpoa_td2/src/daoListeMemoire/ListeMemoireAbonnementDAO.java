package daoListeMemoire;

import java.time.LocalDate;
import java.util.ArrayList;

import metier.Abonnement;
import metier.Client;
import metierDAO.AbonnementDAO;

public class ListeMemoireAbonnementDAO implements AbonnementDAO{
	private static ListeMemoireAbonnementDAO instance;
	private ArrayList<Abonnement> donnees;

	private ListeMemoireAbonnementDAO() 
	{
		this.donnees = new ArrayList<Abonnement>();
		
		//this.donnees.add(new Abonnement(1,datedebut,datefin,1,1));
		//this.donnees.add(new Abonnement(2,datedebut,datefin,2,2));
	}
	
	public static ListeMemoireAbonnementDAO getInstance() {
	if (instance==null) {
	instance = new ListeMemoireAbonnementDAO();
	}
	return instance;
	}
	


	@Override
	public Abonnement getById(int id) {
		// TODO Auto-generated method stub
		//int idx = this.donnees.indexOf(new Abonnement(id," "));
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
	public boolean create(Abonnement objet) {
		// TODO Auto-generated method stub
		objet.setId_abonnement(3);
		while (this.donnees.contains(objet))
		{
			objet.setId_abonnement(objet.getId_abonnement() + 1);
		}
		boolean ok = this.donnees.add(objet);
		return ok;
	}

	@Override
	public boolean update(Abonnement objet) {
		// TODO Auto-generated method stub
		int idx = this.donnees.indexOf(objet);
		if (idx == -1)
		{
			throw new IllegalArgumentException("Tentative de modification d'un abonnement inexistant");
		}
		else
		{
			this.donnees.set(idx, objet)
		}
		return true;
	}

	@Override
	public boolean delete(Abonnement objet) {
		// TODO Auto-generated method stub
		Abonnement supprime;
		
		int idx = this.donnees.indexOf(objet);
		if (idx == -1)
		{
			throw new IllegalArgumentException("Tentative de suppression d'un abonnement inexistant");
		}
		else
		{
			supprime=this.donnees.remove(idx);
		}
		return objet.equals(supprime);
	}
	
	@Override
	public ArrayList<Abonnement> findAll()
	{
		return (ArrayList<Abonnement>) this.donnees;
	}

}
