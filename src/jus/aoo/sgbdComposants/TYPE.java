
package jus.aoo.sgbdComposants;

public abstract class TYPE {
	
	/** 
	 * taille: définit l'espace mémoire qu'occupera 
	 * toute donnée des classes
	 * héritant de TYPE
	 **/
	
	protected int taille; 
	
	/**
	 * getTypeName(): Retourne le nom du type
	 */
	public abstract String getTypeName();
}
