package consol;
import java.util.Scanner;
import control.Admin;
import control.User;
public class ManageUser extends Frame{
	
	public ManageUser(Scanner sc, User user){
		super(sc, user);
	}
	
	public void main() {
		System.out.println(" ".repeat(5)+"+"+"-".repeat(50) + "+");
		System.out.println(" ".repeat(5)+"|" + " ".repeat(15) + "Bienvenue dans l'espace" + " ".repeat(11) +" |");
		System.out.println(" ".repeat(5)+"+"+"-".repeat(50)+"+");
		System.out.println("[User : " + this.getUser().getLogin() + ", id : " + this.getUser().getIdUser() +" ]\n");
		while( !super.getExit()) {
			System.out.println("\n" + "-".repeat(25) + " MENUS " + "-".repeat(25));
			System.out.println("\n Veuillez saisir un entier : \n");
			System.out.println(" ".repeat(20) + "1.Créer un nouvel utilisateur");
			System.out.println(" ".repeat(20) +"2.Supprimer un utilisateur");
			System.out.println(" ".repeat(20) +"3.Modifier un utilisateur");
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
		int id_user;
		String nom;
		String prenom;
		String login;
		String password;
		int id_role;
		switch(i) {
		case 1 :
			System.out.println("Veuillez saisir le nom");
			nom = this.getSc().nextLine();
			System.out.println("Veuillez saisir le prenom");
			prenom = this.getSc().nextLine();
			System.out.println("Veuillez saisir le login");
			login = this.getSc().nextLine();
			System.out.println("Veuillez saisir le mot de passe");
			password = this.getSc().nextLine();
			System.out.println("Veuillez saisir l'id role");
			id_role = Integer.parseInt(this.getSc().nextLine());
			((Admin) this.getUser()).createUser(nom, prenom, login, password, id_role);
			break;
		case 2 :
			System.out.println("Veuillez saisir l'id de l'utilisateur à supprimer");
			id_user = Integer.parseInt(this.getSc().nextLine());
			if(((Admin) this.getUser()).userExist(id_user)) {
				System.out.println("Voulez vous vraiment supprimé l'utilisateur avec l'id : " + id_user + " ? o/n");
				String choice = this.getSc().nextLine();
				while(!(choice.toLowerCase().equals("o")) && !(choice.toLowerCase().equals("n"))) {
					System.out.println("Voulez vous vraiment supprimé l'utilisateur : " + id_user + " ? o/n");
					choice = this.getSc().nextLine();
				}
				if(choice.toLowerCase().equals("o")) {
					((Admin) this.getUser()).deleteUser(id_user);
				}
			}
			break;
		default :
			this.setExit(true);
			break;
		}
	}
}