package Main;

import java.util.Scanner;

import fabrique.DAOFactory;
import dao.Persistance;

public class Main {
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DAOFactory.getDAOFactory(Persistance.valueOf("MYSQL"));
		System.out.println("Tapez: \n1 -pour etre en mode MYSQL\n2 - pour etre en mode ListeMemoire");
		String choix=sc.nextLine();
		if(choix.equals("1"))new Menu(fabrique.DAOFactory.getDAOFactory(Persistance.valueOf("MySQL"))).menu();
		else if(choix.equals("2"))new Menu(fabrique.DAOFactory.getDAOFactory(Persistance.valueOf("LISTE_MEMOIRE"))).menu();
	}
}