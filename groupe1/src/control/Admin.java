package control;
import db.DBConnection;

public class Admin extends User{
    
	public Admin(String login, String password) {
		super(login, password);
	}
	
	public void createUser(String nom, String prenom, String login, String password, int role) {
		try {
			if(DBConnection.selectUser(login).size() > 0) {
				System.out.println("Login : " + login + " existe déjà.");
			}else {
				DBConnection.insertUser(nom, prenom, login, password, role);
				System.out.println("Utilisateur crée avec succès.");
			}
		}catch(ClassNotFoundException e) {
			System.out.println(e);
		}
	}
	
	public void deleteUser(int id) {
		try {
			if(DBConnection.selectUser(id).size() > 0) {
				DBConnection.deleteUser(id);
				System.out.println("Utilisateur supprimé avec succès.");
			}else {
				System.out.println("L'utilisateur n'existe pas.");
			}
		}catch(ClassNotFoundException e) {
			System.out.println(e);
		}
	}
	
	public void modifyUser(int id) {
		
	}

	@Override
	public String toString() {
		return "Admin [getIdUser()=" + getIdUser() + ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom()
				+ ", getPassword()=" + getPassword() + ", getLogin()=" + getLogin() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + "]";
	}
	
	
}
