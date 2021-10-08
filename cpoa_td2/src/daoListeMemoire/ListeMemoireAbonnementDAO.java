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
		this.donnees.add(new Abonnement(1,datedebut,datefin,1,1));
		this.donnees.add(new Abonnement(2,datedebut,datefin,2,2));
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
		int idx = this.donnees.indexOf(new Abonnement("code_postal", id, "nom", "prenom", "N°rue", "voie", "ville", "pays"));
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
		return false;
	}

	@Override
	public boolean update(Abonnement objet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Abonnement objet) {
		// TODO Auto-generated method stub
		return false;
	}

}
