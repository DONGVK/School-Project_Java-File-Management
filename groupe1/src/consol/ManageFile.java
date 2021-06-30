package consol;
import java.util.Scanner;

import javax.swing.JFileChooser;

import control.Admin;
import control.User;
public class ManageFile extends Frame{
	
	public ManageFile(Scanner sc, User user){
		super(sc, user);
	}
	
	public void main() {
		System.out.println(" ".repeat(5)+"+"+"-".repeat(58) + "+");
		System.out.println(" ".repeat(5)+"|" + " ".repeat(15) + "Bienvenue dans l'espace de dépôt" + " ".repeat(19) +" |");
		System.out.println(" ".repeat(5)+"+"+"-".repeat(58)+"+");
		System.out.println("[User : " + this.getUser().getLogin() + ", id : " + this.getUser().getIdUser() +" ]\n");
		while( !super.getExit()) {
			System.out.println("\n" + "-".repeat(25) + " MENUS " + "-".repeat(25));
			System.out.println("\n Veuillez saisir un entier : \n");
			System.out.println(" ".repeat(20) + "1.Sauvegarder un document");
			System.out.println(" ".repeat(20) +"2.Rechercher un document");
			System.out.println(" ".repeat(20) +"3.Imprimer un document");
			System.out.println(" ".repeat(20) +"4.Retour");
			
			System.out.print( "Choix : " );
	        int choice = Integer.parseInt(this.getSc().nextLine());
	        while ( choice < 1 || choice > 4) {
	       		System.out.print( "Veuillez choisir une option valide : " );
	            choice = Integer.parseInt(this.getSc().nextLine());
	       	}
	        this.goTo(choice);
		}
	}
	
	public void goTo(int i) {
		String description = "";
		String option = "";
		switch(i) {
		case 1 : //SAVE A FILE
			JFileChooser j = new JFileChooser();
			j.showSaveDialog(null); 
			System.out.println("Le fichier choisi est : " + j.getSelectedFile().getName());
			System.out.println("Voulez-vous sauvegarder ce document ?( o | n )");
			option = this.getSc().nextLine();
			option = option.toLowerCase();
			
			while( !(option.equals("o") || option.equals("n")) ) {
				System.out.println("Voulez-vous sauvegarder ce document ?( o | n )");
				option = this.getSc().nextLine();
				option = option.toLowerCase();
			}
			
			if(option == "oui" || option != "o") {
				System.out.println("Veuillez saisir la description");
				description = this.getSc().nextLine();
				this.getUser().saveFile(j.getSelectedFile().getAbsolutePath(), j.getSelectedFile().getName(), description, (float)j.getSelectedFile().length());
			}
			break;
		case 2 : // SEARCH A FILE
			break;
		case 3 : // PRINT A FILE
			break;
		default :
			this.setExit(true);
			break;
		}
	}
	
	
}