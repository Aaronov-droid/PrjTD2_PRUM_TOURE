package Main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import fabrique.DAOFactory;
import dao.Persistance;
import metier.Abonnement;
import metier.Client;
import metier.Periodicite;
import metier.Revue;

public class Menu {
	private Scanner sc = new Scanner(System.in);
	private DAOFactory obj;
	public Menu(DAOFactory obj) {
		super();
		this.obj = obj;
	}
	
	public void menu() throws Exception {
		System.out.println("Tapez: \n1 - Table Abonnements\n2 - Table Clients\n3 - Table Periodicite\n4 - Table Revues\5 - changement de persistance");
		String choix=sc.nextLine();
		if(choix.equals("1"))menuAbonnement();
		if(choix.equals("2"))menuClient();
		if(choix.equals("3"))menuPeriodicite();
		if(choix.equals("4"))menuRevue();
		if(choix.equals("5"))changerPersistance();
	}

	private void changerPersistance() throws Exception {
		System.out.println("Tapez: \n1 -pour etre en mode MYSQL\n2 - pour etre en mode ListeMemoire");
		String choix=sc.nextLine();
		if(choix.equals("1"))new Menu(fabrique.DAOFactory.getDAOFactory(Persistance.valueOf("MySQL"))).menu();
		else if(choix.equals("2"))new Menu(fabrique.DAOFactory.getDAOFactory(Persistance.valueOf("LISTE_MEMOIRE"))).menu();
	}

	private void menuRevue() throws Exception {
		System.out.println("Tapez: \n1 - Ajouter une revue\n2 - Modifier une revue\n3 - Supprimer une revue");
		String choix = sc.nextLine();
		if(choix.equals("1")) {
			System.out.println("Titre de la revue :");
			String Titre = sc.nextLine();
			System.out.println("Description de la revue :");
			String Description = sc.nextLine();
			System.out.println("Visuel de la revue :");
			String Visuel = sc.nextLine();
			System.out.println("Id de la periodicite de la revue :");
			int idperiodicite=sc.nextInt();
			Revue rev=new Revue(0,Titre,Description, 0, Visuel, idperiodicite);
			obj.getRevueDAO().create(rev);
			}
		
		if(choix.equals("2")) {
			System.out.println("Entrez l'id de la revue à modifier :");
			int id=sc.nextInt();
			sc.nextInt();
			Revue rev=obj.getRevueDAO().getById(id);
			System.out.println("Nouveau titre de la revue :");
			String Titre=sc.nextLine();
			System.out.println("Nouvelle description  de la revue :");
			String Description=sc.nextLine();
			System.out.println("Nouveau visuel de la revue :");
			String Visuel=sc.nextLine();
			rev.setTitre(Titre);
			rev.setDescription(Description);
			rev.setVisuel(Visuel);
			obj.getRevueDAO().update(rev);
			}
		
		else if(choix.equals("3")) {
			System.out.println("Entrez l'id de la revue à supprimer");
			int id=sc.nextInt();
			sc.nextLine();
			obj.getRevueDAO().delete(obj.getRevueDAO().getById(id));
		}
		menu();
	}

	private void menuPeriodicite() throws Exception {
		System.out.println("Tapez: \n1 - Ajouter une periodicite\n2 - Modifier une periodicite\n3 - Supprimer une periodicite");
		String choix = sc.nextLine();
		if(choix.equals("1")) {
			System.out.println("Libelle de la periodicite :");
			String Libelle = sc.nextLine();
			Periodicite per=new Periodicite(0,Libelle);
			obj.getPeriodiciteDAO().create(per);		
			}
		
		if(choix.equals("2")) {
			System.out.println("Entrez l'id de la periodicite à modifier :");
			int id=sc.nextInt();
			sc.nextInt();
			Periodicite per=obj.getPeriodiciteDAO().getById(id);
			System.out.println("Nouveau libelle de la Periodicite :");
			String Libelle=sc.nextLine();
			per.setLibelle(Libelle);
			obj.getPeriodiciteDAO().update(per);
			}
		
		else if(choix.equals("3")) {
			System.out.println("Entrez l'id de la periodicite à supprimer");
			int id=sc.nextInt();
			sc.nextLine();
			obj.getPeriodiciteDAO().delete(obj.getPeriodiciteDAO().getById(id));
		}
		menu();
	}

	private void menuClient() throws Exception {
		System.out.println("Tapez: \n1 - Ajouter un client\n2 - Modifier un client\n3 - Supprimer un client");
		String choix = sc.nextLine();
		if(choix.equals("1")) {
			System.out.println("Nom du client :");
			String Nom = sc.nextLine();
			System.out.println("Prenom du client :");
			String Prenom = sc.nextLine();
			System.out.println("N° de rue du client :");
			String Rue = sc.nextLine();
			System.out.println("Voie de la rue du client :");
			String Voie = sc.nextLine();
			System.out.println("Code postal du client :");
			String Postal = sc.nextLine();
			System.out.println("Ville du client :");
			String Ville = sc.nextLine();
			System.out.println("Pays du client :");
			String Pays = sc.nextLine();
			Client cli=new Client (Nom,0,Prenom,Rue,Voie,Postal,Ville,Pays);
			obj.getClientDAO().create(cli);
			}
		
		if(choix.equals("2")) {
			System.out.println("Entrez l'id du client à modifier :");
			int id=sc.nextInt();
			sc.nextInt();
			Client cli=obj.getClientDAO().getById(id);
			System.out.println("Nouveau nom du client :");
			String Nom=sc.nextLine();
			System.out.println("Nouveau prenom du client :");
			String Prenom=sc.nextLine();
			System.out.println("Nouveau N° de rue du client :");
			String Rue=sc.nextLine();
			System.out.println("Nouvelle voie du client :");
			String Voie=sc.nextLine();
			System.out.println("Nouveau code postal du client :");
			String Postal=sc.nextLine();
			System.out.println("Nouvelle ville du client :");
			String Ville=sc.nextLine();
			System.out.println("Nouveau pays du client :");
			String Pays=sc.nextLine();
			cli.setNom(Nom);
			cli.setPrenom(Prenom);
			cli.setNo_rue(Rue);
			cli.setVoie(Voie);
			cli.setCode_postal(Postal);
			cli.setVille(Ville);
			cli.setPays(Pays);
			obj.getClientDAO().update(cli);
			}
		
		else if(choix.equals("3")) {
			System.out.println("Entrez l'id du client à supprimer");
			int id=sc.nextInt();
			sc.nextLine();
			obj.getClientDAO().delete(obj.getClientDAO().getById(id));
		}
		menu();
	}

	private void menuAbonnement() throws Exception {
		System.out.println("Tapez: \n1 - Ajouter un abonnement\n2 - Modifier un abonnement\n3 - Supprimer un abonnement");
		String choix = sc.nextLine();
		if(choix.equals("1")) {
			System.out.println("Debut de l'abonnement au format (YYYY-MM-DD) : ");
			String Debut = sc.nextLine();
			DateTimeFormatter formatageDebut = DateTimeFormatter.ofPattern("YYYY-MM-DD");
			LocalDate dateDebut=null;
			dateDebut = LocalDate.parse(Debut, formatageDebut);
			System.out.println("Fin de l'abonnementt au format (YYYY-MM-DD) : ");
			String Fin = sc.nextLine();
			DateTimeFormatter formatageFin = DateTimeFormatter.ofPattern("YYYY-MM-DD");
			LocalDate dateFin=null;
			dateFin = LocalDate.parse(Fin, formatageFin);
			System.out.println("Id du client :");
			int idclient=sc.nextInt();
			System.out.println("Id de ma revue :");
			int idrevue=sc.nextInt();
			Abonnement abo=new Abonnement (0, dateDebut, dateFin, idclient, idrevue);
			obj.getAbonnementDAO().create(abo);
			}			

		if(choix.equals("2")) {
			System.out.println("Entrez l'id de l'abonnement à modifier :");
			int id=sc.nextInt();
			sc.nextInt();
			Abonnement abo=obj.getAbonnementDAO().getById(id);
			System.out.println("Nouveau Debut de l'abonnement au format (YYYY-MM-DD) :");
			String Debut=sc.nextLine();
			DateTimeFormatter formatageDebut = DateTimeFormatter.ofPattern("YYYY-MM-DD");
			LocalDate dateDebut=null;
			dateDebut = LocalDate.parse(Debut, formatageDebut);
			System.out.println("Nouvelle Fin de l'abonnement au format (YYYY-MM-DD) :");
			String Fin=sc.nextLine();
			DateTimeFormatter formatageFin = DateTimeFormatter.ofPattern("YYYY-MM-DD");
			LocalDate dateFin=null;
			dateFin = LocalDate.parse(Fin, formatageFin);
			System.out.println("Nouveau Id du client :");
			int idclient=sc.nextInt();
			sc.nextLine();
			System.out.println("Nouvelle Id de la revue :");
			int idrevue=sc.nextInt();
			sc.nextLine();
			abo.setDate_debut(dateDebut);
			abo.setDate_fin(dateFin);
			abo.setId_client(idclient);
			abo.setId_revue(idrevue);
			obj.getAbonnementDAO().update(abo);
			}
		
		else if(choix.equals("3")) {
			System.out.println("Entrez l'id de l'abonnement à supprimer");
			int id=sc.nextInt();
			sc.nextLine();
			obj.getAbonnementDAO().delete(obj.getAbonnementDAO().getById(id));
		}
		menu();
	}
}
