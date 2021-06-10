package projetmc;

public class User {
    private String id_user;
    private String nom;
    private String prenom;
    private String password;
    private String login;
    
    //constructeur
    public User(){
        this.id_user="";
        this.nom="";
        this.prenom="";
        this.password="";
        this.login="";
    }
    //getters
    public String getIdUser(){
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

}
