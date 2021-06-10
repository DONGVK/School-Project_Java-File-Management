package main;
import java.util.Date;

public class Document {
    private String id_doc;
    private String nom;
    private String description;
    private Date date;
    private Type_doc type;
    private int id_user;
    
    //constructor
    public Document(){
        this.id_doc="";
        this.nom="";
        this.description="";
        this.date=new Date();
        this.type=new Type_doc();
    }
    
     //getters
    public String getIdDoc(){
        return this.id_doc;
    }
    public String getNom(){
        return this.nom;
    }
    public String getDescription(){
        return this.description;
    }
    public Date getDate(){
        return this.date;
    }
    public Type_doc getType(){
        return this.type;
    }

	public int getId_user() {
		return id_user;
	}

}
