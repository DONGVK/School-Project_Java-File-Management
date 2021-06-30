package consol;
import java.util.Scanner;
import control.User;
import control.Admin;

public class Home extends Frame{
	
	public Home(Scanner sc, User user){
		super(sc, user);
	}
	
	public void main() {
		System.out.println(" ".repeat(5)+"+"+"-".repeat(50) + "+");
		System.out.println(" ".repeat(5)+"|" + " ".repeat(15) + "Bienvenue dans l'espace" + " ".repeat(11) +" |");
		System.out.println(" ".repeat(5)+"+"+"-".repeat(50)+"+");
		System.out.println("[User : " + this.getUser().getLogin() + ", id : " + this.getUser().getIdUser() +" ]\n");
		System.out.println(this.getUser().getClass());
		this.menus();
	}
	
	public void menus() {
		if(this.getUser() instanceof Admin) {
			while( !super.getExit()) {
				System.out.println("\n" + "-".repeat(25) + " MENUS " + "-".repeat(25));
				System.out.println("\n Veuillez saisir un entier : \n");
				System.out.println(" ".repeat(20) + "1.Consulter les documents");
				System.out.println(" ".repeat(20) +"2.Gestion utilisateur");
				System.out.println(" ".repeat(20) +"3.Deconnexion");
				
				System.out.print( "Choix : " );
		        int choice = Integer.parseInt(this.getSc().nextLine());
		        if( choice >= 1 && choice <= 3 ) {
		        	this.goTo(choice);
		        }else {
		        	while ( choice < 1 || choice > 3) {
		        		System.out.print( "Veuillez choisir une option valide : " );
		                choice = Integer.parseInt(this.getSc().nextLine());
		        	}
		        }
			}
		}else {
			while( !super.getExit()) {
				System.out.println("\n" + "-".repeat(25) + " MENUS " + "-".repeat(25));
				System.out.println("\n Veuillez saisir un entier : \n");
				System.out.println(" ".repeat(20) + "1.Consulter les documents");
				System.out.println(" ".repeat(20) +"2.Deconnexion");
				
				System.out.print( "Choix : " );
		        int choice = Integer.parseInt(this.getSc().nextLine());
		        while ( choice < 1 || choice > 2) {
		       		System.out.print( "Veuillez choisir une option valide : " );
		               choice = Integer.parseInt(this.getSc().nextLine());
		       	}
		        this.goTo(choice);
			}
		}
		
	}
	
	public void goTo(int i) {
		switch(i) {
		case 1 :
			ManageFile mf = new ManageFile(this.getSc(), this.getUser());
			mf.main();
			break;
		case 2 :
			ManageUser mu = new ManageUser(this.getSc(), this.getUser());
			mu.main();
			break;
		default :
			super.setExit(true);
			break;
		}
	}
}