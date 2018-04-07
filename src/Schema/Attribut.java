package Schema;
/*
 * 
 * 
 * */
public class Attribut<T> {
	private boolean estClePrimaire;
	private String nom;
	private T typeAttribut;

	public Attribut() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean getEstClePrimaire() {
		return this.estClePrimaire;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public T getTypeAttribut() {
		return this.typeAttribut;
	}
	
	public void setEstClePrimaire(boolean cle) {
		this.estClePrimaire = cle;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setTypeAttribut(T typeAttribut) {
		this.typeAttribut = typeAttribut;
	}
	
	
}
