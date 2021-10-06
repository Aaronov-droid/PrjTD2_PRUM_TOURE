package main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

import fabrique.DAOFactory;
import dao.Persistance;
import metier.Abonnement;
import metier.Client;
import metier.Periodicite;
import metier.Revue;

public class Menu {
	private Scanner myObj = new Scanner(System.in);
	private DAOFactory obj;
	public Menu(DAOFactory obj) {
		super();
		this.obj = obj;
	}
	
	public void menu() throws Exception {
		System.out.println("Tapez: \n1 - Table Abonnements\n2 - Table Clients\n3 - Table Periodicite\n4 - Table Revues\5 - changement de persistance");
		String choix=myObj.nextLine();
		if(choix.equals("1"))menuAbonnement();
		if(choix.equals("2"))menuClient();
		if(choix.equals("3"))menuPeriodicite();
		if(choix.equals("4"))menuRevue();
		if(choix.equals("5"))changerPersistance();
	}

	private void changerPersistance() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Tapez: \n1 -pour etre en mode MYSQL\n2 - pour etre en mode ListeMemoire");
		String choix=myObj.nextLine();
		if(choix.equals("1"))new Menu(fabrique.DAOFactory.getDAOFactory(Persistance.valueOf("MySQL"))).menu();
		else if(choix.equals("2"))new Menu(fabrique.DAOFactory.getDAOFactory(Persistance.valueOf("LISTE_MEMOIRE"))).menu();
	}

	private void menuRevue() {
		// TODO Auto-generated method stub
		System.out.println("Tapez: \n1 - Ajouter une revue\n2 - Modifier une revue\n3 - Supprimer une revue");
		String choix = myObj.nextLine();
		if(choix.equals("1")) {
			System.out.println("Titre de la revue :");
			String Titre = myObj.nextLine();
			System.out.println("Description de la revue :");
			String Description = myObj.nextLine();
			System.out.println("Visuel de la revue :");
			String Visuel = myObj.nextLine();
			System.out.println("Id de la periodicite de la revue :");
			int idperiodicite=myObj.nextInt();
			Revue rev=new Revue(0,Titre,Description, 0, Visuel, obj.getPeriodiciteDAO().getById(idperiodicite));
			obj.getRevueDAO().create(rev);		
			}
		
		if(choix.equals("2")) {
			System.out.println("Entrez l'id de la revue à modifier :");
			int id=myObj.nextInt();
			myObj.nextInt();
			Revue rev=obj.getRevueDAO().getById(id);
			System.out.println("Nouveau titre de la revue :");
			String Titre=myObj.nextLine();
			System.out.println("Nouvelle description  de la revue :");
			String Description=myObj.nextLine();
			System.out.println("Nouveau visuel de la revue :");
			String Visuel=myObj.nextLine();
			rev.setTitre(Titre);
			rev.setDescription(Description);
			rev.setVisuel(Visuel);
			obj.getRevueDAO().update(rev);
			}
		
		else if(choix.equals("3")) {
			System.out.println("Entrez l'id de la revue à supprimer");
			int id=myObj.nextInt();
			myObj.nextLine();
			obj.getRevueDAO().delete(obj.getRevueDAO().getById(id));
		}
		menu();
	}

	private void menuPeriodicite() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Tapez: \n1 - Ajouter une periodicite\n2 - Modifier une periodicite\n3 - Supprimer une periodicite");
		String choix = myObj.nextLine();
		if(choix.equals("1")) {
			System.out.println("Libelle de la periodicite :");
			String Libelle = myObj.nextLine();
			Periodicite per=new Periodicite(0,Libelle);
			obj.getPeriodiciteDAO().create(per);		
			}
		
		if(choix.equals("2")) {
			System.out.println("Entrez l'id de la periodicite à modifier :");
			int id=myObj.nextInt();
			myObj.nextInt();
			Periodicite per=obj.getPeriodiciteDAO().getById(id);
			System.out.println("Nouveau libelle de la Periodicite :");
			String Libelle=myObj.nextLine();
			per.setLibelle(Libelle);
			obj.getPeriodiciteDAO().update(per);
			}
		
		else if(choix.equals("3")) {
			System.out.println("Entrez l'id de la periodicite à supprimer");
			int id=myObj.nextInt();
			myObj.nextLine();
			obj.getPeriodiciteDAO().delete(obj.getPeriodiciteDAO().getById(id));
		}
		menu();
	}

	private void menuClient() {
		// TODO Auto-generated method stub
		System.out.println("Tapez: \n1 - Ajouter un client\n2 - Modifier un client\n3 - Supprimer un client");
		String choix = myObj.nextLine();
		if(choix.equals("1")) {
			System.out.println("Nom du client :");
			String Nom = myObj.nextLine();
			System.out.println("Prenom du client :");
			String Prenom = myObj.nextLine();
			System.out.println("N° de rue du client :");
			String Rue = myObj.nextLine();
			System.out.println("Voie de la rue du client :");
			String Voie = myObj.nextLine();
			System.out.println("Code postal du client :");
			String Postal = myObj.nextLine();
			System.out.println("Ville du client :");
			String Ville = myObj.nextLine();
			System.out.println("Pays du client :");
			String Pays = myObj.nextLine();
			Client cli=new Client (Nom,0,Prenom,Rue,Voie,Postal,Ville,Pays);
			obj.getClientDAO().create(cli);
			}
		
		if(choix.equals("2")) {
			System.out.println("Entrez l'id du client à modifier :");
			int id=myObj.nextInt();
			myObj.nextInt();
			Client cli=obj.getClientDAO().getById(id);
			System.out.println("Nouveau nom du client :");
			String Nom=myObj.nextLine();
			System.out.println("Nouveau prenom du client :");
			String Prenom=myObj.nextLine();
			System.out.println("Nouveau N° de rue du client :");
			String Rue=myObj.nextLine();
			System.out.println("Nouvelle voie du client :");
			String Voie=myObj.nextLine();
			System.out.println("Nouveau code postal du client :");
			String Postal=myObj.nextLine();
			System.out.println("Nouvelle ville du client :");
			String Ville=myObj.nextLine();
			System.out.println("Nouveau pays du client :");
			String Pays=myObj.nextLine();
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
			int id=myObj.nextInt();
			myObj.nextLine();
			//obj.getAbonnementDAO().delete(obj.getClientDAO().getById(id));
		}
		menu();
	}

	private void menuAbonnement() {
		// TODO Auto-generated method stub
		System.out.println("Tapez: \n1 - Ajouter un abonnement\n2 - Modifier un abonnement\n3 - Supprimer un abonnement");
		String choix = myObj.nextLine();
		if(choix.equals("1")) {
			System.out.println("Debut de l'abonnement au format (YYYY-MM-DD hh:mm:ss) :");
			String Debut = myObj.nextLine();
			DateTimeFormatter Formatage1 = DateTimeFormatter.ofPattern("YYYY-MM-DD hh:mm:ss");
			System.out.println("Fin de l'abonnementt au format (YYYY-MM-DD hh:mm:ss):");
			String Fin = myObj.nextLine();
			DateTimeFormatter Formatage2 = DateTimeFormatter.ofPattern("YYYY-MM-DD hh:mm:ss");
			System.out.println("Id du client :");
			int idclient=myObj.nextInt();
			System.out.println("Id de ma revue :");
			int idrevue=myObj.nextInt();
			Abonnement abo=new Abonnement (0,Debut,Fin,obj.getClientDAO().getById(idclient), obj.getRevueDAO().getbyId(idrevue));
			obj.getAbonnementDAO().create(abo);
			}			

		if(choix.equals("2")) {
			System.out.println("Entrez l'id de l'abonnement à modifier :");
			int id=myObj.nextInt();
			myObj.nextInt();
			Abonnement abo=obj.getAbonnementDAO().getById(id);
			System.out.println("Nouveau Debut de l'abonnement au format (YYYY-MM-DD hh:mm:ss) :");
			String Debut=myObj.nextLine();
			DateTimeFormatter Formatage1 = DateTimeFormatter.ofPattern("YYYY-MM-DD hh:mm:ss");
			LocalDateTime Date1=null;
			Date1 = LocalDateTime.parse(Debut, Formatage1);
			System.out.println("Nouvelle Fin de l'abonnement au format (YYYY-MM-DD hh:mm:ss) :");
			String Fin=myObj.nextLine();
			DateTimeFormatter Formatage2 = DateTimeFormatter.ofPattern("YYYY-MM-DD hh:mm:ss");
			LocalDateTime Date2=null;
			Date2 = LocalDateTime.parse(Fin, Formatage2);
			System.out.println("Nouveau Id du client :");
			int idclient=myObj.nextInt();
			myObj.nextLine();
			System.out.println("Nouvelle Id de la revue :");
			int idrevue=myObj.nextInt();
			myObj.nextLine();
			//abo.setDate_debut(Debut);
			//abo.setDate_debut(Fin);
			abo.setId_client(idclient);
			abo.setId_revue(idrevue);
			obj.getAbonnementDAO().update(abo);
			}
		
		else if(choix.equals("3")) {
			System.out.println("Entrez l'id de l'abonnement à supprimer");
			int id=myObj.nextInt();
			myObj.nextLine();
			obj.getAbonnementDAO().delete(obj.getAbonnementDAO().getById(id));
		}
		menu();
	}
}
