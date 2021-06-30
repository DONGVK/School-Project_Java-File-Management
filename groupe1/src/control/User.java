package control;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import db.DBConnection;

public class User {
    private int id_user;
    private String nom;
    private String prenom;
    private String password;
    private String login;
    
    //constructeur
    public User(){
        this.id_user= 0;
        this.nom="";
        this.prenom="";
        this.password="";
        this.login="";
    }
    
    public User(String login, String password){
        this.password= password;
        this.login=login;
        this.insertInformation();
    }
    
    //getters
    public int getIdUser(){
        return this.id_user;
    }
    public String getNom(){
        return this.nom;
    }
    public String getPrenom(){
        return this.prenom;
    }
    public String getPassword(){
        return this.password;
    }
    public String getLogin(){
        return this.login;
    }
    
    
    /***************
     *             
     * METHODS
     * 
    ***************/
    
    public void insertInformation() {
    	ArrayList<String> ar = new ArrayList<String>();
    	try {
    		ar = DBConnection.selectUser(this.login);
    	}catch(ClassNotFoundException e) {
    		System.out.println(e);
    	}
    	this.id_user = Integer.parseInt(ar.get(0));
    	this.nom = ar.get(1);
    	this.prenom = ar.get(2);
    	
    }

	@Override
	public String toString() {
		return "User [id_user=" + id_user + ", nom=" + nom + ", prenom=" + prenom + ", password=" + password
				+ ", login=" + login + "]";
	}
	
	public void saveFile(String path, String file_name, String description, float taille) {
		try {
			String extension = "";
			int index = file_name.lastIndexOf('.');
		    if(index > 0) {
		        extension = file_name.substring(index + 1);
		    }else {
		    	extension = file_name.substring(index);
		    }
			try {
				if(DBConnection.existsFile(path)) {
					if(!DBConnection.existsType(extension)) {
						DBConnection.insertType(extension);
						System.out.print("Nouvelle extension " + extension + " est crée.");
					}
					DBConnection.insertFile(file_name, taille, description, path, this.id_user, extension);
					FileWriter file = new FileWriter("./stock_file/"+file_name);
					file.write("h");
					file.close();
					Files.copy(Paths.get(path), Paths.get("./stock_file/"+file_name), StandardCopyOption.REPLACE_EXISTING);
					System.out.println("Le fichier a bien été sauvegardé.");
				}else {
					System.out.println("Le fichier existe déjà.");
				}
	    	}catch(ClassNotFoundException e) {
	    		System.out.println(e);
	    	}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
