/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetmc;

/**
 *
 * @author ewtrh
 */
public class User {
    private String id_user;
    private String nom;
    private String prenom;
    private String password;
    private String email;
    //constructeur
    public User(){
        this.id_user="";
        this.nom="";
        this.prenom="";
        this.password="";
        this.email="";
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
    public String getEmail(){
        return this.email;
    }
     //setters
    public void setIdUser(String id_user){
        this.id_user=id_user;
    }
    public void setNom(String nom){
        this.nom=nom;
    }
    public void setPrenom(String prenom){
        this.prenom=prenom;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public void setEmail(String email){
        this.email=email;
    }
}
