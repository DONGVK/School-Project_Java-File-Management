package projetmc;
import java.util.Date;

/**
 *
 * @author ewtrh
 */
public class Document {
    private String id_doc;
    private String nom;
    private String description;
    private Date date;
    private Type_doc type;
    //constructeur
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
   //setters
    public void setIdDoc(String id_doc){
        this.id_doc=id_doc;
    }
    public void setNom(String nom){
        this.nom=nom;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public void setDate(Date date){
        this.date=date;
    }
    public void setType(Type_doc type){
        this.type=type;
    }
    
}
