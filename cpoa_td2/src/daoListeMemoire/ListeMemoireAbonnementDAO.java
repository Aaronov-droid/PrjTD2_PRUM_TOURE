package daoListeMemoire;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import metier.Abonnement;
import metier.Client;
import metier.Revue;
import metierDAO.AbonnementDAO;

public class ListeMemoireAbonnementDAO implements AbonnementDAO{
	private static ListeMemoireAbonnementDAO instance;
	private ArrayList<Abonnement> donnees;

	private ListeMemoireAbonnementDAO() 
	{
		this.donnees = new ArrayList<Abonnement>();
		DateTimeFormatter formatage = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	    LocalDateTime dateDebutAbo1 = LocalDateTime.parse("2021-10-11 16:18:30", formatage);
	    LocalDateTime dateFinAbo1 = LocalDateTime.parse("2022-10-11 16:18:30", formatage);
	    LocalDateTime dateDebutAbo2 = LocalDateTime.parse("2022-10-11 16:18:35", formatage);
	    LocalDateTime dateFinAbo2 = LocalDateTime.parse("2023-09-15 15:15:40", formatage);
		this.donnees.add(new Abonnement(1,dateDebutAbo1,dateFinAbo1,1,1));
		this.donnees.add(new Abonnement(2,dateDebutAbo2,dateFinAbo2,2,2));
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
		DateTimeFormatter formatage = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	    LocalDateTime dateDebutAbo = LocalDateTime.parse("2021-10-11 16:18:30", formatage);
	    LocalDateTime dateFinAbo = LocalDateTime.parse("2022-10-11 16:18:30", formatage);
		int idx = this.donnees.indexOf(new Abonnement(id,dateDebutAbo,dateFinAbo,id,id));
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
			this.donnees.set(idx, objet);
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
