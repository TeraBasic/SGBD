package jus.aoo.sgbdComposants;

import java.util.ArrayList;

import jus.aoo.sgbdComportements._Relation;

public abstract class Relation implements _Relation, _Schema{

	private final Schema schema;
	private final String nom_relation;
	private final int degre;
	ArrayList<_Tuple> tuples ;
	
	public Relation(String nom , Schema schema , int degre)
	{
		this.nom_relation = nom;
		this.degre = degre ;
		this.tuples = new ArrayList<_Tuple>();
		this.schema = schema ;
	}
	

	
}


