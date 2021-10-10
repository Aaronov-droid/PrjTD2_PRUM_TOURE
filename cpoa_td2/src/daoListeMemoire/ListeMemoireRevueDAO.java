package daoListeMemoire;

import metier.Revue;
import metierDAO.RevueDAO;

public class ListeMemoireRevueDAO implements RevueDAO {
	private static ListeMemoireRevueDAO instance;
	private ArrayList<Revue> donnees;
	
	private ListeMemoireRevueDAO() 
	{
		this.donnees = new ArrayList<Revue>();
		
		//this.donnees.add(new Revue(1,...));
		//this.donnees.add(new Revue(2,...));
	}
	
	public static ListeMemoireRevueDAO getInstance() {
	if (instance==null) {
	instance = new ListeMemoireRevueDAO();
	}
	return instance;
	}

	@Override
	public Revue getById(int id) {
		// TODO Auto-generated method stub
		//int idx = this.donnees.indexOf(new Revue(""));
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
	public boolean create(Revue objet) {
		// TODO Auto-generated method stub
		objet.setId_revue(3);
		while (this.donnees.contains(objet))
		{
			objet.setId_revue(objet.getId_revue() + 1);
		}
		boolean ok = this.donnees.add(objet);
		return ok;
	}

	@Override
	public boolean update(Revue objet) {
		// TODO Auto-generated method stub
		int idx = this.donnees.indexOf(objet);
		if (idx == -1)
		{
			throw new IllegalArgumentException("Tentative de modification d'une revue inexistante");
		}
		else
		{
			this.donnees.set(idx, objet)
		}
		return true;
	}

	@Override
	public boolean delete(Revue objet) {
		// TODO Auto-generated method stub
		Revue supprime;
		
		int idx = this.donnees.indexOf(objet);
		if (idx == -1)
		{
			throw new IllegalArgumentException("Tentative de suppression d'une revue inexistante");
		}
		else
		{
			supprime=this.donnees.remove(idx);
		}
		return objet.equals(supprime);
	}
	
	@Override
	public ArrayList<Revue> findAll()
	{
		return (ArrayList<Revue>) this.donnees;
	}

}
