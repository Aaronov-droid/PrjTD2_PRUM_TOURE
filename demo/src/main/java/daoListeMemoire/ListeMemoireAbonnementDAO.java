package daoListeMemoire;

import metier.Abonnement;
import metier.Periodicite;
import metierDAO.AbonnementDAO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ListeMemoireAbonnementDAO implements AbonnementDAO{

	private static ListeMemoireAbonnementDAO instance;

	private List<Abonnement> donnees;

	public static ListeMemoireAbonnementDAO getInstance() {
		if (instance==null) {
			instance = new ListeMemoireAbonnementDAO();
		}
		return instance;
	}

	private ListeMemoireAbonnementDAO() {

		this.donnees = new ArrayList<Abonnement>();

		DateTimeFormatter formatage = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dateDebutAbo1 = LocalDate.parse("2021-10-11", formatage);
		LocalDate dateFinAbo1 = LocalDate.parse("2022-10-11", formatage);
		LocalDate dateDebutAbo2 = LocalDate.parse("2022-10-11", formatage);
		LocalDate dateFinAbo2 = LocalDate.parse("2023-09-15", formatage);
		this.donnees.add(new Abonnement(1,dateDebutAbo1,dateFinAbo1,1,1));
		this.donnees.add(new Abonnement(2,dateDebutAbo2,dateFinAbo2,2,2));
	}

	@Override
	public boolean create(Abonnement objet) {

		objet.setId_abonnement(3);
		while (this.donnees.contains(objet))
		{
			objet.setId_abonnement(objet.getId_abonnement() + 1);
		}
		return this.donnees.add(objet);
	}
	@Override
	public boolean update(Abonnement objet) {

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
	public Abonnement getById(int id) {

		DateTimeFormatter formatage = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dateDebutAbo = LocalDate.parse("2021-10-11", formatage);
		LocalDate dateFinAbo = LocalDate.parse("2022-10-11", formatage);
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
	public ArrayList<Abonnement> findAll() {
		return (ArrayList<Abonnement>) this.donnees;
	}

}