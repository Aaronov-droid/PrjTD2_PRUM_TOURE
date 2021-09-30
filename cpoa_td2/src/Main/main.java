package Main;

import java.util.Scanner;

import fabrique.DAOFactory;
import dao.Persistance;
import fabrique.MySqlDAOFactory;

public class main {
	private static Scanner myObj = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fabrique.MySqlDAOFactory obj = null;
		Persistance n1 = null;
		DAOFactory.getDAOFactory(Persistance.valueOf("MYSQL"));
		System.out.println("Tapez: \n1 -pour etre en mode MYSQL\n2 - pour etre en mode ListeMemoire");
		String choix=myObj.nextLine();
		if(choix.equals("1"))new Menu(fabrique.DAOFactory.getDAOFactory(Persistance.valueOf("MySQL"))).menu();
		else if(choix.equals("2"))new Menu(fabrique.DAOFactory.getDAOFactory(Persistance.valueOf("LISTE_MEMOIRE"))).menu();
	}
}
