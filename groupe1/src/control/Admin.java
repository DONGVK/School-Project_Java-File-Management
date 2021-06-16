package control;
import java.util.ArrayList;

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
	
	public void modifyUser(int id_user, int choice, String s) {
		switch (choice) {
		case 1 :
			try {
				ArrayList<String> ar  = DBConnection.selectUser(id_user);
				if(ar.size() <= 0) {
					System.out.println("L'utilisateur n'existe pas");
				}else {
					if(s != null) {
						if(!s.equals(ar.get(1))) {
							DBConnection.updateUserNom(id_user, s);
							System.out.println("Le nom est mis à jour.");
						}else {
							System.out.println("Le nouveau nom est le même que le nom actuel");
						}
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			break;
			
		case 2 :
			try {
				ArrayList<String> ar  = DBConnection.selectUser(id_user);
				if(ar.size() <= 0) {
					System.out.println("L'utilisateur n'existe pas");
				}else {
					if(s != null) {
						if(!s.equals(ar.get(2))) {
							DBConnection.updateUserPrenom(id_user, s);
							System.out.println("Le prenom est mis à jour.");
						}else {
							System.out.println("Le nouveau prenom est le même que le prenom actuel");
						}
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			break;
		case 3 :
			try {
				ArrayList<String> ar  = DBConnection.selectUser(id_user);
				if(ar.size() <= 0) {
					System.out.println("L'utilisateur n'existe pas");
				}else {
					if(s != null) {
						if(!s.equals(ar.get(3))) {
							System.out.println(ar.get(3));
							DBConnection.updateUserLogin(id_user, s);
							System.out.println("Le login est mis à jour.");
						}else {
							System.out.println("Le nouveau login est le même que le login actuel");
						}
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			break;
		case 4 :
			try {
				ArrayList<String> ar  = DBConnection.selectUser(id_user);
				if(ar.size() <= 0) {
					System.out.println("L'utilisateur n'e'xiste pas");
				}else {
					if(s != null) {
						s = MD5.getMd5(s);
						if(!MD5.matching(s, ar.get(4))) {
							DBConnection.updateUserPassword(id_user, s);
							System.out.println("Le mdp est mis à jour.");
						}else {
							System.out.println("Le nouveau mdp est le même que le mdp actuel");
						}
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			break;
		default :
			System.out.println("Erreur lors du choix");
		}
	}
	
	public void modifyUser(int id_user, int s) {
		try {
			ArrayList<String> ar  = DBConnection.selectUser(id_user);
			if(ar.size() <= 0) {
				System.out.println("L'utilisateur n'existe pas");
			}else {
				if(s > 0 || s <= 2) {
					if( s != Integer.parseInt(ar.get(5)) ){
						System.out.println(ar.get(5));
						DBConnection.updateUserIdRole(id_user, s);
						System.out.println("Le rôle est mis à jour.");
					}else {
						System.out.println("Le nouveau rôle est le même que le rôle actuel");
					}
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public boolean userExist(int id_user) {
		try {
			if(DBConnection.selectUser(id_user).size() <= 0) {
				return false;
			}
		}catch(ClassNotFoundException e) {
			System.out.println(e);
		}
		return true;
	}
	

	@Override
	public String toString() {
		return "Admin [getIdUser()=" + getIdUser() + ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom()
				+ ", getPassword()=" + getPassword() + ", getLogin()=" + getLogin() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + "]";
	}
	
	
}
