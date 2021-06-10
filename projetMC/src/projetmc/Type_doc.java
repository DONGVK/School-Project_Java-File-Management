package projetmc;

public class Type_doc {
    private String id_typed;
    private String libelle;
    
    public Type_doc(){
        this.id_typed="";
        this.libelle="";
    }
    //getters
    public String getIdTypeD(){
        return this.id_typed;
    }
    public String getLibelle(){
        return this.libelle;
    }
    
    //setters
    public void setIdTypeD(String id_typed){
        this.id_typed=id_typed;
    }
    public void setLibelle(String libelle){
        this.libelle=libelle;
    }
}
