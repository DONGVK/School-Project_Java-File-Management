package consol;

import java.util.Scanner;
import control.Connection;

public class ProjetMC {
	private static boolean exit = false;
	public static Scanner sc = new Scanner(System.in);
	private static int choice;
	private static String login;
	private static String password;

    public static void main(String[] args) {

    		System.out.println( "*".repeat(44));
    		System.out.println( "* Creators : DONG *" );
    		System.out.println( "*".repeat(44));
    		while(!exit) {
    			System.out.println("\n Veuillez choisir parmis ses options (1/2) : \n"
    					+ "1.Se connecter \n"
    					+ "2.Fermer");
    			choice();
    		}
    		sc.close();
    }
   
    public static void choice() {
		System.out.print("Choix : ");
		choice = Integer.parseInt(sc.nextLine());
		
		while(choice != 1 && choice != 2) {
			System.out.print("Veuillez saisir un bon choix : ");
			choice = Integer.parseInt(sc.nextLine());
		}
		
		if(choice == 1){
			System.out.print( "Enter your login: " );
	        login = sc.nextLine();
	        System.out.print( "Enter your password: " );
	        password = sc.nextLine();
	        
	        Connection co = new Connection(login, password); // create a connexion session
	        
	        if(!(co.getConnect())) { //If the connexion is false
	        	while(!(co.getConnect())) {
	        		System.out.println("The identifiers are incorrect.");
	        		System.out.print( "Enter your login: " );
	                login = sc.nextLine();
	                System.out.print( "Enter your password: " );
	                password = sc.nextLine();
	                co = new Connection(login, password);
	        	}
	        }
	        Home home = new Home(sc, co.createSession());
	        home.main();
		}if(choice == 2 ){
			System.out.println("Voulez vous vraiment quitter ? (Oui/o | Non/n)");
			String q = sc.nextLine();
			q = q.toLowerCase();
			while(!(q == "oui" || q != "o" || q != "non" || q != "n")) {
				System.out.println("Voulez vous vraiment quitter ? (Oui/o | Non/n)");
				q = sc.nextLine().toLowerCase();
				q = q.toLowerCase();
			}
			if(q.equals("oui") || q.equals("o")) {
				System.out.println("Merci de votre visite !");
				System.exit(0);
			}
		}
	}
    
}
