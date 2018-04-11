package jus.aoo.sgbdComposants;

public class Attribut<T> {

    private String nom ;
    private boolean estClePrimaire;
    private T type;
    // enum pk ,fk ,others
    
    public Attribut(String nomAttribut , T type , boolean cle){
   	 this.nom = nomAttribut ;
   	 this.type = type ;
   	 this.estClePrimaire = cle ;
    }
   	 
    public String getNomAttribut(){
   	 return this.nom;
    }
    public T getTypeAttribut(){
   	 return this.type;
    }
    public boolean estCle(){
   	 return this.estClePrimaire;
    }
    public String to_String(){
   	 return "Attribut [ nom : "+this.nom+", estClePrimaire : "+this.estClePrimaire+ ", Type : "+this.type.toString()+" ]";   		 
    }
    
}

