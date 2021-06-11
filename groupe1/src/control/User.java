package control;

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

}
